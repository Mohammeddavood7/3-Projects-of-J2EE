package managercontact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import admin.DBConnect;

public class Contact_DAO 
{
	public static int contact(BeanOfContact boc)
	{
		int executeUpdate = 0;
		Connection con = DBConnect.getConnection();
		try 
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO M_TO_A VALUES(?,?,?,?)");
			ps.setString(1, boc.getName());
			ps.setString(2,boc.getEmail());
			ps.setLong(3, boc.getPhone());
		    ps.setString(4, boc.getMessage());
		    executeUpdate = ps.executeUpdate();
		  
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return executeUpdate;
	}

}
