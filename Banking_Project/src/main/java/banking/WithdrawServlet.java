package banking;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

       BeanOfBanking withdraw = Banking_DAO.withdrawAmount(request, response);
	   PrintWriter p = response.getWriter();

	   
	   if(WrapperClassModification.getValue() == 1)
	   {
		   System.out.println(WrapperClassModification.getValue());
		    p.println("<html><body><center>");
			p.println("<h1 style='color:red;'>Insuficent Amount !!!</h1>");
			request.getRequestDispatcher("withdraw.html").include(request, response);
			p.println("</center></body></html>");
		  	
	   }
	   else 
	   {
		   if (withdraw != null) 
			{
				request.setAttribute("bean", withdraw);
				request.getRequestDispatcher("withdraw.jsp").forward(request, response);
				
			}
			else
			{
				p.println("<html><body><center>");
				p.println("<h1 style='color:red;'>invalid username/password !!!</h1>");
				request.getRequestDispatcher("withdraw.html").include(request, response);
				p.println("</center></body></html>");
			}
	   }
      
		
	}

}



























