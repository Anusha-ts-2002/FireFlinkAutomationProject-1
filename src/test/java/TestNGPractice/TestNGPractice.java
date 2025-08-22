package TestNGPractice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test
	public void create()
	{
		System.out.println("created");	
		
	}
	//@Test(priority=1)//providing the priority to run
	//@Test(invocationCount=2)
	@Test(dependsOnMethods="delete")
	public void modify()
	{
		System.out.println("modified");
	}
	
	@Test(dependsOnMethods={"create","modify"})
	public void delete()
	{
		System.out.println("deleted");
	}
	
}
