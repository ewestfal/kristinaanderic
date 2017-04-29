package com.kristinaanderic.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.web.WebConstants;

/**
 * Implementation of <strong>Action</strong> that validates a user logon.
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.3 $ $Date: 2004/03/11 07:10:28 $
 */

public final class LoginAction extends Action {

	// ----------------------------------------------------- Instance Variables

	/**
	 * The <code>Log</code> instance for this application.
	 */
	private Log log = LogFactory.getLog(this.getClass().getName());
	private static final String KRISANDERIC_USERNAME = "krisanderic";
	private static final String KRISANDERIC_PASSWORD = "...";

	// --------------------------------------------------------- Public Methods

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

		// Validate the request parameters specified by the user
		String username =
			(String) PropertyUtils.getSimpleProperty(form, "username");
		String password =
			(String) PropertyUtils.getSimpleProperty(form, "password");
		if (!username.equals(KRISANDERIC_USERNAME)) {
			errors.add("username", new ActionError("username.error"));
		}
		if (!password.equals(KRISANDERIC_PASSWORD)) {
			errors.add("password", new ActionError("password.error"));
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward(WebConstants.FAILURE_FORWARD);
		}

		request.getSession().setAttribute("isLoggedIn", Boolean.valueOf(true));

		// Forward control to the specified success URI
		return mapping.findForward(WebConstants.SUCCESS_FORWARD);

	}

}
