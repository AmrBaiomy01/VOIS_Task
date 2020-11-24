package pages;

import javax.management.relation.RelationServiceNotRegisteredException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}
	
	RegistrationPage regobj;
	
	WebDriver driver1;
	
	//SignOut_button
	@FindBy(xpath="//div[@class='header_user_info']/a[@class='logout']")
	WebElement SignOut_button;
	
	//SignIn
	@FindBy(xpath="//div[@class='header_user_info']/a[@class='login']")
	WebElement SignIn;
		
	//Email Address
	@FindBy(id = "email")
	WebElement EmailAddress_txt;
	
	//Password
	@FindBy(id="passwd")
	WebElement Passwd_txt;
	
	//Sign in
	@FindBy(id="SubmitLogin")
	WebElement Signin_button;
		
	public void Signin(String email)
	
	{
		//First Sign out then Enter Valid data and Sign in
		SignOut_button.click();
		waitMethod(6000);
		System.out.println(EmailAddress_txt.getText());
		EmailAddress_txt.sendKeys(email);
		Passwd_txt.sendKeys("12345");
		Signin_button.click();
						
	}
	
}
	
