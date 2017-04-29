package com.kristinaanderic.web.rsvp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.datastore.DaoUtils;
import com.kristinaanderic.guests.Party;
import com.kristinaanderic.web.WebConstants;

public final class LoginAction extends Action {

    private static final org.apache.log4j.Logger LOGGER =
        org.apache.log4j.Logger.getLogger(LoginAction.class);
    
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();

		String password =
			(String) PropertyUtils.getSimpleProperty(form, "password");
		Party party = (Party)DaoUtils.getPartyDao().findByPassword(password);
		LOGGER.info("[LOGIN] attempting to log in with password: " + password);
		if (party == null && request.getSession().getAttribute("loggedInParty") != null) {
			return mapping.findForward(WebConstants.SUCCESS_FORWARD);
		}
		if (party == null) {
			errors.add("password", new ActionError("password.error"));
		}
		if (!errors.isEmpty()) {
		    LOGGER.info("[LOGIN] invalid password: " + password);
			saveErrors(request, errors);
			return mapping.findForward(WebConstants.FAILURE_FORWARD);
		}
		request.getSession().setAttribute("loggedInParty", party);
		LOGGER.info("[LOGIN "+ party.getId()+"] login successful, partyName: " + party.getPartyName());
		// Forward control to the specified success URI
		return mapping.findForward(WebConstants.SUCCESS_FORWARD);

	}

}
