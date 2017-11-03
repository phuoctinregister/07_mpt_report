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
	<hr width="500" align="left">
	<form name="frmMenu2" action="Menu2Servlet" method="POST">
        <table>
            <tr>
                <td></td>
                <td><input type="submit" name="btnRun" id="btnLogin" value="Run"  /></td>
            </tr>    
             <%Iterator<String> itr; %> 
            <%
           		List<String> dataList = new ArrayList<String>(); 
        		dataList = (List<String>)request.getSession().getAttribute("data");
               if (dataList != null )
               {	
             %>
             <table border="1" width="303">
			  <tr>
				<td width="119"><b>USERNAME</b></td>
				<td width="168"><b>PASSWORD</b></td>
				<td width="168"><b>PERMISSION</b></td>
			  </tr>	
             <%  	 
	             for (itr=dataList.iterator(); itr.hasNext(); )
	             {
               
            %>  
            <tr>
            	<td width="119"><%=itr.next() %></td>
            	<td width="168"><%=itr.next() %></td>
            	<td width="168"><%=itr.next() %></td>
            </tr>
            <%} }%>
             </table>          
        </table>
     </form>
</body>
</html>