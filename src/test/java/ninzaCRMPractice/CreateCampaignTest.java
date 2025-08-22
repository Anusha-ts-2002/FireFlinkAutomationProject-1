package ninzaCRMPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.LoginPage;
import ninzaCRMgenericUtilities.FileUtility;
import ninzaCRMgenericUtilities.WebDriverUtility;


public class CreateCampaignTest extends WebDriverUtility {
	
	@Test
	public void createCampaignTest() throws InterruptedException, IOException {
			
	 FileUtility fu = new FileUtility();
	 WebDriverUtility web = new WebDriverUtility();

	  String browser =fu.readdatafromPropertyfile("browser");
	
     
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
	  
	  
	 
	  driver.get("http://49.249.28.218:8098");
	  
	  web.maximizeWindow(driver);
      CreateCampaignPage cc = new CreateCampaignPage(driver);
		 
		 
	  LoginPage lp = new LoginPage(driver);
	  lp.LoginToApp("rmgyantra", "rmgy@9999");
	  	  
	  cc.getCreateCampaignBtn().click();
	 
	 cc.CreateCampaignPage("gopalam", "30");
	  
	
}
}
