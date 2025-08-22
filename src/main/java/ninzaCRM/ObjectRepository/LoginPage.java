package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1:class anme should be same as the webpage name
	
	//Rule 2:Identify the web element using @findBy,@FindAll, @FindBy annotations
	//@Findall--helps to execute without calling the annotation ,and 
	
	@FindBy(name="username") private WebElement usernameTF;//Declaring the elements
	
	
	@FindBy(name="password")private WebElement passwordTF;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement submitBtn;
	
	
	public LoginPage(WebDriver driver)//while running the constructor it initialize the elements
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getUsernameTF() {
		return usernameTF;
	}


	public WebElement getPasswordTF() {
		return passwordTF;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Bussiness Library
	
	/**
	 * Create bussiness library for loginapp and utilize it in main page
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String username, String password)
	{
		usernameTF.sendKeys("rmgyantra");
		passwordTF.sendKeys("rmgy@9999");
		submitBtn.click();
		
	}
	
	
	
	
	

}
