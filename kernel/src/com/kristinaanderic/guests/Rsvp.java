package com.kristinaanderic.guests;

import java.util.Date;

/**
 * Represents a response to an invitation.
 * 
 * @author Eric Westfall
 */
public class Rsvp {

	private Long id;
	private boolean isAttending = false;
	private int numberAttending = 0;
	private Date responseDate = new Date();
	
	public Long getId() {
		return this.id;
	}
	
	private void setId(Long id) {
		this.id = id;
	}
	
	public boolean isAttending() {
		return this.isAttending;
	}
	
	public void setAttending(boolean isAttending) {
		this.isAttending = isAttending;
	}
	
	public int getNumberAttending() {
		return this.numberAttending;
	}
	
	public void setNumberAttending(int numberAttending) {
		this.numberAttending = numberAttending;
	}

	public Date getResponseDate() {
		return this.responseDate;
	}
	
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	
}
