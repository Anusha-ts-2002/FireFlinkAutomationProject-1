package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

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

import ninzaCRM.ObjectRepository.LoginPage;
import ninzaCRMgenericUtilities.FileUtility;
import ninzaCRMgenericUtilities.WebDriverUtility;

public class TC_01{

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		FileUtility fu = new FileUtility();
		
		
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		  Properties p=new Properties();
		
		  p.load(fi);
		  
		  String browser =fu.readdatafromPropertyfile("browser");
				 // p.getProperty("browser");
		  String Url=fu.readdatafromPropertyfile("url");
				  //p.getProperty("url");
		  String UN=fu.readdatafromPropertyfile("UN");
				  //p.getProperty("username");
		  String Pwd=fu.readdatafromPropertyfile("Pwd");
				  //p.getProperty("password");
		  
		  WebDriver driver=null;
		  
		
		  if(browser.equals("Edge")) {
			  driver= new EdgeDriver();
			  //driver = new ChromeDriver()
		  }
		  else if (browser.equals("Edge")) {
			driver=new EdgeDriver();
		
		}
		  else if (browser.equals("firefox")) {
				driver=new FirefoxDriver();
				
			}
		  else
		  {
			  driver=new EdgeDriver(); 
		  }
		  
		  WebDriverUtility web = new WebDriverUtility();
		  web.maximizeWindow(driver);
		  //driver.manage().window().maximize();
		  
		  
		  driver.get(Url);
		  
		  //Login to Application
		  LoginPage lp = new LoginPage(driver);
		  lp.LoginToApp(UN, Pwd);
		  
		  
		  //login to application by using the loginpage object
		  lp.getUsernameTF().sendKeys(UN);
		  lp.getPasswordTF().sendKeys(Pwd);
		  lp.getSubmitBtn().click();
		  
		  String mainHandle=web.gettingcurrentwindowID(driver);
				  //driver.getWindowHandle();	
		  
		  
		  driver.findElement(By.id("username")).sendKeys(UN);
		  driver.findElement(By.id("inputPassword")).sendKeys(Pwd);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();

	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		  Thread.sleep(2000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		  driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		  Thread.sleep(2000);
		  FileInputStream fis=new  FileInputStream(".\\src\\test\\resources\\TestData1 (3).xlsx");
		  
			Workbook wb=WorkbookFactory.create(fis);
			
			//Workbook wb = WorkbookFactory
		    Sheet sh= wb.getSheet("Sheet1");
		     
		   Row row= sh.getRow(1);
		
		   //fu.readdatafromexcelsheet("Sheet1", 1, 2);
		   
		   String ContactName=row.getCell(2).getStringCellValue();	
		   String organization=row.getCell(3).getStringCellValue();
		  String Mobile= row.getCell(4).toString();
		  String title=row.getCell(5).getStringCellValue();
		  String cpgId=row.getCell(6).getStringCellValue();
		  //System.out.println(cpgId);
		  String email=row.getCell(15).getStringCellValue();
		  String Dept=row.getCell(14).getStringCellValue();
		  String offPhone=row.getCell(16).toString();
		  
		  
		  driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(ContactName);
		  
		  driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
		  
		  driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(Mobile);
		  
		  driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		  
		  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		  
		  driver.findElement(By.xpath("//input[@name='department']")).sendKeys(Dept);
		  
		  driver.findElement(By.xpath("//input[@name='officePhone']")).sendKeys(offPhone);
		  
		  driver.findElement(By.xpath("//input[@type='text']/following-sibling::button[@type='button']")).click();
		  
		   Set<String> childHandles = driver.getWindowHandles();
		   for(String handle:childHandles) {
			   if(!handle.equals(mainHandle)) {
				   driver.switchTo().window(handle);
				   
				   driver.manage().window().maximize();
				   
				   driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(cpgId);
				   
				   
			
				   while(true) {
					   try {
							   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
						   driver.findElement(By.xpath("//td[text()='CAM05313']/following::button[@class='select-btn']")).click();
						   break;
					   }
				   
					  catch(Exception e) {
	                  driver.findElement(By.xpath("//button[@id='next-btn']")).click();
					 
				                          }
					   
				                }
				   driver.switchTo().window(mainHandle);			  
				   driver.findElement(By.xpath("//button[@type='submit']")).submit();
				   System.out.println("Succesfully added contact");
				   
				   
				   //------------Adding product--------------------------
				   
				  String Quantity= row.getCell(7).toString();
	              String ProdName=row.getCell(8).getStringCellValue();
				  String PricePU=row.getCell(9).toString();
				  String catefory=row.getCell(10).getStringCellValue();
				  String vendor=row.getCell(11).getStringCellValue();
				  
				  
				  Actions act=new Actions(driver);
				   
				   
				   driver.findElement(By.xpath("//a[text()='Products']")).click();
				   
				   driver.findElement(By.xpath("//span[text()='Add Product']")).click();
				   
				  WebElement quant = driver.findElement(By.xpath("//input[@name='quantity']"));
				  
				  
				  act.keyDown(Keys.BACK_SPACE).perform();
				  
				  
				   act.keyUp(Keys.BACK_SPACE).perform();
				   quant.sendKeys(Quantity);
				   
				   driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(ProdName);
				   
				   WebElement price = driver.findElement(By.xpath("//input[@name='price']"));			   
				 
				 WebElement ele= driver.findElement(By.xpath("//select[@name='productCategory']"));
				 
				 Select s=new Select(ele);
				
				 s.selectByVisibleText("Electronics");
				 
				 WebElement ele1 = driver.findElement(By.xpath("//select[@name='vendorId']"));
				 
				 Select s1=new Select(ele1);
				 s1.selectByVisibleText("Vendor_68300 - (Electronics)");
//				   
				  driver.findElement(By.xpath("//button[@type='submit']")).click();
		   
		   
		   
		   
		   
		   //---------------------Purchase order-----------------------------------
				  
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
		   
		   
		   
		   driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		   driver.findElement(By.xpath("//span[text()='Create Order']")).click();
		   String dueDate=row.getCell(12).toString();
		   String sub=row.getCell(13).getStringCellValue();
		   
		   
				  
		   driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(dueDate);
		   
		   driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(sub);
		   driver.findElement(By.xpath("//input[@type='text']/following-sibling::button")).click();
		   
		  
		   Set<String> childHandle = driver.getWindowHandles();
		  
		
	   for(String handles:childHandle) {	  
		   if(!handles.equals(mainHandle)) {		
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
		   
		   Actions act1=new Actions(driver);
		   act1.scrollByAmount(0, 700).perform();
		   
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
				   
				   driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(ProdName); 
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
			driver.switchTo().window(mainHandle)	 ;
			driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			 System.out.println("waiting is over");
			 
			 String h=driver.getWindowHandle();
			 driver.switchTo().window(h);
			 driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
			act.moveToElement(icon).perform();
			driver.findElement(By.xpath("//div[.='Logout ']")).click();
			
			
			
	}

		   }
	}
}
