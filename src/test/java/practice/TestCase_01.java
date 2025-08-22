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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase_01 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		//WebDriver driver = new ChromeDriver();
		
		//Thread.sleep(5000);//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
	    Properties pobj =  new Properties();
	    pobj.load(fis);
	    
	      String browser = pobj.getProperty("browser"); 
	      String url =pobj.getProperty("url"); 
		  String un = pobj.getProperty("Username"); 
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
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.id("inputPassword")).sendKeys(pass);
			//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.findElement(By.linkText("Contacts")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		
//		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("//span[text()='Create Order']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
	  FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Downloads\\TestData-Template.xlsx");
	    Workbook wb =WorkbookFactory.create(fis1);//method chaining
	    Sheet sh =    wb.getSheet("Campaign");
	    Row row = sh.getRow(1);
	    String  contactname=row.getCell(3).toString();
		String organization=row.getCell(4).toString();
		String mobile=row.getCell(5).toString();
		String title=row.getCell(6).toString();
		String email=row.getCell(3).toString();
		String Department=row.getCell(2).toString();
		 wb.close();
		
		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(contactname);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='department']")).sendKeys(Department);
		
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		driver.findElement(By.xpath("(//div/child::button)[last()]")).click();
		String mainwindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			if(!(window.equals(mainwindow))) {
				driver.switchTo().window(window);
				break;
			}
			
		}
Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele1=driver.findElement(By.xpath("//label[contains(normalize-space(),'Office Phone')]/following-sibling::input"));
		act.scrollByAmount(300,300).perform();
		act.sendKeys(ele1,mobile).perform();
		
		driver.findElement(By.xpath("//button[text()='Create Contact']"));
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		WebElement mess=driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		wait.until(ExpectedConditions.elementToBeClickable(mess));
		System.out.println(mess.getText());
	  
	
		 
	}

}
