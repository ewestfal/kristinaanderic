package com.kristinaanderic.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import junit.framework.TestCase;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.orm.hibernate.SessionFactoryUtils;
import org.springframework.orm.hibernate.SessionHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.kristinaanderic.core.Kernel;
import com.kristinaanderic.persistence.PersistenceEngine;

public class Tester extends TestCase {

	private Session hibSession;
	private TransactionStatus transactionStatus;

	public Tester(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {
		clearTables();
		hibSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
		TransactionSynchronizationManager.bindResource(getSessionFactory(), new SessionHolder(hibSession));
		transactionStatus = getTransactionManager().getTransaction(new DefaultTransactionDefinition());
	}
	
	public void tearDown() throws Exception {
		getTransactionManager().commit(transactionStatus);
		TransactionSynchronizationManager.unbindResource(getSessionFactory());
		SessionFactoryUtils.closeSessionIfNecessary(hibSession, getSessionFactory()); 
	}
	
	protected PlatformTransactionManager getTransactionManager() {
		return (PlatformTransactionManager)Kernel.getCore().getContext().getBean("transactionManager"); 
	}
	
	protected SessionFactory getSessionFactory() {
		return (SessionFactory)Kernel.getCore().getContext().getBean("sessionFactory");
	}
	
	protected Session getHibernateSession() {
		return hibSession;
	}
	
	protected DataSource getDataSource() {
		return (DataSource)Kernel.getCore().getContext().getBean("dataSource");
	}
	
	protected TransactionTemplate getTransactionTemplate() {
		return new TransactionTemplate(getTransactionManager());
	}
	
	protected JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	protected void clearTables() {
		getTransactionTemplate().execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				return getJdbcTemplate().execute(new StatementCallback() {
					public Object doInStatement(Statement statement) throws SQLException {
						Connection connection = statement.getConnection();
			            DatabaseMetaData metaData = connection.getMetaData();
			            ResultSet tables = metaData.getTables(connection.getCatalog(), null, null, null);
			            while(tables.next()) {
			                String tableName = tables.getString("TABLE_NAME");                
			                statement.executeUpdate("TRUNCATE TABLE "+tableName);
			            }    
						return null;
					}
				});
			}
		});
	}
	
	protected PersistenceEngine getEngine() {
		return Kernel.getCore().getPersistenceEngine();
	}
	
}
