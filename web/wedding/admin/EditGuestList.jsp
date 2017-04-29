<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../header.jsp" />

<p>
  <html:link action="/AddParty.do">Add Parties</html:link>
</p>
<p>  
  <c:forEach var="party" items="${parties}">
    <c:forEach var="name" varStatus="status" items="${party.names}">
      <c:out value="${name}" />
      <c:if test="${!status.last}">, </c:if>  
    </c:forEach>
    <br>
  </c:forEach>
</p>
<jsp:include page="../footer.jsp" />
