/*
 * Created on Jan 16, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ContactInformation {
	
	private Long id;
	private Address address = new Address();
	private List phoneNumbers = new ArrayList();
		
	public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List getPhoneNumbers() {
		return phoneNumbers;
	}
	
	private void setPhoneNumbers(List phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		phoneNumbers.add(phoneNumber);
	}
	
	public void removePhoneNumber(PhoneNumber phoneNumber) {
		phoneNumbers.remove(phoneNumber);
	}

}
