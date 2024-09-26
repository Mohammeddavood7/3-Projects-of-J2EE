package status;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import truck.BeanOfTruck;
import truck.Truck_DAO;


@WebServlet("/status")
public class StatusServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ArrayList<BeanOfTruck> bean = Truck_DAO.status();
		
		if(bean != null)
		{
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("status.jsp").forward(request, response);
		}
	
		
	}

}














