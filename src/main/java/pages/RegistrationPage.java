package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}

	WebDriver driver1;


	//Sign_in_button
	@FindBy(partialLinkText="Sign")
	WebElement Sign_in_button;

	//Create Email
	@FindBy(id="email_create")
	WebElement EmailAddress_txt;

	//Create_account_button
	@FindBy(id="SubmitCreate")
	WebElement Create_account_button;

	//personal info

	//Title
	@FindBy(id="id_gender1")
	WebElement Title_radiobutton;


	//First_name
	@FindBy(id = "customer_firstname")
	WebElement First_name_txt;

	//Last_name
	@FindBy(id="customer_lastname")
	WebElement Last_name_txt;

	//Password
	@FindBy(id="passwd")
	WebElement Password;

	//DateofBirth
	@FindBy(id="days")
	WebElement Day_list;

	@FindBy(id="months")
	WebElement Months_list;

	@FindBy(id="years")
	WebElement Years_list;


	//Address info

	//Address
	@FindBy(id="address1")
	WebElement Address_txt;

	//City
	@FindBy(id="city")
	WebElement City_txt;


	//country
	@FindBy(id="id_country")
	WebElement Country_list;

	//State
	@FindBy(id = "id_state")
	WebElement State_list;

	//Postcode
	@FindBy(id="postcode")
	WebElement postcode_txt;

	//Mobile_phone
	@FindBy(id="phone_mobile")
	WebElement Mobile_phone;

	//Register
	@FindBy(id="submitAccount")
	WebElement Register_button;


	//RegisteredEmail
	@FindBy(id="email")
	WebElement Email;


	String timestamp = new SimpleDateFormat("yyyyhhssmm").format(Calendar.getInstance().getTime());
	
	public String RegisteredEmail;

	public String Registration()
	{

		//Navigate to create account process by click on sign in
		Sign_in_button.click();
		waitMethod(3000);

		//Email address
		RegisteredEmail = "AAA"+ timestamp + "@gmail.com";
		EmailAddress_txt.sendKeys(RegisteredEmail);
		Create_account_button.click();
		waitMethod(6000);

		//personal info
		Title_radiobutton.click();
		First_name_txt.sendKeys("AA");
		Last_name_txt.sendKeys("BB");

		
		Password.sendKeys("12345");


		//Date of birth
		Select day = new Select(Day_list);
		day.selectByValue("1");


		Select Month = new Select(Months_list);
		Month.selectByValue("12");

		Select Year = new Select(Years_list);
		Year.selectByValue("1991");

		//Address

		Address_txt.sendKeys("Amesh st");

		//City
		City_txt.sendKeys("Cairo");

		//state select
		Select state = new Select(State_list);
		state.selectByValue("6");		

		postcode_txt.sendKeys("12345");

		Mobile_phone.sendKeys("+1 510");

		Register_button.click();

		return RegisteredEmail;
	}



}

