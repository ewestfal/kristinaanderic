package com.kristinaanderic.guests;

import java.util.ArrayList;
import java.util.List;

import com.kristinaanderic.util.ContactInformation;
import com.kristinaanderic.util.Name;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Party {
	
	private Long id;
	private String partyName;
    private List names = new ArrayList();
    private Rsvp rsvp = new Rsvp();
    private ContactInformation contactInformation = new ContactInformation();
     
    private Party() {}
    
    public Party(String partyName) {
    	setPartyName(partyName);
    }
        
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getPartyName() {
    	return this.partyName;
    }
    
    public void setPartyName(String partyName) {
    	this.partyName = partyName;
    }
    
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
    	this.names = names;
    }

    public int getSize() {
        return names.size();
    }
    
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
