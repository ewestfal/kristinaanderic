package com.kristinaanderic.guests;

import java.util.Date;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.kristinaanderic.test.Tester;

public class RsvpTester extends Tester {

	private Rsvp rsvp = new Rsvp();

    public RsvpTester(String name) {
        super(name);
    }

    public void testAttending() throws Exception {
		Session session = currentSession();
    	assertFalse(rsvp.isAttending());    	
    	session.save(rsvp);
    	Transaction transaction = session.beginTransaction();
    	rsvp.setAttending(true);
    	session.save(rsvp);
    	transaction.commit();
    	assertTrue(rsvp.isAttending());
		closeSession();
    }

	public void testNumAttending() throws Exception {
		Session session = currentSession();
		assertEquals(rsvp.getNumberAttending(), 0);
		session.save(rsvp);
		Transaction transaction = session.beginTransaction();
		rsvp.setNumberAttending(5);	
		session.save(rsvp);
		transaction.commit();
		assertEquals(rsvp.getNumberAttending(), 5);
		closeSession();
	}
	
	public void testResponseDate() throws Exception {
		Session session = currentSession();
		assertNotNull(rsvp.getResponseDate());
		Transaction transaction = session.beginTransaction();
		Date rightNow = new Date();
		rsvp.setResponseDate(rightNow);		
		session.save(rsvp);
		transaction.commit();
		assertEquals(rsvp.getResponseDate(), rightNow);
		closeSession();
	}
	
}
