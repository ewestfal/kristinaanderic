package com.kristinaanderic.util;

/**
 * A typesafe enumeration for the type of a PhoneNumber
 * 
 * @author Eric Westfall
 * @created Aug 19, 2004
 */
public class PhoneNumberType implements java.io.Serializable {
	
	private static final String HOME_VALUE = "home";
	private static final String MOBILE_VALUE = "mobile";
	private static final String OTHER_VALUE = "other";
	private static final String WORK_VALUE = "work";

	public static final PhoneNumberType HOME = new PhoneNumberType(HOME_VALUE);
	public static final PhoneNumberType MOBILE = new PhoneNumberType(MOBILE_VALUE);
	public static final PhoneNumberType OTHER = new PhoneNumberType(OTHER_VALUE);
	public static final PhoneNumberType WORK = new PhoneNumberType(WORK_VALUE);

	public static final PhoneNumberType[] TYPES =
		{
		HOME, WORK, MOBILE, OTHER
		};
		
	private final String value;
	
	private PhoneNumberType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static PhoneNumberType fromValue(String value) {
		for (int index = 0; index < TYPES.length; index++) {
			if (TYPES[index].getValue().equals(value)) return TYPES[index];
		}
		return null;
	}
	
}
