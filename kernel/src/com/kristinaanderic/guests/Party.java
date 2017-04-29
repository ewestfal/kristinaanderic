package com.kristinaanderic.guests;

import java.util.ArrayList;
import java.util.List;

import com.kristinaanderic.persistence.AbstractPersistable;
import com.kristinaanderic.util.ContactInformation;
import com.kristinaanderic.util.Name;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Party extends AbstractPersistable {
	
	private String partyName;
	private String password;
    //private List names = new ArrayList();
    private Rsvp rsvp = new Rsvp();
    private ContactInformation contactInformation = new ContactInformation();
     
    protected Party() {}
    
    public Party(String partyName) {
    	setPartyName(partyName);
    	//names = new ArrayList();
    }
        
    public String getPartyName() {
    	return this.partyName;
    }
    
    public void setPartyName(String partyName) {
    	this.partyName = partyName;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    /*
    public void addName(Name name) {
        names.add(name);
    }
    
    public boolean removeName(Name name) {
        return names.remove(name);
    }
    
    public List getNames() {
        return names;
    }
    
    private void setNames(List names) {
    	System.out.println("setting names: " + names.size()+","+names.getClass());
    	this.names = names;
    }

    public int getSize() {
        return names.size();
        }*/
    
    public ContactInformation getContactInformation() {
    	return contactInformation;	
    }
    
    public void setContactInformation(ContactInformation contactInformation) {
    	this.contactInformation = contactInformation;
    }
    
    public Rsvp getRsvp() {
    	return this.rsvp;
    }
    
    public void setRsvp(Rsvp rsvp) {
    	this.rsvp = rsvp;
    }
    
}
