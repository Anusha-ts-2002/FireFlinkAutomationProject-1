package ninzaCRMgenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninzaCRM.ObjectRepository.DashboardPage;
import ninzaCRM.ObjectRepository.LoginPage;



public class BaseClass {
	
	public FileUtility fu = new FileUtility();
	public WebDriverUtility web = new WebDriverUtility();
	public JavaUtility ju = new JavaUtility();
	
	public WebDriver driver;
	//for Listeners
	public static WebDriver sdriver;
	
	
	@BeforeSuite(alwaysRun= true)
	public void bsConfig()
	{
		System.out.println("db connection successfull");
	}
	
	
	//@Parameters("browser")//for CrossbrowserExecution use STring browser parameter has to be used
	//hence read the data with property file only
	//@BeforeTest(alwaysRun= true)//Distributed
	
	@BeforeClass(alwaysRun= true)
	//public void bcConfig(String Browser) throws IOException// only for crossbrowser execution where 2 browsers execute together
	
	public void bcConfig() throws IOException
	{
       	String Browser = fu.readdatafromPropertyfile("browser");
	    String url = fu.readdatafromPropertyfile("url");
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();
			WebDriverManager.edgedriver().setup();//mandatory for changing the browser
		}else if(Browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		web.maximizeWindow(driver);
		driver.get(url);
		
		//for listeners
		sdriver= driver;
		System.out.println("driver launched succesfully");
		
	}
	
	@BeforeMethod(alwaysRun= true)	
	public void bmConfig() throws IOException, InterruptedException {
	String un = fu.readdatafromPropertyfile("username");
	String pass = fu.readdatafromPropertyfile("password");
	
	LoginPage lp = new LoginPage(driver);
    lp.LoginToApp(un, pass);
    
    
    System.out.println("login to app");
	
	}
	
	
	@AfterMethod(alwaysRun= true)
	public void amConfig() throws InterruptedException
	{
	DashboardPage dp = new DashboardPage(driver);
	dp.getuserIcon().click();
	
	dp.logoutOfApp(driver);
	System.out.println("logout from driver");
	}
	
	//@AfterTest(alwaysRun=true)
	@AfterClass(alwaysRun= true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("driver browser closed");
	}
	
	
	@AfterSuite(alwaysRun= true)
	public void asConfig()
	{
		System.out.println("db connection closed");
	}

}
