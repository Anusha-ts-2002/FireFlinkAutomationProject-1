package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
@FindBy(xpath="//option[.='Search by Contact Id']")private WebElement searchCID;

@FindBy(xpath = "//option[.='Search by Contact Name']")private WebElement searchContact;

@FindBy(name  = "contactName")private WebElement Contactname;

@FindBy(name  = "organizationName")private WebElement Orgname;

@FindBy(name  = "mobile")private WebElement mobilenumber;
@FindBy(name  = "title")private WebElement titlename;

//add campaign page


@FindBy(xpath = "//input[@type='text']/following-sibling::button[@type='button']")private WebElement campaignbtn;

@FindBy(xpath = "//option[.='Campaign ID']")private WebElement ChildpageCI;

@FindBy(xpath = "//option[.='Campaign Name']")private WebElement ChildpageCName;


	@FindBy(xpath = "//button[@type='submit']")private WebElement submitcontact;
	
	
	public ContactsPage(WebDriver driver)//while running the constructor it initialize the elements
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getSearchCID() {
		return searchCID;
	}


	public WebElement getSearchContact() {
		return searchContact;
	}


	public WebElement getContactname() {
		return Contactname;
	}


	public WebElement getOrgname() {
		return Orgname;
	}


	public WebElement getMobilenumber() {
		return mobilenumber;
	}


	public WebElement getTitlename() {
		return titlename;
	}


	public WebElement getCampaignbtn() {
		return campaignbtn;
	}


	public WebElement getSubmitcontact() {
		return submitcontact;
	}


	public WebElement getChildpageCI() {
		return ChildpageCI;
	}


	public WebElement getChildpageCName() {
		return ChildpageCName;
	}
	
	
	
   
}
