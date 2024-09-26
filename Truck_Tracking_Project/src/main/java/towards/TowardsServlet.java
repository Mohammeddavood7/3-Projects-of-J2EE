package towards;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import manager.BeanOfManager;
import truck.BeanOfTruck;
import truck.Truck_DAO;

@WebServlet("/towardshereservlet")
public class TowardsServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		HttpSession session = request.getSession();
		BeanOfManager bean = (BeanOfManager) session.getAttribute("bean");
		
		bean.setBranch(bean.getBranch());
		bean.setUsername(bean.getUsername());
	    ArrayList<BeanOfTruck> truckDetails = Truck_DAO.truckDetails(bean);
   
	    p.println("<html><body>");
	    if(truckDetails != null)
	    {
	    	HttpSession ss = request.getSession();
	    	ss.setAttribute("truck", truckDetails);
	    	request.getRequestDispatcher("towardshere.jsp").forward(request, response);
	    	
	    }
	    p.println("</body></html>");
	    
	}

}

















