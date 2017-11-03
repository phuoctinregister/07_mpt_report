<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp"/>
<%
   if ( request.getSession().getAttribute("USERID") == null )
   {
      response.sendRedirect("login.jsp");
   }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Reports</title>
<link type="text/css" href="css/common.css" rel="stylesheet" />
</head>
<body>
	<hr width="500" align="left">
	<a href="summary_users.jsp">01. Summary Users</a> <br>	
	<a href="users_by_time.jsp">02. Users by time</a>	
	
</body>
</html>