package mpt_report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.CallableStatement;

/**
 * Servlet implementation class ViewNEMFUserServlet
 */
@WebServlet("/ViewNEMFUserServlet")
public class ViewNEMFUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNEMFUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			int result = this.ViewNEMFUser();
			System.out.println("Number of NEMF User: " + result);
			request.getSession().setAttribute("NUMBER_NEMF_USER", result);
			
			response.sendRedirect("page2.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public int ViewNEMFUser()
		    throws Exception
		  {
		    int result = 0;
		    Connection conn = getConnection();
		    CallableStatement callableStmt = conn.prepareCall("{?=call readuser.mpt_report.ViewNEMFUser} ");
		    callableStmt.registerOutParameter(1, 4);
		    callableStmt.executeUpdate();
		    conn.commit();
		    result = callableStmt.getInt(1);
		    callableStmt.close();
		    conn.close();
		    
		    return result;
		  }
	
	
		  
	  private Connection getConnection() throws Exception
	  {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.30.110.93:1521:finnuat5", "readuser","SERF1UAT05");
	    conn.setAutoCommit(false);
	    
	    return conn;
	  }
}
