package com.kristinaanderic.persistence.hibernate;

import com.kristinaanderic.guests.Food;

public class FoodType extends StringEnumType {

	public Class returnedClass() {
		return Food.class;
	}
	
	protected Object stringToEnum(String value) {
		return Food.fromValue(value);
	}
	
	protected String enumToString(Object enumValue) {
		return ((Food)enumValue).getValue();
	}
	
}
