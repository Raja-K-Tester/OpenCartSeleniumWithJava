package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class LoginPage extends AbstractComponent{

	WebDriver driver;
	HomePage hp=new HomePage(driver);

	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(linkText="Forgotten Password")
	WebElement ForgotPassword;

	@FindBy(id="input-email")
	WebElement Email;

	@FindBy(id="input-password")
	WebElement Password;

	@FindBy(css="input[type='submit']")
	WebElement SubmitButton;


	@FindBy(linkText="Logout")
	WebElement Logout;



	public void clickForgotPassword(String email)
	{

		click(ForgotPassword);
		sendText(Email, email);
		click(SubmitButton);
	}

	public ProductCatalogue enterLoginDetails(String email,String password)
	{
		sendText(Email, email);
		sendText(Password, password);
		click(SubmitButton);
		ProductCatalogue productcatalogue=new ProductCatalogue(driver);
		return productcatalogue;

	}

	public void clickLogout()
	{
		click(Logout);

	}


}
