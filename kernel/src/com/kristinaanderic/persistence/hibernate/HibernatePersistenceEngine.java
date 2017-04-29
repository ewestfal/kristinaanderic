package com.kristinaanderic.persistence.hibernate;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

import org.springframework.orm.hibernate.HibernateCallback;

import com.kristinaanderic.persistence.IdentifierGenerator;
import com.kristinaanderic.persistence.Persistable;
import com.kristinaanderic.persistence.PersistenceEngine;

/**
 * Hibernate implementation of PersistenceEngine
 * 
 * @author Eric Westfall
 * @created Aug 19, 2004
 */
public class HibernatePersistenceEngine extends HibernateSupport implements PersistenceEngine {

	private SessionFactory sessionFactory;
	private IdentifierGenerator generator;
	
	public HibernatePersistenceEngine() {}
	
	public HibernatePersistenceEngine(SessionFactory sessionFactory) {//, IdentifierGenerator generator) {
		setSessionFactory(sessionFactory);
		//setIdentifierGenerator(generator);
	}
	
	public void save(Persistable persistable) {
		getHibernateTemplate().saveOrUpdate(persistable);
	}

	public void delete(Persistable persistable) {
		getHibernateTemplate().delete(persistable);
	}

	public Persistable load(Long id, Class persistableClass) {
		return (Persistable)getHibernateTemplate().load(persistableClass, id);
	}

	public void flush() {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				session.flush();
				return null;
			}
		});
	}
	
	public void refresh(final Persistable persistable) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				session.refresh(persistable);
				return null;
			}
		});
	}
	
	/**
	 * Returns the Hibernate SessionFactory.
	 */
	public Object getNativeEngine() {
		return getSessionFactory();
	}
	
	/*public IdentifierGenerator getIdentifierGenerator() {
		return generator;
	}
	
	public void setIdentifierGenerator(IdentifierGenerator generator) {
		this.generator = generator;
	}*/

}
