/*
 * Created on Feb 11, 2004
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
public class PhoneNumberTester extends Tester {

	private PhoneNumber phoneNumber;
	private String areaCode = "812";
	private String prefix = "555";
	private String postfix = "5555";

	public PhoneNumberTester(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {
		super.setUp();
		phoneNumber = new PhoneNumber(areaCode, prefix, postfix);
	}
	
	public void testConstructors() throws Exception {
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(phoneNumber);
		transaction.commit();
		assertEquals(phoneNumber.getAreaCode(), areaCode);
		assertEquals(phoneNumber.getPrefix(), prefix);
		assertEquals(phoneNumber.getPostfix(), postfix);
		assertEquals(phoneNumber.getExtension(), "");
		assertEquals(phoneNumber.getType(), PhoneNumberType.UNKNOWN);
		
		PhoneNumber number2 = new PhoneNumber();
		transaction = session.beginTransaction();
		session.save(number2);
		transaction.commit();
		number2.setAreaCode("111");
		number2.setPrefix("111");
		number2.setPostfix("1111");
		number2.setExtension("123");
		number2.setType(PhoneNumberType.MOBILE);
		transaction = session.beginTransaction();
		session.save(number2);
		transaction.commit();
		closeSession();
	}
	
	public void testAreaCode() throws Exception {
		assertEquals(phoneNumber.getAreaCode(), areaCode);
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		phoneNumber.setAreaCode("321");
		session.save(phoneNumber);
		assertEquals(phoneNumber.getAreaCode(), "321");
		closeSession();
	}
	
	public void testPrefix() throws Exception {
		assertEquals(phoneNumber.getPrefix(), prefix);
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		phoneNumber.setPrefix("767");
		session.save(phoneNumber);
		assertEquals(phoneNumber.getPrefix(), "767");
		closeSession();
	}
	
	public void testPostfix() throws Exception {
		assertEquals(phoneNumber.getPostfix(), postfix);
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		phoneNumber.setPostfix("5321");
		session.save(phoneNumber);
		assertEquals(phoneNumber.getPostfix(), "5321");
		closeSession();
	}
	
	public void testExtension() throws Exception {
		assertEquals(phoneNumber.getExtension(), "");
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		phoneNumber.setExtension("abcdefg");
		session.save(phoneNumber);
		assertEquals(phoneNumber.getExtension(), "abcdefg");
		closeSession();
	}

	public void testType() throws Exception {
		assertEquals(phoneNumber.getType(), PhoneNumberType.UNKNOWN);
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		phoneNumber.setType(PhoneNumberType.WORK);
		session.save(phoneNumber);
		assertEquals(phoneNumber.getType(), PhoneNumberType.WORK);
		closeSession();
	}

}
