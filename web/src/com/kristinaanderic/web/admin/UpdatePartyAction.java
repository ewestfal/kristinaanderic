/*
 * Created on Mar 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.kristinaanderic.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.kristinaanderic.core.Kernel;
import com.kristinaanderic.guests.Party;
import com.kristinaanderic.guests.PasswordAssigner;
import com.kristinaanderic.persistence.PersistenceEngine;
import com.kristinaanderic.web.WebConstants;
import com.kristinaanderic.web.WebUtils;

/**
 * @author ewestfal
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UpdatePartyAction extends Action {

	public ActionForward execute(
		final ActionMapping mapping,
		final ActionForm form,
		final HttpServletRequest request,
		final HttpServletResponse response)
		throws Exception {
			getTransactionTemplate().execute(new TransactionCallback() {
				public Object doInTransaction(TransactionStatus status) {
					UpdatePartyForm updateForm = (UpdatePartyForm)form;					
					Party party = getParty(updateForm, request.getSession());
					if (party == null) throw new RuntimeException("Invalid party");
					updatePartyName(party, updateForm);
					//updateNames(party, updateForm);
					//updateAddress(party, updateForm);
					//updatePhoneNumbers(party, updateForm);
					party.save();
					getEngine().flush();
					request.getSession().setAttribute(WebConstants.OPENED_PARTY, party);
					return null;
				}
			});
			return mapping.findForward(WebConstants.SUCCESS_FORWARD);
	}
	
	private Party getParty(UpdatePartyForm form, HttpSession session) {
		Party party = null;
		if (form.getMode().equals(WebConstants.EDIT_MODE)) {
			party = (Party)WebUtils.getPersistable(Party.class, WebConstants.OPENED_PARTY, session);
		} else if (form.getMode().equals(WebConstants.CREATE_MODE)) {
			party = new Party(form.getPartyName());
			new PasswordAssigner().assignPassword(party);
		} else {
			throw new RuntimeException("Invalid mode: " + form.getMode());
		}
		return party;
	}
	
	private void updatePartyName(Party party, UpdatePartyForm form) {
		String partyName = form.getPartyName();
		party.setPartyName(partyName);
	}
	
	/*private void updateNames(Party party, UpdatePartyForm form) {
		List currentNames = party.getNames();
		List names = extractNames(form.getFirstNames(), form.getMiddleNames(), form.getLastNames());
		List namesToRemove = ListUtils.subtract(currentNames, names);
		currentNames.removeAll(namesToRemove);
		List namesToAdd = ListUtils.subtract(names, currentNames);
		currentNames.addAll(namesToAdd);
	}
		
	private void updateAddress(Party party, UpdatePartyForm form) {
		String streetAddress1 = form.getStreetAddress1();
		String streetAddress2 = form.getStreetAddress2();
		String city = form.getCity();
		String state = form.getState();
		String zipCode = form.getZipCode();
		USState usState = USState.fromValue(state);
		
		if (party.getContactInformation() == null) party.setContactInformation(new ContactInformation());
		if (party.getContactInformation().getAddress() == null) party.getContactInformation().setAddress(new Address());
		Address address = party.getContactInformation().getAddress();
		address.setStreetAddress1(streetAddress1);
		address.setStreetAddress2(streetAddress2);
		address.setCity(city);
		address.setState(usState);
		address.setZipcode(zipCode);
	}
	
	private void updatePhoneNumbers(Party party, UpdatePartyForm form) {
		ContactInformation info = party.getContactInformation();
		List currentNumbers = info.getPhoneNumbers();
		String phoneNumber1 = form.getPhoneNumber1();
		String phoneNumber2 = form.getPhoneNumber2();
		PhoneNumber number1 = PhoneNumberParser.parse(phoneNumber1);
		PhoneNumber number2 = PhoneNumberParser.parse(phoneNumber2);
		List phoneNumbers = new ArrayList();
		if (number1 != null) phoneNumbers.add(number1);
		if (number2 != null) phoneNumbers.add(number2);
		List toRemove = ListUtils.subtract(currentNumbers, phoneNumbers);
		currentNumbers.removeAll(toRemove);
		List toAdd = ListUtils.subtract(phoneNumbers, currentNumbers);
		currentNumbers.addAll(toAdd);
	}			

	private List extractNames(String[] firstNames, String[] middleNames, String[] lastNames) {
		List nameList = new ArrayList(lastNames.length);
		for (int index = 0; index < lastNames.length; index++) {
			String firstName = firstNames[index];
			String middleName = middleNames[index];
			String lastName = lastNames[index];
			if ((firstName == null || firstName.equals("")) &&
				(middleName == null || middleName.equals("")) &&
				(lastName == null || lastName.equals(""))) {
				// nothing to see here, move along
				continue;
			} else {
				if (firstName == null) firstName = "";
				if (middleName == null) middleName = "";
				if (lastName == null) lastName = "";
				Name name = new Name(firstName, middleName, lastName);
				nameList.add(name);
			}
		}
		return nameList;
	}*/
	
	private PersistenceEngine getEngine() {
		return Kernel.getCore().getPersistenceEngine();
	}
	
	private TransactionTemplate getTransactionTemplate() {
		PlatformTransactionManager manager = (PlatformTransactionManager)Kernel.getCore().getContext().getBean("transactionManager");
		return new TransactionTemplate(manager);
	}

}
