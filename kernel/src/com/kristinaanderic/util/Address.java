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
public class Address {
    
    private Long id;
    private String streetAddress1 = "";
    private String streetAddress2 = "";
    private String city = "";
    private USState state = USState.NONE;
    private String zipcode = "";

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStreetAddress1() {
        return streetAddress1;
    }
    
    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }
    
    public String getStreetAddress2() {
        return streetAddress2;
    }
    
    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public USState getState() {
    	return this.state;
    }
    
    public void setState(USState state) {
    	this.state = state;
    }
}
