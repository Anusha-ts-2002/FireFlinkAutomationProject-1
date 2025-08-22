package practice;

import org.testng.annotations.Test;

public class ReadDatafromCmdLine {
	
	@Test
	public void readDate()
	{
		String Browser = System.getProperty("browser");
		System.out.println(Browser);
		
		
		String UN = System.getProperty("username");
		System.out.println(UN);
	}

	
	
}
