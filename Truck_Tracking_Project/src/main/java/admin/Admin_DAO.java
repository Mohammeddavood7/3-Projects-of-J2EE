package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_DAO
{
	public static BeanOfAdmin login(BeanOfAdmin bean)
	{
		BeanOfAdmin boa = null;
		Connection con = DBConnect.getConnection();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM TRANSPORT_ADMIN WHERE ADMIN_NAME = ? AND ADMIN_PASSWORD = ?");
			ps.setString(1, bean.getUsername().toUpperCase());
			ps.setLong(2, bean.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				boa = new BeanOfAdmin();
				boa.setUsername(rs.getString("ADMIN_NAME"));
				boa.setPassword(rs.getInt("ADMIN_PASSWORD"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return boa;
		
	}

}
















