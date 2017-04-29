/*
 * Created on Mar 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.kristinaanderic.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.kristinaanderic.guests.Party;

/**
 * @author ewestfal
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UpdatePartyForm extends ActionForm {

	private static final int NAME_FIELDS = 8;
	
	private Party party;
	private String mode = "";
	
	private String partyName = "";
	/*
	private String[] firstNames = new String[NAME_FIELDS];
	private String[] middleNames = new String[NAME_FIELDS];
	private String[] lastNames = new String[NAME_FIELDS];
	
	private String streetAddress1 = "";
	private String streetAddress2 = "";
	private String city = "";
	private String state = "";
	private String zipCode = "";
	
	private String phoneNumber1 = "";
	private String phoneNumber1Type = "";
	private String phoneNumber2 = "";
	private String phoneNumber2Type = "";
	*/
	
	public Party getParty() {
		return party;
	}
	
	public void setParty(Party party) {
		this.party = party;
	}

	/*
	public String getCity() {
		return city;
	}*/

	public String getMode() {
		return mode;
	}

/*	public String[] getFirstNames() {
		return firstNames;
	}

	public String[] getMiddleNames() {
		return middleNames;
	}

	public String[] getLastNames() {
		return lastNames;
	}
*/	

	public String getPartyName() {
		return partyName;
	}

/*	*//**
	 * @return
	 *//*
	public String getState() {
		return state;
	}

	*//**
	 * @return
	 *//*
	public String getStreetAddress1() {
		return streetAddress1;
	}

	*//**
	 * @return
	 *//*
	public String getStreetAddress2() {
		return streetAddress2;
	}

	*//**
	 * @return
	 *//*
	public String getZipCode() {
		return zipCode;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	
	public String getPhoneNumber1Type() {
		return phoneNumber1Type;
	}
	
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	
	public String getPhoneNumber2Type() {
		return phoneNumber2Type;
	}
	
	
	*//**
	 * @param string
	 *//*
	public void setCity(String city) {
		this.city = city;
	}
*/
	/**
	 * @param string
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
/*
	*//**
	 * @param string
	 *//*
	public void setFirstNames(String[] firstNames) {
		this.firstNames = firstNames;
	}
	
	public void setMiddleNames(String[] middleNames) {
		this.middleNames = middleNames;
	}

	public void setLastNames(String[] lastNames) {
		this.lastNames = lastNames;
	}
*/
	/**
	 * @param string
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
/*
	*//**
	 * @param string
	 *//*
	public void setState(String state) {
		this.state = state;
	}

	*//**
	 * @param string
	 *//*
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	*//**
	 * @param string
	 *//*
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	*//**
	 * @param string
	 *//*
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	
	public void setPhoneNumber1Type(String phoneNumber1Type) {
		this.phoneNumber1Type = phoneNumber1Type;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	
	public void setPhoneNumber2Type(String phoneNumber2Type) {
		this.phoneNumber2Type = phoneNumber2Type;
	}
*/
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {		
		ActionErrors errors = new ActionErrors();
		if (getMode() == null) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionMessage("message", "Invalid Mode"));
		} 
		if (getPartyName() == null || getPartyName().equals("")) {
			errors.add("partyName", new ActionMessage("errors.required", "Party name"));
		}
		/*String[] firstNames = getFirstNames();
		String[] lastNames = getLastNames();
		boolean nameEntered = false;
		for (int index = 0; index < lastNames.length; index++) {
			String firstName = firstNames[index];
			String lastName = lastNames[index];
			if (firstName != null && !firstName.equals("") &&
			    lastName != null && !lastName.equals("")) {
				nameEntered = true;
				break;
			}
		}
		if (!nameEntered) {
			errors.add("firstNames", new ActionMessage("errors.required", "At least one name"));
		}		*/
		return errors;
		
	}
	
	public void populate(Party party) {
		setParty(party);
		setPartyName(party.getPartyName());
/*		List names = party.getNames();
		String[] firstNames = getFirstNames();
		String[] middleNames = getMiddleNames();
		String[] lastNames = getLastNames();
		int index = 0;
		for (Iterator it = names.iterator(); it.hasNext();index++) {
			Name name = (Name)it.next();
			String firstName = name.getFirstName();
			String middleName = name.getMiddleName();
			String lastName = name.getLastName();
			if (firstName == null) firstName = "";
			if (middleName == null) middleName = "";
			if (lastName == null) lastName = "";
			firstNames[index] = firstName;
			middleNames[index] = middleName;
			lastNames[index] = lastName;
		}
		ContactInformation info = party.getContactInformation();
		if (info != null) {
			Address address = info.getAddress();
			if (address != null) {
				setStreetAddress1(address.getStreetAddress1());
				setStreetAddress2(address.getStreetAddress2());
				setCity(address.getCity());
				setState(address.getState().getAbbreviation());
				setZipCode(address.getZipcode());
			}
			List numbers = info.getPhoneNumbers();
			if (numbers != null && numbers.size() > 0) {
				PhoneNumber number = (PhoneNumber)numbers.get(0);
				setPhoneNumber1(number.toString());
				setPhoneNumber1Type(number.getType().getValue());
			} if (numbers != null && numbers.size() > 1) {
				PhoneNumber number = (PhoneNumber)numbers.get(1);
				setPhoneNumber2(number.toString());
				setPhoneNumber2Type(number.getType().getValue());
			}
		}
*/	}

}
