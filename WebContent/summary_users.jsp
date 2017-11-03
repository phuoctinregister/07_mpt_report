<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="mpt_report.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
	<hr width="500" align="left">
	<%= mainClass.F1CAS_TOTAL_USER() %> <br>
	<%= mainClass.F1CAS_ACTIVE_USER() %> <br> 
	<%= mainClass.F1CAS_INACTIVE_USER() %> <br> 
	<br>
	<%= mainClass.OMNI_TOTAL_USER() %> <br>
	<%= mainClass.OMNI_ACTIVE_USER() %> <br> 
	<%= mainClass.OMNI_INACTIVE_USER() %> <br> 
	<br>
	<%= mainClass.CPS_TOTAL_USER() %> <br>
	<%= mainClass.CPS_ACTIVE_USER() %> <br> 
	<%= mainClass.CPS_INACTIVE_USER() %> <br>
	<br>
	<%= mainClass.PEGA_TOTAL_USER() %> <br>
	<%= mainClass.PEGA_ACTIVE_USER() %> <br>
	<%= mainClass.PEGA_INACTIVE_USER() %> <br>
	
</body>
</html>