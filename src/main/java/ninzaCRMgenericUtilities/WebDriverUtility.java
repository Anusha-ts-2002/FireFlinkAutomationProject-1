package ninzaCRMgenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains generic methods related to webdriver[Selenium] operations
 * 
 * @author Anusha T S
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * THis method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();;
	}
	
	/**
	 * This method willfullscreen the window
	 * @param driver
	 */
	public void fullscreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	public void implicitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
	}
	
     public void explicitlywaitvisibleelement(WebDriver driver, WebElement element)
     {
    	 WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.visibilityOf(element));
     }
     
     public void ExplicitewaitforElementtobeClickable(WebDriver driver, WebElement element)
     {
    	 WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(element));
     }
     
     //handle dropdowns/list box
     
     /**
      * This method will select the element based on index
      * @param text
      * @param searchDropdown
      */
     public void handledropdown(WebElement ele, int value)
     {
    	 Select select = new Select(ele);
    	 select.selectByIndex(value);;
     }
     
     /**
      * This method will select the element based on value
      * @param select
      * @param indexno
      */
     public void handledropdown(WebElement ele, String value)
     {
    	 Select select = new Select(ele);
    	 select.selectByValue(value);
     }
     
     /**
      * This method will select the element based on visibletext
      * @param select
      * @param indexno
      */
     public void handledropdown( String value2,WebElement ele)
     {
    	 Select select = new Select(ele);
    	 select.selectByVisibleText(value2);
     }
     
     //Actions class = mouseOvering, drag and drop , clink and hold,release
     //like movebyoffest, double click , context click
     public void actionbymouseOvering(WebDriver driver , WebElement element)
     {
    	 Actions act = new Actions(driver);
    	 act.moveToElement(element);
     }
     
     public void actionbymouseovering(WebDriver driver, WebElement ele,int x,int y)
     {
    	 Actions act = new Actions(driver);
    	 act.moveToElement(ele, 20, 30);
     }
     
     public void actionbymouseovering(WebDriver driver,int x, int y)
     {
    	 Actions act = new Actions(driver);
    	 act.moveByOffset(x, y);
     }
     
     public void scrolloperations(WebDriver driver, WebElement ele)
     {
    	 Actions act = new Actions(driver);
    	 act.scrollToElement(ele);
     }
     
     public void draganddropactions(WebDriver driver, WebElement src, WebElement dest)
     {
    	 Actions act = new Actions(driver);
    		act.dragAndDrop(src, dest);	 
     }
     
     public void clickandholdactions(WebDriver driver,WebElement ele) throws InterruptedException
     {
    	 Actions act = new Actions(driver);
    	 act.clickAndHold(ele);
    	 Thread.sleep(1000);
    	 act.release(ele);
     }
     
     
     //Handling Frames
     
    public void handleIframe(WebDriver driver,int value)
    {
    	driver.switchTo().frame(value);
    }
    
    public void handleIframe(WebDriver driver, String name)
    {
    	driver.switchTo().frame(name);
    }
    
    public void handleIframe(WebDriver driver,WebElement webele)
    {
    	driver.switchTo().frame(webele);
    }
     
    public void switchtoparentframe(WebDriver driver)
    {
    	driver.switchTo().parentFrame();
    }
    
    public void switchtomainframe(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }
    
    
    //handling Alerts
    
    public void alertaccepted(WebDriver driver)
    {
    	Alert a = driver.switchTo().alert();
    	a.accept();
    }
    
    public void alertDismissed(WebDriver driver)
    {
    	 driver.switchTo().alert().dismiss();
    
    }
    
    public void sendingdataintoalert(WebDriver driver, String value)
    {
    	Alert a= driver.switchTo().alert();
    	a.sendKeys(value);
    }
    
    public void gettextbythealert(WebDriver driver)
    {
    	driver.switchTo().alert().getText();
    }
    
    //Handling Windows-2
    
    public String gettingcurrentwindowID(WebDriver driver)
    {
    	return driver.getWindowHandle();
    }
    
    public void gettingeverywindowIds(WebDriver driver,String getvalue)
    {
    	String mainwnID = driver.getWindowHandle();
    	Set<String> childID = driver.getWindowHandles();
    	for(String everyid : childID)
    	{
    		driver.switchTo().window(mainwnID);
    		String title = driver.getTitle();
    		
    		    if(title.contains(getvalue))
    		    {
    		    	driver.switchTo().window(title);
    		    	break;
    		    }
    	}
    }
    
    /**
     * This method will capture the screenshot and return the path to caller 
     * @param driver
     * @param screenshotname
     * @return
     * @throws IOException
     */
    public String captureScreenShot(WebDriver driver, String screenshotname) throws IOException
    {
    	TakesScreenshot ts= (TakesScreenshot) driver;
    	File src= ts.getScreenshotAs(OutputType.FILE);
    	File dst= new File(".\\Screenshots\\"+screenshotname+".png");
    	FileHandler.copy(src, dst);
    	return dst.getAbsolutePath();// for extent report
    }
     
}
