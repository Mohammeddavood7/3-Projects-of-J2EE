package truck;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/recentlytrucks")
public class RecentlyInstalledTruckServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 PrintWriter p = response.getWriter();
         ArrayList<BeanOfTruck> recentlyInstalledTrucks = Truck_DAO.recentlyInstalledTrucks();
    	 HttpSession session = request.getSession();

         p.println("<htm><body>");
         if(recentlyInstalledTrucks != null)
         {
        	 session.setAttribute("recentlyInstalledTrucks", recentlyInstalledTrucks);
        	 request.getRequestDispatcher("recentlyinstalledtruck.jsp").forward(request, response);
         }
         p.println("</body></html>");
		
	}

}









