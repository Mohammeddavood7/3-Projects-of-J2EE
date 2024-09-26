package banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Banking_DAO 
{
	public static int createNewAccount(HttpServletRequest request,HttpServletResponse response)
	{
		int executeUpdate = 0;
		BeanOfBanking bob = new BeanOfBanking();
		bob.setUsername(request.getParameter("uname"));
		
		String password = request.getParameter("pword");
		String rword = request.getParameter("rword");
		
		if(password.equals(rword))
		{
			bob.setPassword(Long.parseLong(password));
			bob.setAmount(Float.parseFloat(request.getParameter("amount")));
			bob.setAddress(request.getParameter("address"));
			bob.setPhno(Long.parseLong(request.getParameter("phone")));
			
			Connection con = Database.connting();
			try 
			{
				PreparedStatement ps = con.prepareStatement("INSERT INTO BANKING (USERNAME,PASSWORD,AMOUNT,PHONE ,ADDRESS) VALUES (?,?,?,?,?)");
				ps.setString(1, bob.getUsername());
				ps.setDouble(2, bob.getPassword());
				ps.setDouble(3,bob.getAmount());
				ps.setLong(4,bob.getPhno());
				ps.setString(5,bob.getAddress());
				executeUpdate = ps.executeUpdate();
				if(executeUpdate>0)
			    {
					con.commit();
			    }
				
			}
			catch (Exception e) 
			{
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		else
		{
	         try {
			request.getRequestDispatcher("newaccount.html").forward(request, response);
			} catch (IOException | ServletException e) {
				e.printStackTrace();
			}
		}
		
		
		return executeUpdate;
	}
	
	
	
	public static BeanOfBanking balaceChecking(BeanOfBanking bob)
	{
		
		BeanOfBanking bean = null;
		
		Connection con = Database.connting();
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM BANKING WHERE ACCOUNTNO = ? AND USERNAME= ? AND PASSWORD = ?");
			ps.setLong(1, bob.getAccountno());
			ps.setString(2,bob.getUsername());
			ps.setLong(3, bob.getPassword());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				con.commit();
				bean = new BeanOfBanking();
				bean.setAccountno(rs.getInt("ACCOUNTNO"));
				bean.setUsername(rs.getString("USERNAME"));
				bean.setAmount(rs.getFloat("AMOUNT"));
				bean.setAddress(rs.getString("ADDRESS"));
				bean.setPhno(rs.getLong("PHONE"));
			}	
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return bean;
		
	}
	
	
	public static BeanOfBanking deposit(HttpServletRequest request , HttpServletResponse response)
	{
		int executeUpdate = 0;
		BeanOfBanking bean = null;
		Connection con = Database.connting();
		try
		{
			PreparedStatement ps = con.prepareStatement("UPDATE BANKING SET AMOUNT = AMOUNT +  ? WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ? ");
			ps.setDouble(1,Double.parseDouble(request.getParameter("amount")));
			ps.setLong(2, Long.parseLong(request.getParameter("accountno")));
			ps.setString(3, request.getParameter("uname"));
			ps.setLong(4, Long.parseLong(request.getParameter("pword")));
			executeUpdate = ps.executeUpdate();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT ACCOUNTNO,USERNAME,AMOUNT FROM BANKING WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ?");
			pstmt.setLong(1,Long.parseLong(request.getParameter("accountno")));
			pstmt.setString(2, request.getParameter("uname"));
			pstmt.setLong(3, Long.parseLong(request.getParameter("pword")));
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				con.commit();
				bean = new BeanOfBanking();
				bean.setAccountno(rs.getLong("ACCOUNTNO"));
				bean.setUsername(rs.getString("USERNAME"));
				bean.setAmount(rs.getFloat("AMOUNT"));
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if (executeUpdate > 0)
		{
			return bean;
		}
		
		return bean;
		
	}
	
	
	public static BeanOfBanking withdrawAmount(HttpServletRequest request , HttpServletResponse response)
	{
		int executeUpdate = 0;
		BeanOfBanking bean = null;
		Connection con = Database.connting();
		try
		{
			

			PreparedStatement pstmt = con.prepareStatement("SELECT ACCOUNTNO,USERNAME,AMOUNT FROM BANKING WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ?");
			pstmt.setLong(1,Long.parseLong(request.getParameter("accountno")));
			pstmt.setString(2, request.getParameter("uname"));
			pstmt.setLong(3, Long.parseLong(request.getParameter("pword")));
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				float amount = rs.getFloat("AMOUNT");
				if(Float.parseFloat(request.getParameter("amount")) > amount)
				{
					WrapperClassModification.setValue(1);;
				     
				}
				else
				{
					WrapperClassModification.setValue(0);;
					PreparedStatement ps = con.prepareStatement("UPDATE BANKING SET AMOUNT = AMOUNT -  ? WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ? ");
					ps.setDouble(1,Double.parseDouble(request.getParameter("amount")));
					ps.setLong(2, Long.parseLong(request.getParameter("accountno")));
					ps.setString(3, request.getParameter("uname"));
					ps.setLong(4, Long.parseLong(request.getParameter("pword")));
					executeUpdate = ps.executeUpdate();
					con.commit();
					
					PreparedStatement pstmt1 = con.prepareStatement("SELECT ACCOUNTNO,USERNAME,AMOUNT FROM BANKING WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ?");
					pstmt1.setLong(1,Long.parseLong(request.getParameter("accountno")));
					pstmt1.setString(2, request.getParameter("uname"));
					pstmt1.setLong(3, Long.parseLong(request.getParameter("pword")));
					ResultSet rs1 = pstmt.executeQuery();
					rs1.next();
					bean = new BeanOfBanking();
					bean.setAccountno(rs1.getLong("ACCOUNTNO"));
					bean.setUsername(rs1.getString("USERNAME"));
					bean.setAmount(rs1.getFloat("AMOUNT"));

				}
			}
			
			 
				

			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		if (executeUpdate > 0)
		{
			return bean;
		}
		
		return bean;
		
	}
	
	
	
	public static BeanOfBanking transferAmount(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		BeanOfBanking bob = null;
		Connection con = Database.connting();
		Savepoint s1 = con.setSavepoint();
		PrintWriter p = null;
	
		try 
		{
			p = response.getWriter();
			PreparedStatement ps1 = con.prepareStatement("SELECT *FROM BANKING WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ? ");
			ps1.setLong(1, Long.parseLong(request.getParameter("accountno")));
			ps1.setString(2, request.getParameter("uname"));
			ps1.setLong(3, Long.parseLong(request.getParameter("pword")));
			ResultSet rs1 = ps1.executeQuery();
			
				
	
			if(rs1.next())
			{
				double targetAmount = rs1.getDouble("AMOUNT");
				double amount = Double.parseDouble(request.getParameter("amount"));
				int executeUpdate = 0;
				
				
				   PreparedStatement ps3 = con.prepareStatement("UPDATE BANKING SET AMOUNT = AMOUNT + ? WHERE ACCOUNTNO = ?");
				   ps3.setDouble(1, amount);
				   ps3.setLong(2, Long.parseLong(request.getParameter("targetaccount")));
				   int executeUpdate2 = ps3.executeUpdate();
					   if(executeUpdate2 > 0)
					   {
					      con.commit();
					      
					      if(validateAmount(amount, targetAmount))
							{
								PreparedStatement ps2 = con.prepareStatement("UPDATE BANKING SET AMOUNT = AMOUNT - ? WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ?");
								ps2.setDouble(1, amount);
								ps2.setLong(2, Long.parseLong(request.getParameter("accountno")));
								ps2.setString(3, request.getParameter("uname"));
								ps2.setLong(4, Long.parseLong(request.getParameter("pword")));
								executeUpdate = ps2.executeUpdate();
								
										if(executeUpdate > 0) 
										{
											con.commit();
											PreparedStatement ps4 = con.prepareStatement("SELECT *FROM BANKING WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ? ");
											ps4.setLong(1, Long.parseLong(request.getParameter("accountno")));
											ps4.setString(2, request.getParameter("uname"));
											ps4.setLong(3, Long.parseLong(request.getParameter("pword")));
											ResultSet rs4 = ps4.executeQuery();
											while(rs4.next())
											{
												bob = new BeanOfBanking();
												bob.setAccountno(rs4.getInt(1));
												bob.setUsername(rs4.getString(2));
												bob.setAmount(rs4.getFloat(4));
												
											}
					
										}
										else
										{
											con.rollback();
											p.println("<html><body><center>");
											p.println("<h4 style='color:red;'>Invalid username/password/accountnumber<h4>");
											request.getRequestDispatcher("transfer.html").include(request, response);
											p.println("</center></boyd></html>");
										}
								
										}	
										else
										{
											p.println("<html><body><center>");
											p.println("<h4 style='color:red;'>+ive number & it should less or equal to balance<h4>");
											request.getRequestDispatcher("transfer.html").include(request, response);
											p.println("</center></boyd></html>");
										}
					      
					      
					   }
					   else
					   {
						   
						   p.println("<html><body><center>");
							p.println("<h4 style='color:red;'>Invalid Accountnumber<h4>");
							request.getRequestDispatcher("transfer.html").include(request, response);
							p.println("</center></boyd></html>");
					   }	
				}
				else
				{
					try 
					{    
						p.println("<html><body><center>");
						p.println("<h4 style='color:red;'>Invalid username/password/accountnumber<h4>");
						request.getRequestDispatcher("transfer.html").include(request, response);
						p.println("</center></boyd></html>");
					} 
					catch (ServletException | IOException e) {
						e.printStackTrace();
					}
				
				}
				
				
	
				
			}
		catch (Exception e)
		{
			try
			{
				con.rollback(s1);
			} 
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}
		
		return bob;
	}
		
		
		
		
	public static boolean validateAmount(double amount,double targetAmount)
	{
		
		if(!(amount <= 0 || amount > targetAmount))
		{
			return true;
			
		}
		else 
		{
			return false;
		}
		
	}
	
	
	
	public static BeanOfBanking deleteAccount(HttpServletRequest request,HttpServletResponse response)
	{
		BeanOfBanking bean = null;
		Connection con = Database.connting();
		int executeUpdate = 0;
		try 
		{
			PreparedStatement ps = con.prepareStatement("DELETE FROM BANKING WHERE ACCOUNTNO = ? AND USERNAME = ? AND PASSWORD = ?");
			ps.setLong(1, Long.parseLong(request.getParameter("accountno")));
			ps.setString(2, request.getParameter("uname"));
			ps.setLong(3, Long.parseLong(request.getParameter("pword")));
			executeUpdate = ps.executeUpdate();	
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(executeUpdate >0)
		{
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			bean = new BeanOfBanking();
			bean.setAccountno(Long.parseLong(request.getParameter("accountno")));
			bean.setUsername(request.getParameter("uname"));
			return bean;
		}
		return bean;
	}
	
}








