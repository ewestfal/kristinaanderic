<jsp:include page="../header.jsp" />
<% 
String[][] pictures = new String[][] {
new String[] {"tennessee-momwed-01-web.jpg","Laurel and Don Waters' Wedding in Tennessee"},
new String[] {"higgins-wedding-01-web.jpg","Heather and Dan Higgins' Wedding"},
new String[] {"cole-wedding-01-web.jpg","Holly and Dan Cole's Wedding"}
};
%>
<div style="text-align:center">
  <h1>Weddings</h1>
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