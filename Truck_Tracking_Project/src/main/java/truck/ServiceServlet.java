package truck;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/serviceServlet")
public class ServiceServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		ArrayList<BeanOfTruck> service = Truck_DAO.service(from,to);
		
		if(service != null)
		{
			request.setAttribute("bean", service);
			request.getRequestDispatcher("servicedetail.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("service.jsp").include(request, response);
		}

		
		
	}

}















