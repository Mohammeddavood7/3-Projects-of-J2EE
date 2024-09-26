package ManagerLogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import manager.BeanOfManager;
import manager.Manager_DAO;

@WebServlet("/managerlogin")
public class ManagerLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{  
        response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		BeanOfManager bean = new BeanOfManager();
	    bean.setUsername(request.getParameter("username"));
	    bean.setPassword(Long.parseLong( request.getParameter("password")));
	    BeanOfManager login = Manager_DAO.loginManager(bean);
	   
	    p.println("<html><body>");
	    if(login != null)
	    {
	       HttpSession s = request.getSession();
	       s.setAttribute("bean", login);
	       request.getRequestDispatcher("afterloginasaccountant.jsp").forward(request, response);
	    }
	    else
	    {
	    	p.println("<script type='text/javascript'>");
	    	p.println("window.onload = function() {");
	    	p.println("document.getElementById('usernamepassword').innerHTML = `<span style='color:red;'>invalid username/password</span>`;");
	    	p.println("}");
	    	p.println("</script>");
	    	request.getRequestDispatcher("homepage.html").include(request, response);
	    }
	    p.println("</body></html>");
		
	}

}
















