<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../noCacheHeader.jsp" />
<h3>RSVP</h3>
<c:if test="${wasTimedOut}">
  <p style="font-size:1.1em;color:red">OOPS!  Looks like your session has timed out.  You must complete the RSVP process within 30 minutes of logging in.  Please try again.</p>
</c:if>
<p>Hello!  Welcome to our RSVP page.  Please enter the password you were given in your invitation into the password field below and click the submit button.  This will bring you to a page where you can fill in the rest of the information regarding your RSVP.  If you have any trouble with this process (or prefer an alternate method of reply), you can also RSVP via phone or email.  Click <html:link href="RsvpInfo.jsp">here</html:link> for information on giving us your response using either of these methods.  You can also <html:link href="http://www.kristinaanderic.com">browse the rest of our webpage when you're done.</html:link>  <strong>Remember that your RSVP must be received by October 13th!!!</strong>  Thanks!</p>
<html:form action="/Login" focus="password">
<table border="0" width="100%">
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

<jsp:include page="../footer.jsp" />
