package com.kristinaanderic.accounts;

import com.kristinaanderic.guests.Party;

public class UserAccount {

	private Long id;
    private String userName;
    private String password;
    private Party party;

	public UserAccount() {
		this("", "", null);
	}

    public UserAccount(String userName, String password, Party party) {
        setUserName(userName);
        setPassword(password);
        setParty(party);
    }

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public Party getParty() {
        return this.party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

}
