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
<html lan="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eric and Kristina's Wedding Homepage</title>
<link REL="stylesheet" TYPE="text/css" href="<%= encodePath(contextPath, "wedding.css") %>">
</head>
<body>
  <div style="position:absolute;width:100%;top:5px;z-index:2;text-align:center;height:150px;margin:0px 0px 0px 0px">
    <div style="text-align:center;width:280px;height:205px;margin-right:auto;margin-left:auto"><img src="/wedding/images/us7.gif" alt="Picture of Us!"></div>
  </div>
  <div style="height:70px"></div>
  <div style="text-align:center;width:100%">
    <div style="width:700px;height:104px;margin-left:auto;margin-right:auto;border-style:solid;border-color:gray;border-width:2px 2px 0px 2px;background-color:#FFFFE0">
      <table width="100%" cellspacing="0" cellpadding="0">
        <tr>
          <td style="text-align:right;padding-right:5px">
            <div><img src="/wedding/images/names2.gif" alt="Eric and Kristina"></div>
          </td>
          <td width="280">&nbsp;</td>
          <td style="padding-left:5px"><div><img src="/wedding/images/october30-2.gif" alt="October 30, 2004"></div></td>
        </tr>
      </table>
    </div>
  </div>

  <div style="text-align:center;margin-bottom:2px">
    <div style="border-color:gray;border-style:solid;border-width:1px 2px 2px 2px;margin-left:auto;margin-right:auto;width:700px;height:20px;background-image:url('/wedding/images/leaves1.gif');background-repeat: repeat-x"></div>
  </div>
  <div style="text-align:center;width:100%">
  <div style="text-align:center;width:780px;margin-left:auto;margin-right:auto">    
   <table border="0" cellspacing="0" cellpadding="0"><tr><td style="height:40px;width:40px"><img height="40px" width="40px" src="/wedding/images/left-endcap.gif" alt="Left Endcap"></td>
      <td style="height:40px;background-color:#C57A7A;width:700px">
        <div style="text-align:center;padding:2px 0px 2px 0px">
         <a href="<%= encodePath(contextPath, "index.jsp") %>">Home</a> |
         <a href="<%= encodePath(contextPath, "rsvp") %>">RSVP</a> |
         <a href="<%= encodePath(contextPath, "cheatsheet.jsp") %>">Cheat Sheet</a> |
         <a href="<%= encodePath(contextPath, "ceremony.jsp") %>">Ceremony &amp; Directions</a> |
         <a href="<%= encodePath(contextPath, "reception.jsp") %>">Reception &amp; Directions</a> |
         <a href="<%= encodePath(contextPath, "parking.jsp") %>">Parking</a> |
         <a href="<%= encodePath(contextPath, "hotels.jsp") %>">Hotels &amp; Directions</a> |
         <a href="<%= encodePath(contextPath, "pictures.jsp") %>">Pictures</a> |
         <a href="<%= encodePath(contextPath, "giftregistry.jsp") %>">Gift Registry</a> |
         <a href="<%= encodePath(contextPath, "contactus.jsp") %>">Contact Us</a>
        </div>
      </td>
      <td style="height:40px;width:40px"><img height="40px" width="40px" src="/wedding/images/right-endcap.gif" alt="Right Endcap"></td></tr></table>
  </div>
  </div>
  <div style="text-align:center;width:100%">
      <div style="text-align:left;margin-top:5px;border:solid black 4px;width:700px;background-color:#FFFFE0;margin-left:auto;margin-right:auto;padding:5px">









