package mpt_report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exporttoexcel")
public class ExportToExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ExportToExcel() {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    	   HttpServletResponse response) throws ServletException, IOException {
    	 
    	  List<Employee> employees = new ArrayList<Employee>();
    	  employees.add(new Employee("Yashwant", "Chavan", "30"));
    	  employees.add(new Employee("Dinesh", "Patil", "19"));
    	  employees.add(new Employee("Samadhan", "Mali", "45"));
    	  request.setAttribute("employees", employees); 
    	  RequestDispatcher rd = request.getRequestDispatcher("report1.jsp");
    	  rd.forward(request, response);
    	 }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("abcd");
		List<Employee> employees = new ArrayList<Employee>();
	  employees.add(new Employee("Yashwant", "Chavan", "30"));
	  employees.add(new Employee("Dinesh", "Patil", "19"));
	  employees.add(new Employee("Samadhan", "Mali", "45"));
	  request.setAttribute("employees", employees); 
	  RequestDispatcher rd = request.getRequestDispatcher("excelreport.jsp");
	  rd.forward(request, response);
	}

}
