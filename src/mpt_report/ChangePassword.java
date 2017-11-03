package mpt_report;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ChangePassword() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtConfirmNewPassword = request.getParameter("txtConfirmNewPassword");
		String txtUserID = (String)request.getSession().getAttribute("USERID");
		
		MainClass mainClass = (MainClass)request.getSession().getAttribute("MAINCLASS");
		
		try 
		{
			String result=mainClass.CHANGE_PASSWORD(txtUserID, txtConfirmNewPassword);
			request.getSession().setAttribute("CHANGE_PASSWORD", result);
			response.sendRedirect("change_password.jsp");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
	}

}
