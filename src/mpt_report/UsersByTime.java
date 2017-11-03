package mpt_report;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersByTime extends HttpServlet 
{
		private static final long serialVersionUID = 1L;
    public UsersByTime() 
    { super();   }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String txtStartDate = request.getParameter("txtStartDate");
			String txtEndDate 	= request.getParameter("txtEndDate");
			
			EnvClass envClass = (EnvClass)request.getSession().getAttribute("ENVCLASS");
			MainClass mainClass = new MainClass(envClass);
			
			String result, result1, result2, result3, result4, result5, result6, result7, result8, result9;
			result = result1 = result2 = result3 = result4 = result5 = result6 = result7 = result8 = result9 = null;
			try {
				result = mainClass.F1SSO_NEW_ACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result1 = mainClass.F1SSO_DEACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result2 = mainClass.F1CAS_NEW_ACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result3 = mainClass.F1CAS_DEACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result4 = mainClass.OMNNI_NEW_ACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result5 = mainClass.OMNNI_DEACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result6 = mainClass.CPS_NEW_ACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result7 = mainClass.CPS_DEACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result8 = mainClass.PEGA_NEW_ACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
				result9 = mainClass.PEGA_DEACTIVATED_USR_BYTIME(txtStartDate, txtEndDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			
			request.getSession().setAttribute("F1SSO_NEW_ACTIVE_USERS_MONTHLY", result);
			request.getSession().setAttribute("F1SSO_DEACTIVATED_USR_MONTHLY", result1);
			request.getSession().setAttribute("F1CAS_NEW_ACTIVATED_USR_BYTIME", result2);
			request.getSession().setAttribute("F1CAS_DEACTIVATED_USR_BYTIME", result3);
			request.getSession().setAttribute("OMNNI_NEW_ACTIVATED_USR_BYTIME", result4);
			request.getSession().setAttribute("OMNNI_DEACTIVATED_USR_BYTIME", result5);
			request.getSession().setAttribute("CPS_NEW_ACTIVATED_USR_BYTIME", result6);
			request.getSession().setAttribute("CPS_DEACTIVATED_USR_BYTIME", result7);
			request.getSession().setAttribute("PEGA_NEW_ACTIVATED_USR_BYTIME", result8);
			request.getSession().setAttribute("PEGA_DEACTIVATED_USR_BYTIME", result9);
			
			request.getSession().setAttribute("TXT_START_DATE", txtStartDate);
			request.getSession().setAttribute("TXT_END_DATE", txtEndDate);
			response.sendRedirect("users_by_time.jsp");
		}
}

