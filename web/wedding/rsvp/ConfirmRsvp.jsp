<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../noCacheHeader.jsp" />
<h1>Confirm</h1>
<p><strong style="color:red">Your RSVP will not be complete until you confirm it on this page!</strong></p>
<p>Party: <c:out value="${rsvpForm.party.partyName}"/></p>
<c:choose>
  <c:when test="${rsvpForm.attending == 'false'}">
    <p>You have indicated that your party will not be attending the reception.</p>
  </c:when>
  <c:when test="${rsvpForm.attending == 'true'}">
    <p>You have indicated that your party will be attending the reception.  Please check the following information and confirm that it is correct.</p>
    <p>Guests attending from your party:</p>
<c:forEach var="name" items="${rsvpForm.lastNames}" varStatus="status">
  <c:set var="fn" value="${rsvpForm.firstNames[status.index]}"/>
  <c:set var="ln" value="${rsvpForm.lastNames[status.index]}"/>
  <c:set var="meal" value="${rsvpForm.meals[status.index]}"/>
  <c:if test="${!empty fn || !empty ln}">
    <c:out value="${fn} ${ln} -- ${meal}"/><br>
  </c:if> 
  </c:forEach>
  <br>Comments:<br>
  <c:choose><c:when test="${rsvpForm.comments == null || rsvpForm.comments == ''}">
    <c:set var="comments" value="(None)"/></c:when><c:otherwise><c:set var="comments" value="${rsvpForm.comments}"/></c:otherwise></c:choose>
  <c:out value="${comments}"/><br>
  </c:when>
  <c:otherwise>
    <p>There was an error processing your request, please hit the back button and try again.</p>
  </c:otherwise>
</c:choose>
<br>
<div style="font-weight:bold">Is this correct?</div>
<div><html:link action="/Confirm.do">Yes, please confirm my RSVP</html:link></div>
<div><html:link action="/respond.do">No!  I need to change something!</html:link></div>

<jsp:include page="../footer.jsp" />
