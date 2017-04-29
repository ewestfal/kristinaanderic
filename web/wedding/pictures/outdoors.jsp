<jsp:include page="../header.jsp" />
<% 
String[][] pictures = new String[][] {
new String[] {"spring-mill-01-web.jpg","Spring Mill Park, 2002."},
new String[] {"outdoors-01-web.jpg","Kristina's deck."},
new String[] {"outdoors-02-web.jpg","In front of Kristina's house the day she moved out to her first apartment."},
new String[] {"florida-2000-01-web.jpg","On the beach in Florida, 2000"},
new String[] {"florida-2000-02-web.jpg","By some palm trees in Florida, 2000"},
new String[] {"kentucky-kingdom-01-web.jpg","At Kentucky Kingdom"},
new String[] {"animal-kingdom-01-web.jpg","Animal Kingdom, the Bug's Life Tree"},
new String[] {"indy-zoo-01-web.jpg","At the Indianapolis Zoo"},
new String[] {"cleveland-zoo-lion-01-web.jpg","At the Cleveland Zoo"},
new String[] {"hotel-01-web.jpg","Vacation in New Harmony, Indiana"}
};
%>
<div style="text-align:center">
  <h1>Vacation/Outdoors</h1>
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