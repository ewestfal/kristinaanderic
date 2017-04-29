package com.kristinaanderic.accounts;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.kristinaanderic.guests.Party;
import com.kristinaanderic.test.Tester;

/**
 * @author Eric Westfall
 */
public class UserAccountTester extends Tester {

	private UserAccount userAccount;
	
	public UserAccountTester(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {
		super.setUp();
		userAccount = new UserAccount("userName", "password", new Party());
	}
	
	public void testPersistence() throws Exception {
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(userAccount);
		transaction.commit();
		closeSession();		
	}

}
