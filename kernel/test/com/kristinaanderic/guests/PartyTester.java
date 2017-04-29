package com.kristinaanderic.guests;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.kristinaanderic.test.Tester;
import com.kristinaanderic.util.ContactInformation;
import com.kristinaanderic.util.Name;

public class PartyTester extends Tester {

    public PartyTester(String name) {
        super(name);
    }

    public void testNames() throws Exception {
        Party party1 = new Party();
        Name name1 = new Name("Eric", "Westfall");
        Name name2 = new Name("Kristina", "Stine");
        Name name3 = new Name("Reginald", "Rutherford", "Montgomery");
        party1.addName(name1);
        party1.addName(name2);
        party1.addName(name3);
        assertTrue(party1.getSize() == 3);
        boolean removed1 = party1.removeName(name1);
        assertTrue(removed1);
        assertTrue(party1.getSize() == 2);
        List names = party1.getNames();
        assertNotNull(names);
    }

	public void testAddName() throws Exception {
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		Party party = new Party();
		Name name1 = new Name("My", "Name");
		Name name2 = new Name("First", "Middle", "Last");
		party.addName(name1);
		party.addName(name2);	
		session.save(party);
		transaction.commit();
		closeSession();
	}
	
	public void testRemoveName() throws Exception {
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		Party party = new Party();
		Name name1 = new Name("My", "Name");
		Name name2 = new Name("First", "Middle", "Last");
		party.addName(name1);
		party.addName(name2);
		session.save(party);
		transaction.commit();
		transaction = session.beginTransaction();
		assertTrue(party.getNames().size() == 2);
		party.removeName(name1);
		session.save(party);
		assertTrue(party.getNames().size() == 1);
		transaction.commit();
		closeSession();
	}
	
	public void testContactInformation() throws Exception {
		Party party = new Party();
		assertNotNull(party.getContactInformation());
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		ContactInformation contactInfo = new ContactInformation();
		party.setContactInformation(contactInfo);
		session.save(party);
		transaction.commit();
		assertEquals(party.getContactInformation(), contactInfo);
		closeSession();
	}
	
	public void testRsvp() throws Exception {
		Party party = new Party();
		assertNotNull(party.getRsvp());
		Session session = currentSession();
		Transaction transaction = session.beginTransaction();
		Rsvp rsvp = new Rsvp();
		rsvp.setAttending(true);
		rsvp.setNumberAttending(1);
		rsvp.setResponseDate(new Date());
		party.setRsvp(rsvp);
		session.save(party);
		transaction.commit();
		assertEquals(party.getRsvp(), rsvp);
		closeSession();
	}

}
