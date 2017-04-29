package com.kristinaanderic.guests;

import java.util.List;

import com.kristinaanderic.test.Tester;
import com.kristinaanderic.util.ContactInformation;
import com.kristinaanderic.util.Name;

public class PartyTester extends Tester {

    public PartyTester(String name) {
        super(name);
    }

    /*
    public void testCrap2() throws Exception {
    	Session session = getSessionFactory().openSession();
    	Transaction transaction = session.beginTransaction();
    	Party party = new Party();;
    	session.save(party);
    	Name name = new Name("crap","name");
    	party.addName(name);
    	session.save(name);
    	session.update(party);
    	transaction.commit();
    	session.close();
    	assertEquals(1, party.getNames().size());
    	assertTrue(party.getNames().contains(name));
    	session = getSessionFactory().openSession();
    	transaction = session.beginTransaction();
    	party = (Party)session.load(Party.class, party.getId());
    	assertNotNull(party);
    	assertEquals(1, party.getNames().size());
    	transaction.commit();
    	session.close();
    }
    
    public void testCrap() throws Exception {
    	Party party = new Party("party1");
    	party.setRsvp(null);
    	party.setContactInformation(null);
    	Name name = new Name("name","one");
    	party.save();
    	name.save();
    	getEngine().flush();
    	party.addName(name);
    	getEngine().flush();
    	assertEquals(1, party.getNames().size());
    	assertTrue(party.getNames().contains(name));
    	getEngine().refresh(party);
    	assertEquals(1, party.getNames().size());
    	assertTrue(party.getNames().contains(name));
    	getEngine().flush();
    }
    */
    
    public void testNames() throws Exception {
        Party party1 = new Party("partyName");
        Name name1 = new Name("Eric", "Westfall");
        Name name2 = new Name("Kristina", "Stine");
        Name name3 = new Name("Reginald", "Rutherford", "Montgomery");
        name1.save();
        name2.save();
        name3.save();
        party1.save();
        getEngine().flush();
        party1.addName(name1);
        party1.addName(name2);
        party1.addName(name3);
        assertEquals(3, party1.getSize());
        boolean removed1 = party1.removeName(name1);
        assertTrue(removed1);
        assertEquals(2, party1.getSize());
        List names = party1.getNames();
        assertNotNull(names);
        party1.save();
        getEngine().flush();
        assertEquals(2, party1.getSize());
        getEngine().refresh(party1);
        assertEquals(2, party1.getSize());
    }

	public void testAddName() throws Exception {
		Party party = new Party("partyName");
		Name name1 = new Name("My", "Name");
		Name name2 = new Name("First", "Middle", "Last");
		party.addName(name1);
		party.addName(name2);
		party.save();	
	}
	
	public void testRemoveName() throws Exception {
		Party party = new Party("partyName");
		Name name1 = new Name("My", "Name");
		Name name2 = new Name("First", "Middle", "Last");
		party.addName(name1);
		party.addName(name2);
		party.save();
		assertTrue(party.getNames().size() == 2);
		party.removeName(name1);
		party.save();
		assertTrue(party.getNames().size() == 1);
	}
	
	public void testContactInformation() throws Exception {
		Party party = new Party("partyName");
		assertNotNull(party.getContactInformation());
		ContactInformation contactInfo = new ContactInformation();
		party.setContactInformation(contactInfo);
		party.save();
		assertEquals(party.getContactInformation(), contactInfo);
	}
	

	/*public void testRsvp() throws Exception {
		Party party = new Party("partyName");
		assertNotNull(party.getRsvp());
		Rsvp rsvp = new Rsvp();
		rsvp.setAttending(true);
		rsvp.setNumberAttending(1);
		rsvp.setResponseDate(new Date());
		party.setRsvp(rsvp);
		party.save();
		assertEquals(party.getRsvp(), rsvp);
	}*/

}
