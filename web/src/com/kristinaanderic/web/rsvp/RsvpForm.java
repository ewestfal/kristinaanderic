/*
 * Created on Mar 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.kristinaanderic.web.rsvp;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.guests.Food;
import com.kristinaanderic.guests.Party;
import com.kristinaanderic.guests.Respondant;
import com.kristinaanderic.util.Name;

/**
 * @author ewestfal
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RsvpForm extends ActionForm {
    
    private static final org.apache.log4j.Logger LOGGER =
        org.apache.log4j.Logger.getLogger(RsvpForm.class);

	private static final int NAME_FIELDS = 8;
	
	private Party party;
	private String getAttending = "";
	private String[] firstNames = new String[NAME_FIELDS];
	private String[] lastNames = new String[NAME_FIELDS];
	private String[] meals = new String[NAME_FIELDS];
    private String comments = "";
	
	public Party getParty() {
		return party;
	}
	
	public void setParty(Party party) {
		this.party = party;
	}
	
	public String getAttending() {
		return getAttending;
	}
	
	public void setAttending(String getAttending) {
		this.getAttending = getAttending;
	}
	
	public String[] getFirstNames() {
		return firstNames;
	}

	public String[] getLastNames() {
		return lastNames;
	}
	
	public void setFirstNames(String[] firstNames) {
		this.firstNames = firstNames;
	}
	
	public void setLastNames(String[] lastNames) {
		this.lastNames = lastNames;
	}
	
	public String[] getMeals() {
		return meals;
	}
	
	public void setMeals(String[] meals) {
		this.meals = meals;
	}

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	    LOGGER.info(logPrefix(party)+"validating rsvp form, "+getAttending()+", "+getParty());
		ActionErrors errors = new ActionErrors();
		if (!getAttending().equals("true") && !getAttending().equals("false")) {
			errors.add("attending", new ActionError("message", "Please specify whether your party is attending or not."));
			LOGGER.info(logPrefix(party)+" isAttending was not specified");
		} 
		boolean allNamesEmpty = true;
		for (int index = 0; index < getLastNames().length; index++) {
			String firstName = getFirstNames()[index];
			String lastName = getLastNames()[index];
			String meal = getMeals()[index];
			if (!firstName.equals("") || !lastName.equals("")) {
				allNamesEmpty = false;
				if (meal.equals("")) { 
					errors.add("meal"+index, new ActionError("message", "Please select a meal option"));
					LOGGER.info(logPrefix(party)+"meal option was not selected at index "+index);
				}
			}
		}
		if (getAttending().equals("true") && allNamesEmpty) {
			errors.add("lastNames", new ActionError("message", "Please enter the names of those attending"));
			System.out.println("error two");
			LOGGER.info(logPrefix(party)+"no names were entered");
		}
		return errors;
	}
	
    public void clear() {
        party = null;
	getAttending = "";
	firstNames = new String[NAME_FIELDS];
	lastNames = new String[NAME_FIELDS];
	meals = new String[NAME_FIELDS];
        comments = "";
    }

	public void populate(Party party) {
            clear();
		setParty(party);
		Set respondants = party.getRsvp().getAttendingRespondants();
		String[] firstNames = getFirstNames();
		String[] lastNames = getLastNames();
		int index = 0;
		for (Iterator it = respondants.iterator(); it.hasNext();index++) {
			Respondant respondant = (Respondant)it.next();
			Name name = respondant.getName();
			String firstName = name.getFirstName();
			String lastName = name.getLastName();
			if (firstName == null) firstName = "";
			if (lastName == null) lastName = "";
			firstNames[index] = firstName;
			lastNames[index] = lastName;
			Food food = respondant.getFood();
			String foodValue = "";
			if (food != null) {
				foodValue = food.getValue();
			}
			meals[index] = foodValue;
		}
		boolean isAttending = party.getRsvp().isAttending();
		if (party.getRsvp().getResponseDate() == null) {
			setAttending("");
		} else if (!isAttending) {
			setAttending("false");
		} else {
			setAttending("true");
		}
                setComments(party.getRsvp().getComments());
	}

	private String logPrefix(Party party) {
	    String id = "null";
	    if (party != null) id = party.getId().toString();
	    return "[RSVP_FORM "+id+"] ";
	}
	
}
