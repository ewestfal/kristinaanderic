package com.kristinaanderic.test;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

import com.javaranch.unittest.helper.sql.pool.JNDIUnitTestHelper;

public class Tester extends TestCase {

	private static SessionFactory sessionFactory;				
	private static final ThreadLocal session = new ThreadLocal();

	public Tester(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {
		if(JNDIUnitTestHelper.notInitialized()){
			JNDIUnitTestHelper.init("kernel/conf/jndi_unit_test_helper.properties");
		}

	}
	
    public static Session currentSession() throws HibernateException {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		Session s = (Session) session.get();
		// Open a new Session, if this Thread has none
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
			return s;
	}
	
	public static void closeSession()
				throws HibernateException {

		   Session s = (Session) session.get();
		   session.set(null);
		   if (s != null) s.close();
		}
	
}
