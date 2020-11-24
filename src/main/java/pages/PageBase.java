package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class PageBase {

	//define protect webdriverclass object to be visible through this class or child classes only
	//public static WebDriver driver;
	//Create Constructor to centralize the webdriver

	protected static WebDriver driver1;
	public Select select;
	public Actions Action;
	

	public PageBase(WebDriver driver)

	{

		//this.driver = driver;
		PageFactory.initElements(driver, this);
		driver1=driver;

	}

	//create generic method to click function
	
	protected void clickButton(WebElement button) {
		
		button.click();
	}
	
	protected void switchFrame (String frameID)
	{
		//WebDriverWait wait = new WebDriverWait(driver1,3000);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
		driver1.switchTo().frame(frameID);
	}

	protected void waitMethod(int timeInSeconds)
	{
		driver1.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);

	}


	public void TakeScreenShots(WebDriver driver , String ScreenShortname) throws IOException
	{

		Path dest = Paths.get("./ScreenShots" , ScreenShortname +".png");
		Files.createDirectories(dest.getParent());		
		FileOutputStream out = new FileOutputStream(dest.toString());
		out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		out.close();

	}


	protected String  StoreData (WebElement textbox)
	{
		return textbox.getAttribute("value");
	}
	
}
