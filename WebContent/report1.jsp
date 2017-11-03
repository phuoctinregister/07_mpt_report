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
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Reports1</title>
<link type="text/css" href="css/common.css" rel="stylesheet" />
</head>
<body>
 <h1>Export to Excel Example</h1>
 <form action="exporttoexcel" method="post">
 <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
  <tr>
   <td>First Name</td>
   <td>Last Name</td>
   <td>Age</td>
  </tr>
  <%
   List<Employee> employees  = (List<Employee>)request.getAttribute("employees");
   for(Employee e: employees){
  %>
   <tr>
   <td><%=e.getFirstName()%></td>   
   <td><%=e.getLastName()%></td>
   <td><%=e.getAge()%></td>
  </tr>
  <% 
   }
  %>
 </table>
 <input type="submit" value="Export To Excel"/>
 </form>
</body>
</html>