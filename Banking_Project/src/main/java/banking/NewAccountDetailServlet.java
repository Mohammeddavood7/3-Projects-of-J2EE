package banking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/newaccountdetails")
public class NewAccountDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con = Database.connting();
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM BANKING WHERE USERNAME = ? AND PASSWORD = ?");
			ps.setString(1, request.getParameter("uname"));
			ps.setLong(2,Long.parseLong(request.getParameter("pword")));
		    ResultSet rs = ps.executeQuery();
			BeanOfBanking bob = new BeanOfBanking();
			if(rs.next())
			{
				bob.setAccountno(rs.getInt("ACCOUNTNO"));
				bob.setUsername(rs.getString("USERNAME"));
				bob.setPassword(rs.getLong("PASSWORD"));
				bob.setAmount(rs.getFloat("AMOUNT"));
				bob.setPhno(rs.getLong("PHONE"));
				bob.setAddress(rs.getString("ADDRESS"));
				request.setAttribute("bean", bob);
				request.getRequestDispatcher("created.jsp").forward(request, response);
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
