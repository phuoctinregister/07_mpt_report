<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" import="mpt_report.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
   if ( request.getSession().getAttribute("USERID") == null )
   {
      response.sendRedirect("login.jsp");
   }
	MainClass mainClass = (MainClass)request.getSession().getAttribute("MAINCLASS");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChangePassword</title>
<link type="text/css" href="css/common.css" rel="stylesheet"/>
<jsp:include page="header.jsp"/>
<script>
    function changePasswordValidation() 
    {
        var txtNewPassword = document.getElementById("txtNewPassword").value;
        var txtConfirmNewPassword = document.getElementById("txtConfirmNewPassword").value;
        
        if ( txtNewPassword =="" || txtNewPassword == null )
        {
            alert("Please enter New Password!");
            txtNewPassword.focus();
            return false;
        }
        
        if (txtNewPassword != txtConfirmNewPassword) {
            alert("Passwords Do not match");
            document.getElementById("txtNewPassword").style.borderColor = "#E34234";
            document.getElementById("txtConfirmNewPassword").style.borderColor = "#E34234";
            return false;
        }
        else {
            return true;
        }
    }
</script>

</head>
<body>

	<form name="frmChangePassword" action="ChangePassword" method="POST">
        <table>
           
            <tr>
                <td> New Password </td>
                <td> <input name="txtNewPassword" id="txtNewPassword"  type="password" /></td>
            </tr>
            <tr>
                <td> Confirm New Password </td>
                <td> <input name="txtConfirmNewPassword" id="txtConfirmNewPassword" type="password"/></td>
            </tr>
             
            <tr>
                <td></td>
                <td><input type="submit" name="btnChangePassword" id="btnChangePassword" value="Change Password" onclick="return changePasswordValidation();"  /></td>
            </tr>  
            
            <tr>
                <td colspan="2">
                     <% if (request.getSession().getAttribute("CHANGE_PASSWORD") != null) { %>
                        <span class="errorText"> <%= request.getSession().getAttribute("CHANGE_PASSWORD") %> </span>
                    <%}%>
                </td>
            </tr>      
        </table>
     </form>

</body>
</html>