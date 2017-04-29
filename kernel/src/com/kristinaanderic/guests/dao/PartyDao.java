/*
 * Created on Aug 14, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.guests.dao;

import java.util.List;

import com.kristinaanderic.datastore.Dao;
import com.kristinaanderic.guests.Party;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public interface PartyDao extends Dao {
	
	public List findAll();
	
	public Party findByPassword(String password);
	
}
