package com.kristinaanderic.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kristinaanderic.datastore.DaoUtils;
import com.kristinaanderic.web.WebConstants;

public final class PasswordListAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		List parties = DaoUtils.getPartyDao().findAll();
		request.setAttribute("parties", parties);
		return mapping.findForward(WebConstants.SUCCESS_FORWARD);

	}

}
