package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/findmanager")
public class FindManagerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter p = response.getWriter();
		BeanOfManager bean = new BeanOfManager();
		bean.setBranch(request.getParameter("branch"));
	    char firstLetter = request.getParameter("username").charAt(0);
		bean.setUsername(firstLetter+"");
		
		ArrayList<BeanOfManager> managerDetails = Manager_DAO.managerDetails(bean, new ArrayList<BeanOfManager>());		
		
		 p.println("<htm><body>");
		if (managerDetails != null) 
		{   
			request.setAttribute("bean", managerDetails);
			request.getRequestDispatcher("findmanager.jsp").forward(request, response);
		}
		else
		{
			System.out.println("error");
			p.println("<span style='color:red;'>no such manager are available</span>"+"<br>");
			request.getRequestDispatcher("findmanager.html").forward(request, response);
			
		}
		p.println("</body></html>");
		
		
		
	}

}















