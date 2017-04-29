package com.kristinaanderic.persistence.hibernate;

import com.kristinaanderic.util.USState;

public class USStateType extends StringEnumType {

	public Class returnedClass() {
		return USState.class;
	}
	
	protected Object stringToEnum(String value) {
		return USState.fromValue(value);
	}
	
	protected String enumToString(Object enumValue) {
		return ((USState)enumValue).getValue();
	}
	
}
