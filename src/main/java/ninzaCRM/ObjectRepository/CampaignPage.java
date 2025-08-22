package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRMgenericUtilities.WebDriverUtility;

public class CampaignPage extends WebDriverUtility {
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaign;
	
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement searchDropdown;
	
	
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchTF;
	
	@FindBy(xpath = "//div[text()='Campaign tyfgcv Successfully Added']")
	private WebElement succesfulMsg;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaign()
	{
		return createCampaign;
	}

	public WebElement getSearchDropdown()
	{
		
		return searchDropdown;
	}

	public WebElement getSuccesfulMsg()
	{
		return succesfulMsg;
	}
	
	//business library for selecting drop down and search the campaign
	
	public void SearchCampaignDropdown(String value, String info)
	{
		
		handledropdown(value, searchDropdown);
		SearchTF.sendKeys(info);
	}
	
	public void createCampaignClick()
	{
		createCampaign.click();
	}

}
