package com.kristinaanderic.guests;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kristinaanderic.persistence.AbstractPersistable;

/**
 * Represents a response to an invitation.
 * 
 * @author Eric Westfall
 */
public class Rsvp extends AbstractPersistable {

	private boolean isAttending = false;
	private Set attendingRespondants = new HashSet();
    private Date responseDate;
    private String comments = "";
	
	public boolean isAttending() {
		return this.isAttending;
	}
	
	public void setAttending(boolean isAttending) {
		this.isAttending = isAttending;
	}
	
	public Set getAttendingRespondants() {
		return attendingRespondants;
	}
	
	private void setAttendingRespondants(Set attendingRespondants) {
		this.attendingRespondants = attendingRespondants;
	}
	
	public int getNumberAttending() {
		return attendingRespondants.size();
	}
		
	public Date getResponseDate() {
		return this.responseDate;
	}
	
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	
	public boolean hasResponded() {
		return getResponseDate() != null;
	}
	
    public String getComments() {
        return comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }

}
