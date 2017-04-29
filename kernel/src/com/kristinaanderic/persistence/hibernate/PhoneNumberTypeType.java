package com.kristinaanderic.persistence.hibernate;

import com.kristinaanderic.util.PhoneNumberType;

public class PhoneNumberTypeType extends StringEnumType {

	public Class returnedClass() {
		return PhoneNumberType.class;
	}
	
	protected Object stringToEnum(String value) {
		return PhoneNumberType.fromValue(value);
	}
	
	protected String enumToString(Object enumValue) {
		return ((PhoneNumberType)enumValue).getValue();
	}
	
}
