package banking;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/balance")
public class BalanceCheckingServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BeanOfBanking bob = new BeanOfBanking();
		bob.setAccountno(Long.parseLong(request.getParameter("accountno")));
		bob.setUsername(request.getParameter("uname"));
		bob.setPassword(Long.parseLong(request.getParameter("pword")));
		BeanOfBanking bean = Banking_DAO.balaceChecking(bob);
		
		if(bean != null)
		{
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("balance.jsp").forward(request, response);
		}
		else
		{
			PrintWriter p = response.getWriter();
			p.println("<html><body><center>");
			p.println("<h1 style='color:red;'>invalid username/password !!!</h1>");
			request.getRequestDispatcher("balance.html").include(request, response);
			p.println("</center></body></html>");
	
		}
		
	}

}















