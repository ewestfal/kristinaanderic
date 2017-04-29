package com.kristinaanderic.web.rsvp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.guests.Party;
import com.kristinaanderic.web.WebConstants;

public final class RespondAction extends Action {

    private static final org.apache.log4j.Logger LOGGER =
        org.apache.log4j.Logger.getLogger(RespondAction.class);
    
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	    Party party = (Party)request.getSession().getAttribute("loggedInParty");
		if (party == null) return mapping.findForward(WebConstants.TIMEOUT_FORWARD);
		LOGGER.info("[RESPOND "+party.getId()+"] responding");
		return mapping.findForward(WebConstants.SUCCESS_FORWARD);
	}

}
