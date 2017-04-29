<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<jsp:include page="../noCacheHeader.jsp" />

<html:form action="/Login" focus="username">
           <!-- onsubmit="return validateLoginForm(this);"> -->
<table border="0" width="100%">

  <tr>
    <th align="right">
        Username:
    </th>
    <td align="left">
      <html:text property="username" size="16" maxlength="20"/>
      <html:errors property="username" />
    </td>
  </tr>

  <tr>
    <th align="right">
        Password:
    </th>
    <td align="left">
      <html:password property="password" size="16" maxlength="20"
                    redisplay="false"/>
      <html:errors property="password" />
    </td>
  </tr>

  <tr>
    <td align="right">
      <html:submit value="Submit"/>
    </td>
    <td align="left">
      <html:reset/>
    </td>
  </tr>

</table>

</html:form>

<%-- <html:javascript formName="loginForm" /> --%>

<jsp:include page="../footer.jsp" />
