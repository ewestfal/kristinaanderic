/*
 * Created on Feb 11, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.util;

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
		phoneNumber.save();
		assertEquals(phoneNumber.getAreaCode(), areaCode);
		assertEquals(phoneNumber.getPrefix(), prefix);
		assertEquals(phoneNumber.getPostfix(), postfix);
		assertEquals(phoneNumber.getExtension(), "");
		assertEquals(phoneNumber.getType(), PhoneNumberType.OTHER);
		
		PhoneNumber number2 = new PhoneNumber();
		number2.save();
		number2.setAreaCode("111");
		number2.setPrefix("111");
		number2.setPostfix("1111");
		number2.setExtension("123");
		number2.setType(PhoneNumberType.MOBILE);
		number2.save();
	}
	
	public void testAreaCode() throws Exception {
		assertEquals(phoneNumber.getAreaCode(), areaCode);
		phoneNumber.setAreaCode("321");
		phoneNumber.save();
		assertEquals(phoneNumber.getAreaCode(), "321");
	}
	
	public void testPrefix() throws Exception {
		assertEquals(phoneNumber.getPrefix(), prefix);
		phoneNumber.setPrefix("767");
		phoneNumber.save();
		assertEquals(phoneNumber.getPrefix(), "767");
	}
	
	public void testPostfix() throws Exception {
		assertEquals(phoneNumber.getPostfix(), postfix);
		phoneNumber.setPostfix("5321");
		phoneNumber.save();
		assertEquals(phoneNumber.getPostfix(), "5321");
	}
	
	public void testExtension() throws Exception {
		assertEquals(phoneNumber.getExtension(), "");
		phoneNumber.setExtension("abcdefg");
		phoneNumber.save();
		assertEquals(phoneNumber.getExtension(), "abcdefg");
	}

	public void testType() throws Exception {
		assertEquals(phoneNumber.getType(), PhoneNumberType.OTHER);
		phoneNumber.setType(PhoneNumberType.WORK);
		phoneNumber.save();
		assertEquals(phoneNumber.getType(), PhoneNumberType.WORK);
	}

}
