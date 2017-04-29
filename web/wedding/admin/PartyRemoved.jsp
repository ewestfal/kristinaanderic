<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../header.jsp" />
  <p>The "<c:out value="${requestScope.partyName}"/>" party was successfully removed.</p>
  <html:link action="/EditGuestList.do">Back to Guest List</html:link>
<jsp:include page="../footer.jsp" />
