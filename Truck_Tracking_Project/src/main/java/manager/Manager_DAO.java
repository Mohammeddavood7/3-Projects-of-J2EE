package manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.DBConnect;

public class Manager_DAO 
{
	public static ArrayList<BeanOfManager> managerDetails(BeanOfManager bean,ArrayList<BeanOfManager> beanOfManager)
	{
		BeanOfManager bom = null;
		Connection con = DBConnect.getConnection();
		try
		{
			 PreparedStatement ps = con.prepareStatement("SELECT *FROM MANAGER WHERE BRANCH = ? AND USERNAME LIKE ?");
			 ps.setString(1, bean.getBranch());
			 ps.setString(2, bean.getUsername()+"%");
			 ResultSet rs = ps.executeQuery();

			 while(rs.next())
			 {
				    
					 bom = new BeanOfManager();
					 bom.setBranch(rs.getString(1));
					 bom.setUsername(rs.getString(2));
					 bom.setPassword(rs.getLong(3));
					 bom.setDateOfJoining(rs.getString(4));
					 bom.setDateOfBirth(rs.getString(5));
					 bom.setSalary(rs.getFloat(6));
					 beanOfManager.add(bom);
					 
				 
			 }
			 
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return beanOfManager;
		
	}
	
	
	
	
	public static int registerNewManager(BeanOfManager bean)
	{
		Connection con = DBConnect.getConnection();
		int executeUpdate = 0;
		try
		{
		      

            Date dof1 = Date.valueOf(bean.getDateOfJoining());
            Date dob1 = Date.valueOf(bean.getDateOfBirth());
            
            
			PreparedStatement ps = con.prepareStatement("INSERT INTO MANAGER VALUES(?,?,?,?,?,?)");
			ps.setString(1, bean.getBranch());
			ps.setString(2, bean.getUsername());
			ps.setLong(3, bean.getPassword());
			ps.setDate(4, dof1);
			ps.setDate(5, dob1);
			ps.setFloat(6, bean.getSalary());
			 executeUpdate = ps.executeUpdate();
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return  executeUpdate ;
		
	}
	
	public static BeanOfManager loginManager(BeanOfManager bom)
	{
		BeanOfManager bean = null;
		Connection con = DBConnect.getConnection();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM MANAGER WHERE USERNAME = ? AND PASSWORD = ?");
			ps.setString(1, bom.getUsername());
			ps.setLong(2, bom.getPassword());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				bean = new BeanOfManager();
		        bean.setBranch(rs.getString("BRANCH"));
				bean.setUsername(rs.getString("USERNAME"));
		        bean.setPassword(rs.getInt("PASSWORD"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return bean;
		
		
	}




}
















