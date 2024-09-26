package banking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/closeac")
public class ClosedServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
	

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			BeanOfBanking deleteAccount = Banking_DAO.deleteAccount(request, response);
			if (deleteAccount != null) 
			{
				request.setAttribute("bean", deleteAccount);
				request.getRequestDispatcher("closeac.jsp").forward(request, response);
				
			}
		}
			
		

}
