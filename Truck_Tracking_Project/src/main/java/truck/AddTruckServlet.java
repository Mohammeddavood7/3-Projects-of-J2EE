package truck;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addtruck")
public class AddTruckServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter p = response.getWriter();
		BeanOfTruck bt = new BeanOfTruck();
		bt.setTruckModel(request.getParameter("truckModel"));
		bt.setTruckNO(request.getParameter("truckNo"));
		bt.setInsurance(request.getParameter("insurance"));
		bt.setOnwer(request.getParameter("insuranceCompany"));
		bt.setInsuranceCompany(request.getParameter("owner"));
	    bt.setMobile(Long.parseLong(request.getParameter("mobile")));
	    bt.setFromRoute(request.getParameter("routeFrom"));
	    bt.setToRoute(request.getParameter("routeTo"));
	    bt.setTruckInstallDate(request.getParameter("date"));
	    bt.setStatus(request.getParameter("status"));
	    
	    int truck = Truck_DAO.addTruck(bt);
	    
	    p.println("<html><body>");
	    if(truck > 0)
	    {
	        request.getRequestDispatcher("installnewtrack.html").include(request, response);
	    	p.println("<h4 style='text-align:center;color:blue;'>Truck Is Added Successfully</h4>");

	    }
	    else
	    {
	    	p.println("<h4 style='text-align:center; color:red;'>truck is not add,try again</h4>");
	        request.getRequestDispatcher("installnewtrack.html").include(request, response);
	    }
	    p.println("</body></html>");
		
	}

}














