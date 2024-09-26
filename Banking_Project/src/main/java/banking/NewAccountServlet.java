package banking;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newaccount")
public class NewAccountServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int newAccount = Banking_DAO.createNewAccount(request, response);
		if(newAccount > 0)
		{
			request.getRequestDispatcher("newaccountdetails").include(request, response);

		}
	}

}
















