package com.kristinaanderic.web.rsvp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.web.WebConstants;

/**
 * @author Eric Westfall
 * @created Sep 9, 2004
 */
public class TimeoutAction extends Action {

    private static final org.apache.log4j.Logger LOGGER =
        org.apache.log4j.Logger.getLogger(TimeoutAction.class);
    
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	    request.setAttribute("wasTimedOut", new Boolean(true));
	    LOGGER.info("[TIMEOUT] session timed out!");
		return mapping.findForward(WebConstants.SUCCESS_FORWARD);
	}
	
}
