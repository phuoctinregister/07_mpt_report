<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="mpt_report.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
   if ( request.getSession().getAttribute("USERID") == null )
   {
      response.sendRedirect("login.jsp");
   }

	MainClass mainClass = (MainClass)request.getSession().getAttribute("MAINCLASS");

%>
<html>
<body>
	<table cellpadding="10">
		<tr>
			<td>
				<% if ( mainClass.hasPermission("m1")) { %>
                         <a href="report.jsp"> Reports </a> 
                <% } %>
			</td>
			<td>
				<% if ( mainClass.hasPermission("m2")) { %>
                         <a href="menu2.jsp"> Menu2 </a> 
                <% } %>
			</td>
			<td>
				<% if ( mainClass.hasPermission("m3")) { %>
                         <a href="exporttoexcel.jsp"> ExportToExcel </a> 
                <% } %>
			</td>
			<td>
				<% if ( mainClass.hasPermission("m5")) { %>
                         <a href="template_pega2.jsp"> Template</a> 
                <% } %>
			</td>
			<td> <a href="change_password.jsp"> Change Password </a> </td>
			<td> <a href="logout.jsp"> Logout </a> </td>
		</tr>
	</table>
</body>
</html>