/*
 * Created on Jan 16, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.util;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class PhoneNumber {

	private Long id;
	private String areaCode = "";
	private String prefix = "";
	private String postfix = "";
	private String extension = "";
	private PhoneNumberType type = PhoneNumberType.UNKNOWN;
	
	public PhoneNumber() {
	}
	
	public PhoneNumber(String areaCode, String prefix, String postfix) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.postfix = postfix;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

}
