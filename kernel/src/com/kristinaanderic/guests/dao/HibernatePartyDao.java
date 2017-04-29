package com.kristinaanderic.guests.dao;

import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.kristinaanderic.guests.Party;

/**
 * @author Eric Westfall
 * @created Aug 15, 2004
 */
public class HibernatePartyDao extends HibernateDaoSupport implements PartyDao {

	private static final String ALL_QUERY = "Party.all";
	private static final String BY_PASSWORD_QUERY = "Party.by.password";
	
	private static final String PASSWORD_PARAM = "password";

	public List findAll() {
		return getHibernateTemplate().findByNamedQuery(ALL_QUERY);
	}
	
	public Party findByPassword(String password) {
		if (password == null || password.equals("")) return null;
		List parties = getHibernateTemplate().findByNamedQuery(BY_PASSWORD_QUERY,
				PASSWORD_PARAM, password);
		if (parties == null || parties.size() == 0) return null;
		return (Party)parties.get(0);
	}
	
}
