package mpt_report;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet2() {
		super();
	}
	
	private Connection getConnection(String dbUrl, String dbUser, String dbPassword) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(dbUrl, dbUser,dbPassword);
		conn.setAutoCommit(false);

		return conn;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("txtUserID");
		String password = request.getParameter("txtPassword");
		String env	= request.getParameter("env");
		String dbUrl = request.getServletContext().getInitParameter(env + "_db_url");
		String dbUser = request.getServletContext().getInitParameter(env + "_db_username");
		String dbPassword = request.getServletContext().getInitParameter(env + "_db_password");
		String result = null;
		
		try {
			Connection conn = getConnection(dbUrl, dbUser, dbPassword);
			CallableStatement callableStmt = conn.prepareCall("{?=call cfappsup.mpt_pfu.VERIFY_ACCOUNT(?,?) } ");
			callableStmt.registerOutParameter(1,12);
			callableStmt.setString(2, userID);
			callableStmt.setString(3, password);
			callableStmt.executeQuery();
			
			result=callableStmt.getString(1);
			callableStmt.close();
			conn.close();

			if (result.startsWith("Welcome"))
			{
				request.getSession().setAttribute("LOGINED", userID);
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
