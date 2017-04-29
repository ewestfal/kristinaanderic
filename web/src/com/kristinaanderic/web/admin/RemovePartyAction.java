/*
 * Created on Mar 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.kristinaanderic.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.core.Kernel;
import com.kristinaanderic.guests.Party;
import com.kristinaanderic.web.WebConstants;

/**
 * @author ewestfal
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RemovePartyAction extends Action {
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
			String partyId = request.getParameter("partyId");
			if (partyId == null) throw new Exception("Invalid partyId: " + partyId);
			Long partyIdLong = new Long(partyId);
			Party party = (Party)Kernel.getCore().getPersistenceEngine().load(partyIdLong, Party.class);
			if (party == null) throw new Exception("Invalid partyId: " + partyId);
			String partyName = party.getPartyName();
			request.setAttribute("partyName", partyName);
			Kernel.getCore().getPersistenceEngine().delete(party);
			return mapping.findForward(WebConstants.SUCCESS_FORWARD);
	}

}
