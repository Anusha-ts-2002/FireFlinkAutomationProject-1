package ninzaCRMgenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class consists of generic methods related to java
 */
public class JavaUtility {

	/**
	 * This method will capture current system data and return it into caller method[main]
	 * @return 
	 */
	public String getsystemDate()
	{
		
		String date;
		Date d = new Date();
		SimpleDateFormat s= new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		date = s.format(d);
		return date;
	}
	
	/**
	 * This method will generate randomNumber and return it to caller
	 * @return
	 */
	
	public int generaterandomnumber()
	{
		Random random = new Random();
	    int r=	random.nextInt(1000);
		return r;
	}
}
