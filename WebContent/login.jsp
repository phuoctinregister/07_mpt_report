<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link type="text/css" href="css/common.css" rel="stylesheet"/>
<script type="text/javascript">
        function validate()
        {
            var txtUserID = document.forms["frmLogin"].txtUserID;
            var txtPassword = document.forms["frmLogin"].txtPassword;
            
            if ( txtUserID.value =="" || txtUserID.value == null )
            {
                alert("Please enter User ID");
                txtUserID.focus();
                return false;
            }
            
            if ( txtPassword.value =="" || txtPassword.value == null )
            {
                alert("Please enter Password");
                txtPassword.focus();
                return false;
            }
            
            return true;
        }
    </script>
</head>
<body>
      <!-- <table width="400">
      <tr>
         <td class="appName"> <center>  MPT Support Tool </center> </td>
      </tr>
       <tr>
         <td > <center>  -- oOo -- </center> </td>
      </tr>
      </table>
     <br> -->
     
     
	<form name="frmLogin" action="LoginServlet" method="POST">
        <table>
            <tr>
                <td colspan="2">
                     <% if (request.getSession().getAttribute("ERR_MSG") != null) { %>
                        <span class="errorText"> <%= request.getSession().getAttribute("ERR_MSG") %> </span>
                    <%}%>
                </td>
            </tr>
            <tr>
                <td> User ID </td>
                <td> <input name="txtUserID" id="txtUserID"  value="user1" /></td>
            </tr>
            <tr>
                <td> Password </td>
                <td> <input name="txtPassword" id="txtPassword" type="password"  value="111"/></td>
            </tr>
             <tr>
                <td> Environment </td>
                <td> 
                   <select name="env" id="env">
                      <option value="prod"> F1 Production </option>
                      <option value="uat1"> F1 UAT1       </option>
                      <option value="uat2"> F1 UAT2       </option>
                      <option value="uat3"> F1 UAT3       </option>
                      <option value="uat4"> F1 UAT4       </option>
                      <option value="uat5" selected="selected"> F1 UAT5       </option>
                   </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="btnLogin" id="btnLogin" value="Login" onclick="return validate();"  /></td>
            </tr>        
        </table>
     </form>

</body>
</html>