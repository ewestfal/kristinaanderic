<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../noCacheHeader.jsp" />

<p><b>Password List</b></p>
<p>  
  <c:forEach var="party" items="${requestScope.parties}">
    <div class="font-size:-1"><c:out value="${party.partyName}"/> - <c:out value="${party.password}"/></div>
  </c:forEach>
</p>
<jsp:include page="../footer.jsp" />
