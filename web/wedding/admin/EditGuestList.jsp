<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../noCacheHeader.jsp" />

<p>
  <html:link action="/AddParty.do">Add Parties</html:link>
</p>
<p>  
  <c:forEach var="party" items="${requestScope.parties}">
    <c:set var="partyId" value="${party.id}"/>
    <html:link action="/EditParty.do" paramId="partyId" paramName="partyId"><c:out value="${party.partyName}"/></html:link>
    <br>
  </c:forEach>
</p>
<jsp:include page="../footer.jsp" />
