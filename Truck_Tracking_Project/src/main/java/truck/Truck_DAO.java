package truck;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import admin.DBConnect;
import manager.BeanOfManager;

public class Truck_DAO 
{
	public static int addTruck(BeanOfTruck bt)
	{
		int update = 0;
		Connection con = DBConnect.getConnection();
		try
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO ROUTE (TRUCKMODEL,TRUCKNO,INSURANCE,INSURANCECOMPANY,OWNER,MOBILE,FROMROUTE,TOROUTE,REGISTER_DATE,STATUS) VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, bt.getTruckModel());
			ps.setString(2, bt.getTruckNO());
			ps.setString(3, bt.getInsurance());
			ps.setString(4, bt.getInsuranceCompany());
			ps.setString(5, bt.getOnwer());
			ps.setLong(6,bt.getMobile());
			ps.setString(7, bt.getFromRoute());
			ps.setString(8, bt.getToRoute());
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(bt.getTruckInstallDate(), formatter);
			Date date = Date.valueOf(localDate);	
			ps.setDate(9, date);
			
			ps.setString(10, bt.getStatus());
			
			update = ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return update;
	}
	
	
	public static BeanOfTruck searchTruck(BeanOfTruck bot)
	{
		BeanOfTruck bean = null;
		
		Connection con = DBConnect.getConnection();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM ROUTE WHERE TRUCKNO  = ? ");
			ps.setString(1, bot.getTruckNO());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				bean = new BeanOfTruck();
				bean.setTruckModel(rs.getString(1));
				bean.setTruckNO(rs.getString(2));
				bean.setOnwer(rs.getString(3));
				bean.setInsurance(rs.getString(4));
				bean.setInsuranceCompany(rs.getString(5));
				bean.setMobile(rs.getInt(6));
				bean.setFromRoute(rs.getString(7));
				bean.setToRoute(rs.getString(8));
				bean.setTruckInstallDate(rs.getString(9));
				bean.setStatus(rs.getString(10));
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return bean;
		
	}
	
	public static ArrayList<BeanOfTruck> truckDetails(BeanOfManager bom)
	{
		BeanOfTruck bot = null;
		ArrayList<BeanOfTruck> lb = new ArrayList<BeanOfTruck>();
		Connection con = DBConnect.getConnection();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM ROUTE WHERE FROMROUTE = ?");
			ps.setString(1, bom.getBranch());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				bot = new BeanOfTruck();
				bot.setTruckModel(rs.getString("TRUCKMODEL"));;
				bot.setTruckNO(rs.getString("TRUCKNO"));
				bot.setMobile(rs.getInt("MOBILE"));
				bot.setOnwer(rs.getString("OWNER"));
				bot.setFromRoute(rs.getString("FROMROUTE"));
				lb.add(bot);
				
			}
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return lb;
	}
	
	@SuppressWarnings("deprecation")
	public static ArrayList<BeanOfTruck> recentlyInstalledTrucks()
	{
		BeanOfTruck bot = null;
		ArrayList<BeanOfTruck> lb = new ArrayList<BeanOfTruck>();
		Connection con = DBConnect.getConnection();
		try 
		{
		
				PreparedStatement pstmt = con.prepareStatement("SELECT *FROM ROUTE WHERE REGISTER_DATE BETWEEN ? AND ? ");
			
			    LocalDate localdate = LocalDate.now();
		        Date currentMonthDate = Date.valueOf(localdate);
		        
		        
		        LocalDate previousMonthDate = LocalDate.now();
			    Date pmd = Date.valueOf(previousMonthDate);
			    pmd.setMonth(4);
		    
				pstmt.setDate(1, pmd);
				pstmt.setDate(2, currentMonthDate);
			    ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				bot = new BeanOfTruck();
				bot.setTruckModel(rs.getString("TRUCKMODEL"));
				bot.setTruckNO(rs.getString("TRUCKNO"));
				bot.setOnwer(rs.getString("OWNER"));
				bot.setMobile(rs.getInt("MOBILE"));
				bot.setFromRoute(rs.getString("FROMROUTE"));
				bot.setToRoute(rs.getString("TOROUTE"));
				
				Date dateof = rs.getDate("REGISTER_DATE");
				bot.setTruckInstallDate(dateof+"");
				
				lb.add(bot);
				
			}
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return lb;
	}


	public static ArrayList<BeanOfTruck> service(String from, String to)
	{
		BeanOfTruck bean = null;
		ArrayList<BeanOfTruck> lb = new ArrayList<BeanOfTruck>();
		Connection con = DBConnect.getConnection();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM ROUTE WHERE FROMROUTE = ? AND TOROUTE = ? ");
			ps.setString(1, from);
			ps.setString(2, to);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				bean = new BeanOfTruck();
				bean.setTruckModel(rs.getString("TRUCKMODEL"));
				bean.setTruckNO(rs.getString("TRUCKNO"));
				bean.setOnwer(rs.getString("OWNER"));
				bean.setMobile(rs.getInt("MOBILE"));
				bean.setInsurance(rs.getString("INSURANCE"));
				lb.add(bean);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lb;
	}
	
	
	
	
	public static ArrayList<BeanOfTruck> status()
	{
		BeanOfTruck bean = null;
		ArrayList<BeanOfTruck> lb = new ArrayList<BeanOfTruck>();
		Connection con = DBConnect.getConnection();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM ROUTE ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				bean = new BeanOfTruck();
				bean.setTruckModel(rs.getString("TRUCKMODEL"));
				bean.setTruckNO(rs.getString("TRUCKNO"));
				bean.setFromRoute(rs.getString("FROMROUTE"));
				bean.setToRoute(rs.getString("TOROUTE"));
				bean.setStatus(rs.getString("STATUS"));
				lb.add(bean);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lb;
	}
	
	
	
	


}














