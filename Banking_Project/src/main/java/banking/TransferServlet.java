package banking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BeanOfBanking transferAmount = null;
		try {
			transferAmount = Banking_DAO.transferAmount(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (transferAmount != null) 
		{
			request.setAttribute("bean", transferAmount);
			request.getRequestDispatcher("transfer.jsp").forward(request, response);
			
		}
		
	}

}

















