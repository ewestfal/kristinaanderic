package com.kristinaanderic.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.datastore.DaoUtils;
import com.kristinaanderic.web.WebConstants;

public final class EditGuestListAction extends Action {

	/**
	 * Process the specified HTTP request, and create the corresponding HTTP
	 * response (or forward to another web component that will create it).
	 * Return an <code>ActionForward</code> instance describing where and how
	 * control should be forwarded, or <code>null</code> if the response has
	 * already been completed.
	 *
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 *
	 * @exception Exception if business logic throws an exception
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
		ActionErrors errors = new ActionErrors();
		List parties = DaoUtils.getPartyDao().findAll();

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward(WebConstants.FAILURE_FORWARD);
		}

		request.setAttribute("parties", parties);

		// Forward control to the specified success URI
		return mapping.findForward(WebConstants.SUCCESS_FORWARD);

	}

}
