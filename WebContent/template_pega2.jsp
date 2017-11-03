<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="mpt_report.*,java.util.*,java.sql.*"%>
<jsp:include page="header.jsp"/>

<%ResultSet resultset =null;%>
<%
   if ( request.getSession().getAttribute("USERID") == null )
   {
      response.sendRedirect("login.jsp");
   }

	EnvClass envClass = (EnvClass)request.getSession().getAttribute("ENVCLASS");
	MainClass mainClass = new MainClass(envClass);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Reports</title>
<link type="text/css" href="css/common.css" rel="stylesheet" />
</head>
<body>
 
 <!-- <a href="TemplatePega">Template of creating new user Pega</a> -->
 
 <form action="TemplatePega" method="post">
 Template of creating new user Pega: <input type="submit" value="Click here"/>
 </form>
</body>
</html>