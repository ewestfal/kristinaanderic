<%@ page import="java.util.*" %>
<%! String encodePath(String contextPath, String url) {
         String path = contextPath+"/"+url;
         return path;
    }
%>
<%
   String contextPath = request.getContextPath();
   Date today = new Date();
   Calendar calendar = Calendar.getInstance();
   calendar.set(2004, Calendar.OCTOBER, 30);
   Date weddingDay = calendar.getTime();
   int oneDay = 1000*60*60*24;
   int daysUntilWedding = (int)Math.ceil((weddingDay.getTime()-today.getTime())/oneDay);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Eric and Kristina's Wedding Homepage</title>
<link REL="stylesheet" TYPE="text/css" href="<%= encodePath(contextPath, "wedding.css") %>">
</head>
<body bgcolor="ivory">
<div class="container">
<div class="pictureCircle">
  <img src="<%= encodePath(contextPath, "images/round-frame2.gif") %>" height="200" width="200" alt="Picture of us">
</div>
<div class="tableClass">
<div class="topbar">
  <div class="titleImage">
    <img src="<%= encodePath(contextPath, "images/main-title3.gif") %>" alt="Eric and Kristina, United in Love, October 16 2004">
  </div>
</div>
<div class="bodyRow">
<div class="sidebar">
  <br><br><br>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "index.jsp") %>">Home</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "aboutus.jsp") %>">About Us</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "comingsoon.jsp") %>">Web Log</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "ceremony.jsp") %>">Ceremony</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "reception.jsp") %>">Reception</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "comingsoon.jsp") %>">RSVP</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "comingsoon.jsp") %>">Hotels</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "comingsoon.jsp") %>">Honeymoon</a></div>
  <div class="menuItem"><a href="<%= encodePath(contextPath, "comingsoon.jsp") %>">Pictures</a></div>
  <div class="weddingDate">
     Only <%= daysUntilWedding %> more<br> days to go!
  </div>
  <br><br><br><br><br><br>
</div>
<div class="thebody">