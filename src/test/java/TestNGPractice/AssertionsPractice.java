package TestNGPractice;

import org.testng.annotations.Test;

import ninzaCRMgenericUtilities.BaseClass;

public class AssertionsPractice extends BaseClass{

	@Test
	public void sampleTest()
	{
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		
		if(1==1)// dont use if else condition  not recommended
		{
			System.out.println("pass");
		}
		
		else {
			System.out.println("fail");
		}
		
		System.out.println("step-4");
		System.out.println("step-5");
	}
}
