package truck;

import java.sql.Date;
import java.time.LocalDate;

public class demo {

	@SuppressWarnings({ "deprecation", "static-access" })
	public static void main(String[] args) 
	{
//		Date date = Date.valueOf("2001-03-13");
//		System.out.println(date);
//
//		String dateString = "2020-01-11";
//		Date date1 = Date.valueOf(dateString);
//		System.out.println(date1);

		LocalDate date = LocalDate.now();
	    Date date1 = Date.valueOf(date);
	    
	    date1.setMonth(4);

	     
		System.out.println(date1);

		
	}

}
