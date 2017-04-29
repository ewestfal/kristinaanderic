/*
 * Created on Dec 2, 2003
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.util;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.kristinaanderic.test.Tester;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class NameTester extends Tester {

	private Name name;
	private String firstName = "first";
	private String middleName = "m";
	private String lastName = "last";

	public NameTester(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {
		super.setUp();
		name = new Name(firstName, middleName, lastName);
	}
	
	public void testPersistence() throws Exception {
		Session session = currentSession();
	    Transaction transaction = session.beginTransaction();
		session.save(name);
		transaction.commit();		
		closeSession();	
	}
	
}
