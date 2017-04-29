package com.kristinaanderic.persistence;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

public class Hibernate {
	
	private static SessionFactory sessionFactory;
				
    public static final ThreadLocal session = new ThreadLocal();

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
