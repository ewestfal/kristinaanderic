<jsp:include page="../header.jsp" />
<% 
String[][] pictures = new String[][] {
new String[] {"prom98-01-web.jpg","Prom 1998"},
new String[] {"prom-iu-union-01-web.jpg","After Prom 1999 at the Indiana University Union"},
new String[] {"prom99-01-web.jpg","Prom 1999"},
new String[] {"prom99-02-web.jpg","More Prom 1999"},
new String[] {"prom99-03-web.jpg","More Prom 1999"},
new String[] {"prom2000-01-web.jpg","Prom 2000"}
};
%>
<div style="text-align:center">
  <h1>Proms</h1>
  <h3>We went to the Edgewood High School Prom together in 1998, 1999, and 2000!</h3>
  <% for (int index = 0; index < pictures.length; index++) {
     String[] picture = pictures[index];
     String src = picture[0];
     String caption = picture[1];
  %>
    <div style="border:solid 2px black;margin-bottom:10px;background-color:#CCCCCC;padding-top:10px">
      <img src="<%= src %>"/>
      <div><%= caption %></div>
    </div>
  <% } %>
</div>
<jsp:include page="../footer.jsp" />