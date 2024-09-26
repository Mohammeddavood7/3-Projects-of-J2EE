package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter p = response.getWriter();
		BeanOfAdmin bean = new BeanOfAdmin();
		bean.setUsername(request.getParameter("username"));
		bean.setPassword(Long.parseLong(request.getParameter("password")));
		
		BeanOfAdmin login = Admin_DAO.login(bean);
		
		p.println("<html><body>");
		if(login != null)
		{
		     request.getRequestDispatcher("findmanager.html").include(request, response);	
		}
		else
		{
			p.println("<span style='color:red;'>invalid username/password</span>");
		    request.getRequestDispatcher("admin.html").include(request, response);	

		}
		p.println("</body></html>");
	}

}
















