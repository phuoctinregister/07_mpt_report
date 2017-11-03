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
 Template Pega for User Activities <br>
 <%
    try{
    	Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.30.110.93:1521:finnuat5", "cfappsup", "cfappsupuat5");
       Statement statement = conn.createStatement() ;
       resultset =statement.executeQuery("select * from cfappsup.mpt_pfu_template_pega order by 1") ;
 %>
	<select>
		<%	while (resultset.next()) {	%>
		<option><%=resultset.getString(1)%></option>
		<%}	%>
	</select>
	<%
		} catch (Exception e) {
			out.println("wrong entry" + e);
		}
	%>
</body>
</html>