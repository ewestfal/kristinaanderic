package com.kristinaanderic.guests;

import java.util.Date;

import com.kristinaanderic.test.Tester;

public class RsvpTester extends Tester {

	private Rsvp rsvp = new Rsvp();

    public RsvpTester(String name) {
        super(name);
    }

    public void testAttending() throws Exception {
    	assertFalse(rsvp.isAttending());    	
    	rsvp.save();
    	rsvp.setAttending(true);
    	rsvp.save();
    	assertTrue(rsvp.isAttending());
    }

	public void testNumAttending() throws Exception {
		assertEquals(rsvp.getNumberAttending(), 0);
		rsvp.save();
		rsvp.setNumberAttending(5);	
		rsvp.save();
		assertEquals(rsvp.getNumberAttending(), 5);
	}
	
	public void testResponseDate() throws Exception {
		assertNotNull(rsvp.getResponseDate());
		Date rightNow = new Date();
		rsvp.setResponseDate(rightNow);		
		rsvp.save();
		assertEquals(rsvp.getResponseDate(), rightNow);
	}
	
}
