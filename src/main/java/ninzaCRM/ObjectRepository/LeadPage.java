package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRMgenericUtilities.WebDriverUtility;

public class LeadPage extends WebDriverUtility {

	
	@FindBy(xpath = "//span[text()='Create Lead']")
	private WebElement createLead;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selectDropdown;
	
	
	@FindBy(xpath = "//option[text()='Search by Lead Id']")
	private WebElement searchByLeadId;
	
	@FindBy(xpath = "//option[text()='Search by Lead Name']")
	private WebElement searchByName;
	
	@FindBy(xpath = "//input[@placeholder='Search by Lead Id']")
	private WebElement searchTF;
	
	@FindBy(xpath = "//input[@placeholder='Search by Lead Name']")
	private WebElement searchTFByName;
	
	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLead()
	{
		return createLead;
	}

	public WebElement getSelectDropdown()
	{
		return selectDropdown;
	}

	public WebElement getSearchByLeadId()
	{
		return searchByLeadId;
	}

	public WebElement getSearchByName()
	{
		return searchByName;
	}

	public WebElement getSearchTF()
	{
		return searchTF;
	}

	public WebElement getSearchTFByName()
	{
		return searchTFByName;
	}
	
	//Business Library 
	/**
	 * this method is for selecting lead by handling drop down down
	 * @param text
	 * @param info
	 */
	
	public void searchLeadByDropDown(String text,String info) {
		handledropdown(text,selectDropdown);
		 searchTF.sendKeys(info);	
	}
  
	
	public void craeteLeadClick() {
		createLead.click();
		
	}
	
	
}
