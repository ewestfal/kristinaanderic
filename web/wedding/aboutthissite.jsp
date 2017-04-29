<jsp:include page="header.jsp" />
<% String contextPath = request.getContextPath(); %>
<%! String encodePath(String contextPath, String url) {
         String path = contextPath+"/"+url;
         return path;
    }
%>
  <h3>About this Site</h3>
  <p>The majority of this site was put together by Kristina and Eric over the course of a week or so.  The goal of this site was to provide our guests with information about the wedding, reception, and the people getting married ;)  Also, we wanted to build a web application which allowed our guests to RSVP online.  That actually turned out to be a bad idea because I ended up waiting until the last minute to finish it.  At any rate, this is the end product...I hope it works! ;)
  </p>
  <h3>The Technology</h3>
  <p>I'm not sure if anybody visiting this site would be interested in the technology behind it or not.  This is the section for those that are.  I encounter and work with most of this technology on an everyday basis at LifeTree.  Everything used to build this site is free and/or open source software.  Here is a basic list of the technologies used to develop this website and the RSVP web application.  If anybody is curious about this stuff then you can always <a href="contactus.jsp">contact me</a> ;)
    <ul>
      <li><a href="http://www.eclipse.org">IBM Eclipse Java IDE</a></li>
      <li><a href="http://ant.apache.org">Ant</a></li>
      <li><a href="http://www.apache.org/httpd">Apache Webserver</a></li>
      <li><a href="http://jakarta.apache.org/tomcat">Apache Jakarta Tomcat Servlet Container</a></li>
      <li><a href="http://www.mysql.com">MySQL Database Server</a></li>
      <li><a href="http://www.w3.org/MarkUp/">HTML (HyperText Markup Language)</a></li>
      <li><a href="http://www.w3.org/Style/CSS/">CSS (Cascading Style Sheets)</a></li>
      <li><a href="http://www.w3.org/XML/">XML (Extensible Markup Language)</a></li>
      <li><a href="http://java.sun.com">Java SDK and Runtime</a></li>
      <li><a href="http://www.hibernate.org">Hibernate Persistence Framework</a></li>
      <li><a href="http://www.springframework.org">Spring Application Framework</a></li>
      <li><a href="http://java.sun.com/products/javamail">JavaMail</a></li>
      <li><a href="http://java.sun.com/products/jsp/">JSP (Java Server Pages)</a></li>
      <li><a href="http://java.sun.com/products/jsp/jstl/index.jsp">JSTL (JavaServer Pages Standard Tag Library)</a></li>
      <li><a href="http://struts.apache.org">Struts Web MVC Framework</a></li>
      <li><a href="http://logging.apache.org/log4j/docs/">log4j Logging Framework</a></li>
    </ul>
    Yeah, all of this technology is most certainly overkill for this little site...but...oh well...I'm a bit masochistic when it comes to this stuff ;)
  </p>
<jsp:include page="footer.jsp" />
