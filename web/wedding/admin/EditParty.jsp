<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<jsp:include page="../header.jsp" />
<html:form action="/UpdateParty">
  <h3>Add/Edit Party</h3>
  Party Name (if left empty defaults to first name):<br>
  <html:text property="propertyName"></html:text><br>
  Guest Names:<br>
  <html:text property="name1"/><br>
  <html:text property="name2"/><br>
  <html:text property="name3"/><br>
  <html:text property="name4"/><br>
  <html:text property="name5"/><br>
  <html:text property="name6"/><br>
  <html:text property="name7"/><br>
  <html:text property="name8"/><br>
  <html:text property="name9"/><br>
  <html:text property="name10"/><br><br>
  Address:<br>
  Street Address 1: <html:text property="address1" /><br>
  Street Address 2: <html:text property="address2" /><br>
  City: <html:text property="city" />
  State: <html:text property="state" />
  Zip: <html:text property="zip" />

</html:form>
<jsp:include page="../footer.jsp" />
