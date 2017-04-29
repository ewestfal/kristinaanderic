package com.kristinaanderic.persistence.hibernate;

import java.io.Serializable;
import java.sql.SQLException;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * @author Eric Westfall
 * @created Aug 19, 2004
 */
public class IdentifierGenerator implements net.sf.hibernate.id.IdentifierGenerator {
	

	public Serializable generate(SessionImplementor session, Object object)
		throws SQLException, HibernateException
	{
		System.out.println("generating for: " + object);
		return null;
		//return Kernel.getCore().getPersistenceEngine().getIdentifierGenerator().generate();
	}

}
