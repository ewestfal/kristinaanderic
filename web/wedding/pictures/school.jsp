<jsp:include page="../header.jsp" />
<% 
String[][] pictures = new String[][] {
new String[] {"final-four-2002-01-web.jpg","Picture from when IU went to the Final Four (and final two) in 2002"},
new String[] {"phi-beta-kappa-01-web.jpg","Us at Eric's Phi Beta Kappa inducation"},
new String[] {"eric-college-grad-01-web.jpg","Picture from Eric's graduation in 2002"},
new String[] {"kristina-iu-grad-01-web.jpg","Picture from Kristina's graduation in 2004"}
};
%>
<div style="text-align:center">
  <h1>Some Pictures from our Adventures at Indiana University</h1>
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