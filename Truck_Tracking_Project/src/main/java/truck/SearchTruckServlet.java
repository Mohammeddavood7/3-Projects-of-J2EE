package truck;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchtruckservlet")
public class SearchTruckServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter p = response.getWriter();
		BeanOfTruck	bean = new BeanOfTruck();
		bean.setTruckNO(request.getParameter("truck"));
		BeanOfTruck searchTruck = Truck_DAO.searchTruck(bean);
		
		p.println("<html><body>");
		if (searchTruck != null) 
		{
			request.setAttribute("bean", searchTruck);
			request.getRequestDispatcher("findtruck.jsp").forward(request, response);
		}
		else
		{
			p.println("<br>");
			p.println("<h5 style='color:red;text-align:center;'>invalid truck number</h5>"+"<br>");
			request.getRequestDispatcher("findtruck.html").include(request, response);

		}
		p.println("</body></html>");

	}

}














