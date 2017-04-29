/*
 * Created on Feb 10, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.util;

import net.sf.hibernate.PersistentEnum;

/**
 * FIXME: implement this sucker
 * 
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class PhoneNumberType implements PersistentEnum {

	public static final PhoneNumberType HOME = new PhoneNumberType("home");
	public static final PhoneNumberType WORK = new PhoneNumberType("work");
	public static final PhoneNumberType MOBILE = new PhoneNumberType("mobile");
	public static final PhoneNumberType OTHER = new PhoneNumberType("other");
	public static final PhoneNumberType UNKNOWN = new PhoneNumberType("unknown");

	public static final PhoneNumberType[] TYPES =
		{
			HOME, WORK, MOBILE, OTHER, UNKNOWN
		};
		
	private final String value;
	
	private PhoneNumberType(String value) {
		this.value = value;
	}

	public int toInt() {
		for (int index = 0; index < TYPES.length; index++) {
			if (TYPES[index] == this) return index;
		}
		return -1;
	}
	
	public static PersistentEnum fromInt(int value) {
		if (value < 0 || value >= TYPES.length) return null;
		return TYPES[value];
	}
	
}
