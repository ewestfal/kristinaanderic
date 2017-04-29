package com.kristinaanderic.persistence;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Generic Identifer class, basically just a wrapper around a long ;)
 * 
 * @author Eric Westfall
 * @created Aug 19, 2004
 */
public class Identifier implements java.io.Serializable {

	private final long value;
	private final int hashCode;
	
	public Identifier(long value) {
		this.value = value;
		this.hashCode = new HashCodeBuilder().append(value).hashCode();
	}
	
	public Identifier(String value) throws NumberFormatException {
		this(Integer.parseInt(value));
	}
	
	public long getValue() {
		return value;
	}
	
	public boolean equals(Object object) {
		if (object instanceof Identifier) {
			Identifier id = (Identifier)object;
			return id.getValue() == value;
		}
		return false;
	}
	
	public int hashCode() {
		return hashCode; 
	}

}
