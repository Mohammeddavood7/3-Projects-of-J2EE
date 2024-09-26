package banking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BeanOfBanking deposit = Banking_DAO.deposit(request, response);
		
		if (deposit != null) 
		{
			request.setAttribute("bean", deposit);
			request.getRequestDispatcher("deposit.jsp").forward(request, response);
			
		}
		else
		{
			PrintWriter p = response.getWriter();
			p.println("<html><body><center>");
			p.println("<h1 style='color:red;'>invalid username/password !!!</h1>");
			request.getRequestDispatcher("deposit.html").include(request, response);
			p.println("</center></body></html>");
		}
		
	}

}


















