<jsp:include page="header.jsp" />
<% String contextPath = request.getContextPath(); %>
<%! String encodePath(String contextPath, String url) {
         String path = contextPath+"/"+url;
         return path;
    }
%>
  <div style="text-align:center;font-style:italic;font-size:14px">
    Sharing a life together is sharing steps in time.<br>
    It is the giving of songs and of silences only the heart can see.<br>
    The music of love may be different to each of us,<br>
    but how beautiful the dance...<br><div style="font-style:normal">-Flavia</div>
  </div>
  <h3>Welcome!</h3>
  <p>Welcome to Eric and Kristina's wedding webpage.  Thank you for letting us share this special moment with you.  We invite you to come in and look around our website.  We hope you enjoy reading this site as much as we have enjoyed putting it together!
  </p>
  <h3>The Facts</h3>
  <p>The wedding ceremony will commence on October 30th at 4:30 PM.  It will take place at the <a href="<%= encodePath(contextPath,"ceremony.jsp") %>">First Christian Church</a> in Bloomington.  The reception will start at 6:00 PM.  It will be held at <a href="<%= encodePath(contextPath,"reception.jsp") %>">Terry's Banquets and Catering</a>.  Since we are doing a plated meal it is very important that you <a href="rsvp">RSVP</a> by October 13.  Thanks!</p>
  <h3>The Website</h3>
  <p>
    On this website, you can submit your <a href="<%= encodePath(request.getContextPath(), "rsvp") %>">RSVP</a> if you haven't already, get directions to the church and reception site, or just read about the wedding.  Just use the links above to navigate through the site.  If you would like to contact us to ask us a question (or just to say hi), email us at <a href="mailto:ewestfal@gmail.com">ewestfal@gmail.com</a>
  </p>
<jsp:include page="footer.jsp" />
