package TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class sampleTest1 {
	
//	@Test
//	public void sampleTest()
//	{
//		System.out.println("1");
//		System.out.println("2");
//		System.out.println("3");
//		
//		Assert.assertEquals(1,false);//hard Assert
//		System.out.println("4");
//		System.out.println("5");
//	}
//	
	
	@Test
	public void softSampleTest() {
		
		SoftAssert sa = new SoftAssert();
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		//sa.assertEquals(1, 1);//data is passed
		sa.assertEquals(0, false);
		
		System.out.println("4");
		
		sa.assertEquals("a","a");
		System.out.println("5");
		sa.assertAll();//Log the assertions
		
		
	}

}
