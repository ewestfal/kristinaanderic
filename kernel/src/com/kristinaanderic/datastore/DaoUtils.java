/*
 * Created on Aug 14, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.datastore;

import com.kristinaanderic.core.Kernel;
import com.kristinaanderic.guests.dao.PartyDao;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class DaoUtils {
	
	private static final String PARTY = "partyDao";
	
	public static PartyDao getPartyDao() {
		return (PartyDao)getDao(PARTY);
	}
	
	public static Dao getDao(String daoName) {
		return (Dao)Kernel.getCore().getContext().getBean(daoName);
	}
	
}
