<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../noCacheHeader.jsp" />
<h3>RSVP - <c:out value="${rsvpForm.party.partyName}"/></h3>
<p>Please specify whether your party will be attending or not.  If so then enter the names of all those in your party who will be attending and their meal choice.  You will be asked to confirm your response before it is submitted.</p>
<html:form action="/Respond">
<table border="0" width="100%" style="text-align:center">
  <tr>
    <td>Party Name: <c:out value="${rsvpForm.party.partyName}"/></td>
    <logic:messagesPresent>
      <div style="font-size:1.2em;color:red">There were errors in your submission, please see specific messages below and correct your entry.</div><br>
    </logic:messagesPresent>
  </tr>
  <tr><td align="center" style="font-weight:bold;font-size:2em">Will your party be attending?<br><span style="font-size:1em;background-color:#DDDDDD;padding-left:3px;padding-right:3px;margin-right:5px;border:solid black 1px"><html:radio property="attending" value="true"/>Yes</span><span style="font-size:1em;background-color:#DDDDDD;padding-left:3px;padding-right:3px;border:solid black 1px"><html:radio property="attending" value="false"/>No</span><div><html:errors property="attending"/></div></td>
  </tr>
  <tr>
    <td>Names and Meal Choice (enter only the names of those who will be attending)</td>
  </tr>
  <tr>
    <td align="center">First Name, Last Name, Meal Choice
      <div><html:errors property="lastNames"/></div>
    </td>
  </tr>
  <c:forEach var="name" items="${rsvpForm.lastNames}" varStatus="status">
    <tr>
      <td align="center">
        <html:text property="firstNames" value="${rsvpForm.firstNames[status.index]}"/>
        <html:text property="lastNames" value="${rsvpForm.lastNames[status.index]}"/>
        <html:select property="meals" value="${rsvpForm.meals[status.index]}">
          <html:option value="">-- Select Meal</html:option>
          <html:option value="CHICKEN">Chicken</html:option>
          <html:option value="PASTA">Pasta</html:option>
          <html:option value="CHILD">Child</html:option>
          <html:option value="NONE">None</html:option>
        </html:select><div>
     <html:errors property="meal${status.index}"/>
</div>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td>Enter any comments here:<br>
    <html:textarea cols="50" rows="4" property="comments"/>
    </td>
  </tr>
  <tr>
    <td align="center"><html:submit value="Continue"/></td>
  </tr>
</table>

</html:form>

<jsp:include page="../footer.jsp" />
