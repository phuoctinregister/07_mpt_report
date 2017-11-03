<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="mpt_report.*,java.util.*"%>
<jsp:include page="header.jsp"/>
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
<!-- http://www.technicalkeeda.com/servlet-jsp-tutorials/export-to-excel-using-servlet-and-jsp -->
 Export to Excel Demo <a href="exporttoexcel">Click Here</a>
</body>
</html>