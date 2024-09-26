package managercontact;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/managercontact")
public class ManagerContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter p = response.getWriter();
		BeanOfContact bean = new BeanOfContact();
		bean.setName(request.getParameter("name"));
		bean.setEmail(request.getParameter("email"));
		bean.setPhone(Long.parseLong(request.getParameter("phone")));
		bean.setMessage(request.getParameter("message"));
		
		int contact = Contact_DAO.contact(bean);
		
		p.println("<html><body>");
		if(contact > 0)
		{
			p.println("<script type='text/javascript'>");
	    	p.println("window.onload = function() {");
	    	p.println("document.getElementById('errorcontact').innerHTML = `<span style='color:blue;'>your message is sent successfully</span>`;");
	    	p.println("}");
	    	p.println("</script>");
	    	request.getRequestDispatcher("contact.html").include(request, response);
		}
		else
		{
			p.println("<script type='text/javascript'>");
	    	p.println("window.onload = function() {");
	    	p.println("document.getElementById('errorcontact').innerHTML = `<span style='color:red;'>something went wrong try to contact again</span>`;");
	    	p.println("}");
	    	p.println("</script>");
	    	request.getRequestDispatcher("contact.html").include(request, response);
		}
		p.println("</body></html>");
		
	}

}
