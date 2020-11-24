package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CartCheckoutPage extends PageBase {

	public CartCheckoutPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}

	WebDriver driver1;
	
	//click on Tshirts
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]")
	WebElement Tshirts_link;
	
	//click on item
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]")
	WebElement NavigatetoCart_button;
	
	//switch to item frame
	String frameID = "fancybox-frame1605993985708";
	
	//click on List
	@FindBy(xpath="//*[@id=\"list\"]/a/i")
	WebElement ListIcon;
	
	
	//Add to Cart
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[1]")
	WebElement AddtoCart_button;
	
	//Proceed to checkout 1
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	WebElement ProceedtoCheckout_button1;
	
	//Proceed to checkout Summary
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
	WebElement ProceedtoCheckout_Summarybutton;
	
	//Proceed to checkout Address
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")
	WebElement ProceedtoCheckout_Addressbutton;
	
	
	//Terms of services
	@FindBy(id="cgv")
	WebElement terms_radiobutton;
	
	
	//Proceed to checkout shipping
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	WebElement ProceedtoCheckout_Shippingbutton;
	
	
	//Payment method
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement PaymentMethod;
	
	//Confirm order
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span")
	WebElement ConfirmOrder;
	
	//OrderData
	@FindBy(xpath="//*[@id=\"center_column\"]/div")
	WebElement OrderData;
	
	
	public void CartCheckOut()
	{
		
		Tshirts_link.click();
		waitMethod(3000);
		
		ListIcon.click();
		
		AddtoCart_button.click();
		waitMethod(3000);
		
		ProceedtoCheckout_button1.click();
        waitMethod(3000);

		ProceedtoCheckout_Summarybutton.click();
		waitMethod(3000);
		
		ProceedtoCheckout_Addressbutton.click();        
		waitMethod(3000);
		
		
		terms_radiobutton.click();
		ProceedtoCheckout_Shippingbutton.click();
		waitMethod(3000);
		
		
		PaymentMethod.click();
		waitMethod(3000);
		
        ConfirmOrder.click();
        waitMethod(3000);
       
        
	}
	
	
}
	
