/*
 * Created on Aug 14, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.guests;

import com.kristinaanderic.datastore.DaoUtils;
import com.kristinaanderic.guests.dao.PartyDao;
import com.kristinaanderic.text.PasswordGenerator;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class PasswordAssigner {
	
	private static final int PASSWORD_LENGTH = 9;
	private PasswordGenerator generator = new PasswordGenerator();
	
	public void assignPassword(Party party, String password) {
		if (party == null) throw new IllegalArgumentException("Cannot assign password to null party.");
		if (password == null || password.equals("")) throw new IllegalArgumentException("Cannot assign empty password.");
		party.setPassword(password);
	}
	
	public void assignPassword(Party party) {
		if (party == null) throw new IllegalArgumentException("Cannot assign password to null party.");
		PartyDao dao = DaoUtils.getPartyDao();
		String generatedPassword = generator.generate(PASSWORD_LENGTH);
		Party partyWithPassword = dao.findByPassword(generatedPassword);
		if (partyWithPassword != null) {
			// try again
			assignPassword(party);
		} else {
			assignPassword(party, generatedPassword);
		}
	}
	
}
