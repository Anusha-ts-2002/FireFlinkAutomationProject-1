package TestNGPractice;

import org.testng.annotations.Test;

public class DataProvider {

	
	@Test(dataProvider="customerInfo")
	public void create(String name, int id)//cust - name,id
	{
		//Assert.fail
		System.out.println(id + name);
	}
	
	@org.testng.annotations.DataProvider(name="customerInfo")
	public Object[][] getdata()
	{
		//4 row and 2 col means -- 4 data sets with 2 individual values each
		Object[][] data = new Object[4][2];
		
		data[0][0]="batman";
		data[0][1]=1;
		
		data[1][0]="spiderman";
		data[1][1]=2;
		
		data[2][0]="ironman";
		data[2][1]=3;
		
		data[3][0]="hulk";
		data[3][1]=4;
		return data;
	}
}
