package newmanager;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.BeanOfManager;
import manager.Manager_DAO;

@WebServlet("/newmanager")
public class NewManagerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 BeanOfManager bom = new BeanOfManager();
		 bom.setBranch(request.getParameter("branch"));
		 bom.setUsername(request.getParameter("username"));
		 bom.setPassword(Long.parseLong(request.getParameter("password")));
		 bom.setDateOfJoining(request.getParameter("doj"));
		 bom.setDateOfBirth(request.getParameter("dob"));
		 bom.setSalary(Float.parseFloat(request.getParameter("salary")));
		int update = Manager_DAO.registerNewManager(bom);
		
		PrintWriter p = response.getWriter();
		
		p.println("<html><body>");
		if(update > 0)
		{    
			p.println("<span style='color:blue;text-align:center;'>you have added new manager successfully</span>");
			request.getRequestDispatcher("createnewmanager.html").include(request, response);
		}
		else
		{
			p.println("<span style='color:red;text-align:center;'>new manager not added,try again</span>");
			request.getRequestDispatcher("createnewmanager.html").include(request, response);

		}
		 p.println("</body><html>");
	}

}

















