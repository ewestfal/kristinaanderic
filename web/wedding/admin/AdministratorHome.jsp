<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<jsp:include page="../noCacheHeader.jsp" />

<p>
Welcome Administrator Kristina and/or Eric :)
</p>
<p>
  <html:link action="/EditGuestList.do">Edit Guest List</html:link><br>
  <html:link action="/PasswordList.do">View Password List</html:link>
</p>
<jsp:include page="../footer.jsp" />
