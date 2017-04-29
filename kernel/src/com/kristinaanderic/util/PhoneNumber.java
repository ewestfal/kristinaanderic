/*
 * Created on Jan 16, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.util;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.kristinaanderic.persistence.AbstractPersistable;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class PhoneNumber extends AbstractPersistable {

	private String areaCode = "";
	private String prefix = "";
	private String postfix = "";
	private String extension = "";
	private PhoneNumberType type = PhoneNumberType.OTHER;
	
	protected PhoneNumber() {}
	
	public PhoneNumber(String areaCode, String prefix, String postfix) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.postfix = postfix;
	}
	
	public String getAreaCode() {
		return this.areaCode;
	}
	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getPrefix() {
		return this.prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPostfix() {
		return this.postfix;
	}
	
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	
	public String getExtension() {
		return this.extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public PhoneNumberType getType() {
		return this.type;
	}
	
	public void setType(PhoneNumberType type) {
		this.type = type;
	}
	
	public boolean equals(Object object) {
		boolean isEquals = false;
		if (object instanceof PhoneNumber) {
			PhoneNumber number = (PhoneNumber)object;
			isEquals = new EqualsBuilder().append(areaCode, number.getAreaCode()).
				append(prefix, number.getPrefix()).
				append(postfix, number.getPostfix()).
				append(extension, number.getExtension()).
				append(type, number.getType()).isEquals();
		}
		return isEquals;
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(areaCode).
			append(prefix).append(postfix).
			append(extension).append(type).hashCode();
	}
	
	public String toString() {
		return getAreaCode()+"-"+getPrefix()+"-"+getPostfix();
	}

}
