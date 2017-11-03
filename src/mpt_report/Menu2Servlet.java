package mpt_report;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Menu2Servlet")
public class Menu2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Menu2Servlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Start Menu2Servlet");
		EnvClass envClass 	= (EnvClass)request.getSession().getAttribute("ENVCLASS");
		MainClass mainClass = new MainClass(envClass);
		List<String> dataList = new ArrayList<String>(); 
		dataList = null;
		try 
		{
			dataList = (List<String>) mainClass.GET_DATA_IN_TABLE();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		request.getSession().setAttribute("data", dataList);
		System.out.println("End Menu2Servlet");
		/*for (int i=0; i<dataList.size(); i++)
		{
			System.out.println(dataList.get(i));
		}*/
		response.sendRedirect("menu2.jsp");
	}

}
