<%  
   request.getSession().setAttribute("MAINCLASS",null);
	session.invalidate();
   response.sendRedirect("login.jsp");
%>