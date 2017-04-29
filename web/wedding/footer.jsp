<%! String encodePath(String contextPath, String url) {
         String path = contextPath+"/"+url;
         return path;
    }
%>
<% String contextPath = request.getContextPath(); %>
</div></div>
<div style="text-align:center;width:100%">
<div style="text-align:center;text-size:8px;text-color:gray;margin-bottom:10px;width:700px;margin-left:auto;margin-right:auto">
  <a href="<%= encodePath(contextPath, "index.jsp") %>">Home</a> |
         <a href="<%= encodePath(contextPath, "rsvp") %>">RSVP</a> |
         <a href="<%= encodePath(contextPath, "cheatsheet.jsp") %>">Cheat Sheet</a> |
         <a href="<%= encodePath(contextPath, "ceremony.jsp") %>">Ceremony &amp; Directions</a> |
         <a href="<%= encodePath(contextPath, "reception.jsp") %>">Reception &amp; Directions</a> |
         <a href="<%= encodePath(contextPath, "parking.jsp") %>">Parking</a> |
         <a href="<%= encodePath(contextPath, "hotels.jsp") %>">Hotels &amp; Directions</a> |
         <a href="<%= encodePath(contextPath, "pictures.jsp") %>">Pictures</a> |
         <a href="<%= encodePath(contextPath, "giftregistry.jsp") %>">Gift Registry</a> |
         <a href="<%= encodePath(contextPath, "contactus.jsp") %>">Contact Us</a><br>
  <a href="<%= encodePath(contextPath, "aboutthissite.jsp") %>">About this Site</a>
</div>
</div>
</body>
</html>