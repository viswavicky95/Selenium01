package wrappers;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mongodb.MapReduceCommand.OutputType;



public class GenericWrappers implements Wrappers {
	RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try{
		if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 driver= new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		driver= new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("internet explorer")){
			System.setProperty("webdriver.ie.driver","./driver/IEdriver.exe");
		driver=new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(browser+"Browser Launched Successfully and Loaded");
	} catch (WebDriverException e){
		 System.err.println("Browser closed due to unknown error");
	}	finally{
		takeSnap();
	}
		
		
		
	}

	public void enterById(String idValue, String data) {
		
		// TODO Auto-generated method stub
		try{
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("identified the text box with locator"+ idValue+"and Entered Data"+data);
		} catch (NoSuchElementException e){
			System.err.println("No such element in the window");
			
		} catch (ElementNotVisibleException e){
			System.err.println("Element is not visible in the window");
			
		} catch (ElementNotSelectableException e){
			System.err.println("Element is not selectable in the window");
		} catch(StaleElementReferenceException e){
			System.err.println("Element disappered when the action is performed on the window");
			} catch (WebDriverException e){
			System.err.println("Element is not identified due to unknown error");
		}
					
		
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
	try{
		driver.findElementByName(nameValue).sendKeys(data);
		System.out.println("identified the elements successfully");
	} catch(NoSuchElementException e){
	System.err.println("No such element in the window");
	} catch (ElementNotVisibleException e){
		System.err.println("Element is not visible in the window");
	} catch(ElementNotSelectableException e){
		System.err.println("Element is not selectable in the window");
	} catch(StaleElementReferenceException e){
		System.err.println("Element disappeared when the action is performed on the window");
	} catch(WebDriverException e){
		System.err.println("Element is not identified due to unknown error");
	}
	}
	
	
	
		
	
	

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
	try{
		String title=driver.findElementByXPath(xpathValue).getText();
		System.out.println("element is identified and got the text successfully");
		
	} catch (NoSuchElementException e)
	{
		System.err.println("No such element in the window");

	} catch(WebDriverException e) {
		System.err.println("Element is not identified due to unknown error");
	}
	}
	
	
	
	
	

	public void verifyTitle(String title)  {
		// TODO Auto-generated method stub
		try{
		String tit=driver.getTitle();
		if (tit.equalsIgnoreCase(title)) {
	    System.out.println("The title is verified successfully");
		}
		else
			System.err.println("Title not matched");
		
		} catch(NoSuchElementException e){
			System.err.println("No such element in the window");
		
		} catch(WebDriverException e) {
			System.err.println("Element is not identified due to unknown error");
		}
		
	}
		
		
			
			
		
	

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		 try{
			 String tit1=driver.findElementById(id).getText();
		 
		 if(tit1.equals(text)){
			 System.out.println("Title is matched successfully");
			 
		 } else
			 System.err.println("Title is not matched");
	} catch (NoSuchWindowException e){
		System.err.println("window is not available in the text");
		 
	} catch (NoSuchElementException e) {
		System.err.println("No such element in the window");
		
	} catch (WebDriverException e) {
		System.err.println("Element is not identified due to unknown error");
	}
	}




	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
	try{
		String tit1=driver.findElementByXPath(xpath).getText();
		
		if(tit1.contains(text)){
			System.out.println("Title is matched successfully");
		} else
			System.err.println("Title is not matched");
	} catch
		}
	}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
		File pic=driver.getScreenshotAs(OutputType.FILE);
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		
	}

	
	

}
