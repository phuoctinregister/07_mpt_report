package mpt_report;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("txtUserID");
		String password = request.getParameter("txtPassword");
		String envName	= request.getParameter("env");
		
		String dbUrl 			= request.getServletContext().getInitParameter(envName + "_db_url");
		String dbUsername = request.getServletContext().getInitParameter(envName + "_db_username");
		String dbPassword = request.getServletContext().getInitParameter(envName + "_db_password");
		
		String dbPegaUrl 			= request.getServletContext().getInitParameter(envName + "_db_pega_url");
		String dbPegaUsername = request.getServletContext().getInitParameter(envName + "_db_pega_username");
		String dbPegaPassword = request.getServletContext().getInitParameter(envName + "_db_pega_password");
		EnvClass envClass = new EnvClass();
		
		envClass.setDbUrl(dbUrl);
		envClass.setDbUsername(dbUsername);
		envClass.setDbPassword(dbPassword);
		envClass.setEnvName(envName);
		
		envClass.setDbPegaUrl(dbPegaUrl);
		envClass.setDbPegaUsername(dbPegaUsername);
		envClass.setDbPegaPassword(dbPegaPassword);
		
		MainClass mainClass = new MainClass(envClass);
		
		try {
			String result = mainClass.login(userID, password);
			request.getSession().setAttribute("ERR_MSG", null);

			if (result.startsWith("Welcome"))
			{
				request.getSession().setAttribute("USERID", userID);
				request.getSession().setAttribute("ENVCLASS", envClass);

        request.getSession().setAttribute("MAINCLASS", mainClass);
        
				response.sendRedirect("main.jsp");
			}
			else
			{
				request.getSession().setAttribute("ERR_MSG", result);
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
