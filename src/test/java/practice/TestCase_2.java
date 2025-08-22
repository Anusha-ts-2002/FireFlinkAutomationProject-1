package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase_2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
	    Properties pobj =  new Properties();
	    pobj.load(fis);
	    
	      String browser = pobj.getProperty("browser"); 
	      String url =pobj.getProperty("url"); 
		  String un = pobj.getProperty("username"); 
		  String pass = pobj.getProperty("password");
		  
		 
		  
           WebDriver driver = null;
		  
		  if(browser.equals("chrome"))
		  {
			  driver= new ChromeDriver();
		  }else if(browser.equals("firefox")){// it will launxh firefox because in property file we had written itas FF
		     driver = new FirefoxDriver();
		  }else if(browser.equals("Edge"))
		  {
			  driver = new EdgeDriver();
		  }
		  else
		  {
			  driver =new  ChromeDriver();
		  }
		  
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		    driver.get(url);
		    String mainHandle = driver.getWindowHandle();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.id("inputPassword")).sendKeys(pass);
			//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
	
		  FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData1 (3).xlsx");
		    Workbook wb =WorkbookFactory.create(fis1);//method chaining
		    Sheet sh =    wb.getSheet("Sheet1");
		    Row row = sh.getRow(1);
		    String ContactName=row.getCell(2).getStringCellValue().toString();
		    String billAdd=row.getCell(17).getStringCellValue();
		    String shipAdd=row.getCell(18).getStringCellValue();
		    String billBox=row.getCell(19).toString();
		    String shipBox=row.getCell(20).toString();
		    String billCity=row.getCell(21).getStringCellValue();
		    String city=row.getCell(22).getStringCellValue();
		    String billState=row.getCell(23).getStringCellValue();
		    String state=row.getCell(24).getStringCellValue();
		    String billCode=row.getCell(25).toString();
		    String postCode=row.getCell(26).toString();
		    String billCoun=row.getCell(27).getStringCellValue();
		    String country=row.getCell(28).getStringCellValue();
		    String ProdName=row.getCell(8).getStringCellValue();
		    
		  
		   wb.close();
		   
		   driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		   driver.findElement(By.xpath("//span[text()='Create Order']")).click();
		   String dueDate=row.getCell(12).toString();
		   String sub=row.getCell(13).getStringCellValue();
		   
		   
				  
		   driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(dueDate);
		   
		   driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(sub);
		   driver.findElement(By.xpath("//input[@type='text']/following-sibling::button")).click();
		   
		 
		   Set<String> childHandles = driver.getWindowHandles();
		  
		   
		for(String handle:childHandles) {	  
		   if(!handle.equals(mainHandle)) {		
			   driver.switchTo().window(handle);
			   
			   driver.manage().window().maximize();
			   
			   driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(ContactName); 
		   while(true) {
			   try {
				   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
				  
				   driver.findElement(By.xpath("//td[text()='CON00034']/following::button[@class='select-btn']")).click();
				   break;
			   }
			   catch (Exception e) {
				driver.findElement(By.xpath("//button[@id='next-btn']")).click();
			}
			   }
		   }
		}
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.switchTo().window(mainHandle);
		   
		   Actions act=new Actions(driver);
		   act.scrollByAmount(0, 700).perform();
		   
		   driver.findElement(By.xpath("//label[text()='Billing Address']/following-sibling::textarea[@name='address']")).sendKeys( billAdd);
		   
		   driver.findElement(By.xpath("//label[text()='Shipping Address']/following-sibling::textarea[@name='address']")).sendKeys(shipAdd);
		   
		   driver.findElement(By.xpath("//label[text()='Billing PO Box']/following-sibling::input[@name='poBox']")).sendKeys(billBox);
		   
		   driver.findElement(By.xpath("//label[text()='Shipping PO Box']/following-sibling::input[@name='poBox']")).sendKeys(shipBox);
		   
		   driver.findElement(By.xpath("//label[text()='Billing City']/following-sibling::input[@name='city']")).sendKeys(billCity);
		   
		   driver.findElement(By.xpath("//label[text()='City']/following-sibling::input[@name='city']")).sendKeys(city);
		   
		   driver.findElement(By.xpath("//label[text()='Billing State']/following-sibling::input[@name='state']")).sendKeys(billState);
		   
		   driver.findElement(By.xpath("//label[text()='State']/following-sibling::input[@name='state']")).sendKeys(state);
		   
		   driver.findElement(By.xpath("//label[text()='Billing Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(billCode);
		   
		   driver.findElement(By.xpath("//label[text()='Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(postCode);
		   
		   driver.findElement(By.xpath("//label[text()='Billing Country']/following-sibling::input[@name='country']")).sendKeys(billCoun);
		   
		   driver.findElement(By.xpath("//label[text()='Country']/following-sibling::input[@name='country']")).sendKeys(country);
		   
		   
		   driver.findElement(By.xpath("//label[text()='Products']/following::button[@class='action-button']")).click();
		   Set<String> childHandles1 = driver.getWindowHandles();
		   for(String handle1:childHandles1) {	  
			   if(!handle1.equals(mainHandle)) {		
				   driver.switchTo().window(handle1);
				   
				   driver.manage().window().maximize();
				   
				   driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(ContactName); 
			   while(true) {
				   try {
					   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
					  
					   driver.findElement(By.xpath("//td[.='VivoBook24']/following::button[@class='select-btn']")).click();
					   break;
				   }
				   catch (Exception e) {
					driver.findElement(By.xpath("//button[@id='next-btn']")).click();
				}
				   }
			   

		   
		   }
		   

		   
		}
			driver.switchTo().window(mainHandle);
			driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
			driver.findElement(By.xpath("//div[text()='Purchase-Order Vivibook Successfully Added']")).click();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 String h=driver.getWindowHandle();
			 driver.switchTo().window(h);
			 driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 
			 
			 driver.findElement(By.xpath("//a[.='Products']")).click();
			 
			 WebElement prodName = driver.findElement(By.xpath("//select[@class='form-control']"));
			Select s=new Select(prodName);
			s.selectByVisibleText("Search by Product Name");
			driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(ProdName);
			driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();
			
			 String PricePU=row.getCell(9).toString();
			WebElement price = driver.findElement(By.xpath("//input[@name='price']"));
		  
			
		   act.keyDown(price,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).sendKeys("85000").perform();
		   
		   driver.findElement(By.xpath("//button[.='Update']")).click();
		   
		   System.out.println("---Price updated--");
		  
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   String h1=driver.getWindowHandle();
			 driver.switchTo().window(h1);
			driver.findElement(By.xpath("//button[@aria-label='close']")).click();

			 driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
			WebElement subj = driver.findElement(By.xpath("//select[@class='form-control']"));
			Select s1=new Select(subj);
			s1.selectByVisibleText("Search by Subject");
			
			driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(sub);
			driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();
			
			act.scrollByAmount(0, 1000).perform();
			
			 

			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			   
			WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		    act.moveToElement(icon).perform();
			driver.findElement(By.xpath("//div[.='Logout ']")).click();
			
		
	}

}
