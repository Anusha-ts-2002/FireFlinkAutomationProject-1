package ninzaCRMPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.DashboardPage;
import ninzaCRMgenericUtilities.BaseClass;


@Listeners(ninzaCRMgenericUtilities.ListenersImplementation.class)
public class CampaignTest  extends BaseClass {

	@Test(groups="SmokeSuite")
	public void tc_001_createCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
//		CampaignPage cp = new CampaignPage(driver);
//		CreateCampaignPage  ccp = new CreateCampaignPage(driver);
		//read data from excel
		
//		String campaignname= fu.readdatafromexcelsheet("Sheet1", 10, 1);
//		String targetsize = fu.readdatafromexcelsheet("Sheet1", 10, 2);
		
		//click on campaign link
		DashboardPage dp = new DashboardPage(driver);
		dp.clickOnCampaignsLnk();
		Reporter.log("clicked on campaign link"+ true);//report to get the action done or not in report and console
//
//		//click on create campaign button
		CampaignPage cp = new CampaignPage(driver);
		cp.createCampaignClick();	
		
		CreateCampaignPage  ccp = new CreateCampaignPage(driver);
		ccp.CreateCampaignPage("jammu", "20");
		Reporter.log("clicked on create campaign "+true);
//		Thread.sleep(2000);
		
//		
//		// create campaign with data
	
	
		
//		cp.createCampaignClick();
//		ccp.CreateCampaignPage("jammu", "20");
		
		
		System.out.println("New Campaign is created");	
	}
	
	
	
	@Test()
	public void sample2()
	{
		//Assert.fail();//it fails the sample2 method by knowingly
		System.out.println("the sample2 in regionalRegrssion");
	}
	
	//@Test(groups="Regressionsuite  RegionalRegressionSuite")
	@Test(groups="Regressionsuite")
	public void sample()
	{
		System.out.println("The regression testing");
	}
//	
	@Test(groups="RegionalRegressionSuite")
	public void sample1()
	{
		System.out.println("the sample2 in regionalRegrssion");
	}
	
}
