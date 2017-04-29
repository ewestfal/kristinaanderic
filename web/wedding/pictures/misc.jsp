<jsp:include page="../header.jsp" />
<% 
String[][] pictures = new String[][] {
new String[] {"christmas-01-web.jpg","Us at Christmas in 2002"},
new String[] {"limestone-01-web.jpg","At the Limestone Grill in Bloomington Celbrating our engagement"},
new String[] {"limestone-02-web.jpg","More at the Limestone Grill"},
new String[] {"pumpkin-01-web.jpg","Carving a pumpkin for Halloween"},
new String[] {"ranch-halloween-01-web.jpg","Halloween party at \"The Ranch\""},
new String[] {"paint-centerpiece-01-web.jpg","Painting wedding centerpieces (I think)"},
new String[] {"moriah-21-01-web.jpg","Moriah Pate's 21st birthday at Jillian's in Indianapolis"}
};
%>
<div style="text-align:center">
  <h1>Some Miscellaneous Pictures</h1>
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