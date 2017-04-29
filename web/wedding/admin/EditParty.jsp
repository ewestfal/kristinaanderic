<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../noCacheHeader.jsp" />
<html:form action="/UpdateParty" focus="partyName">
  <c:set var="mode" value="${requestScope.updatePartyForm.mode}"/>
  <c:set var="partyId" value="${requestScope.updatePartyForm.party.id}"/>
  <h3>Add/Edit Party<c:if test="${mode == 'edit'}"> - (<html:link action="/RemoveParty.do" paramId="partyId" paramName="partyId" onclick="return confirm('WARNING! This will permanantly remove this Party!  Do you still want to do this?')">Remove</html:link>)</c:if></h3>
  Party Name :<br>
  <html:text property="partyName"></html:text><html:errors property="partyName"/><br>
<%--
  Guest Names:<br>
  <c:forEach var="name" items="${requestScope.updatePartyForm.lastNames}" varStatus="status">
    <html:text property="firstNames" value="${requestScope.updatePartyForm.firstNames[status.index]}"/>
    <html:text property="middleNames" value="${requestScope.updatePartyForm.middleNames[status.index]}"/>
    <html:text property="lastNames" value="${requestScope.updatePartyForm.lastNames[status.index]}"/><br>
  </c:forEach>
  Address:<br>
  Street Address 1: <html:text property="streetAddress1" /><br>
  Street Address 2: <html:text property="streetAddress2" /><br>
  City: <html:text property="city" />
  State: <html:text property="state" size="2"/>
  Zip Code: <html:text property="zipCode" size="10"/><br><br>
  Phone Numbers:<br>
  <html:text property="phoneNumber1" /><br>
  <html:text property="phoneNumber2" /><br>
--%>
  <html:hidden property="mode" />
  <html:submit value="Add/Update" />
</html:form>
<jsp:include page="../footer.jsp" />
