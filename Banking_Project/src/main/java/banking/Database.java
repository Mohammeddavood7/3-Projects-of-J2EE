package banking;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database 
{
	static Connection con;
	
	static
	{
		try
		{
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SERVLET","TIGER");
		 con.setAutoCommit(false);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection connting()
	{
		return con;
	}

}


















