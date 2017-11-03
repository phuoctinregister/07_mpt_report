<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="mpt_report.*"%>
<jsp:include page="header.jsp"/>
<%
   if ( request.getSession().getAttribute("USERID") == null )
   {
      response.sendRedirect("login.jsp");
   }

	EnvClass envClass = (EnvClass)request.getSession().getAttribute("ENVCLASS");
	MainClass mainClass = new MainClass(envClass);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User by Time</title>
</head>
<body>
	<hr width="500" align="left">
	<form name="frmUsersByTime" action="UsersByTime" method="POST">
        <table>
            <tr>
                <td> Start time </td>
                <% String txtStartDate = null; 
                    if (request.getSession().getAttribute("TXT_START_DATE") != null )  
                   {
                  	  txtStartDate = (String) request.getSession().getAttribute("TXT_START_DATE"); 
                   } 
                 %>
                <td> <input id="txtStartDate" name = "txtStartDate" type="date" value = "<%= txtStartDate %>"></td>
            </tr>
            <tr>
                <td> End time  </td>
                <% String txtEndDate = null; 
                    if (request.getSession().getAttribute("TXT_END_DATE") != null )  
                   {
                  	  txtEndDate = (String) request.getSession().getAttribute("TXT_END_DATE"); 
                   } 
                 %>
                <td> <input id="txtEndDate" name="txtEndDate" type="date" value = "<%= txtEndDate %>"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="btnRunUserByTime" id="btnRunUserByTime" value="Run"  /></td>
              <!--   onclick="return validateTime();"  -->
            </tr>    
            
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("F1SSO_NEW_ACTIVE_USERS_MONTHLY") != null ) {%>
                  		 <%= request.getSession().getAttribute("F1SSO_NEW_ACTIVE_USERS_MONTHLY")%>
                	<%} %>
                </td>
            </tr>
            
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("F1SSO_DEACTIVATED_USR_MONTHLY") != null ) {%>
                  		 <%= request.getSession().getAttribute("F1SSO_DEACTIVATED_USR_MONTHLY")%>
                	<%} %>
                </td>
            </tr>
            
            <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>
            
            
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("F1CAS_NEW_ACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("F1CAS_NEW_ACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
                
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("F1CAS_DEACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("F1CAS_DEACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
            <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>
            
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("OMNNI_NEW_ACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("OMNNI_NEW_ACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("OMNNI_DEACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("OMNNI_DEACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
            <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>
            
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("CPS_NEW_ACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("CPS_NEW_ACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("CPS_DEACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("CPS_DEACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
            
             <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>   <tr> <td></td> </tr>  <tr> <td></td> </tr>
            
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("PEGA_NEW_ACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("PEGA_NEW_ACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
            
            
            <tr>
                <td colspan="2" class="errorText">
                   <% if (request.getSession().getAttribute("PEGA_DEACTIVATED_USR_BYTIME") != null ) {%>
                  		 <%= request.getSession().getAttribute("PEGA_DEACTIVATED_USR_BYTIME")%>
                	<%} %>
                </td>
            </tr>
        </table>
     </form>
</body>
</html>