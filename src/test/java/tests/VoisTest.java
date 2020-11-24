package tests;

import org.testng.annotations.Test;

import pages.CartCheckoutPage;
import pages.LoginPage;
import pages.RegistrationPage;

public class VoisTest extends TestBase{
	
	RegistrationPage RegObj;
	LoginPage LoginObj;
	CartCheckoutPage CartObj;
	String email;
	
	@Test (priority = 0)
	public void Registration()
	
	{
		RegObj = new RegistrationPage(driver);
		email = RegObj.Registration();
	}
	
	@Test (priority = 1)
	public void Login() {
		
		LoginObj = new LoginPage(driver);
		LoginObj.Signin(email);
		
	}
	
	@Test (priority = 2)
	public void CartCheckOut() {
		
		CartObj = new CartCheckoutPage(driver);
		CartObj.CartCheckOut();
	}

}
