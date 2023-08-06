package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;
import resources.RandomGenerator;

public class EndToEndPage extends AbstractComponent  {
	
	WebDriver driver;
	RandomGenerator rg=new RandomGenerator();
	String firstname=rg.randomFirstName();
	String lastname=rg.randomLastName();
	String telephone=rg.randomNumber();
	public String email=RandomGenerator.randomEmail();
	public String password=RandomGenerator.randomPassword();
	

	public EndToEndPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void registration()
	{
		
		
		RegistrationPage registration=new RegistrationPage(driver);
		HomePage homepage=new HomePage(driver);
		//Register an Account
		homepage.clickRegister();
		registration.setFirstName(firstname);
		registration.setLastName(lastname);
		registration.setEMail(email);
		registration.setTelephoneNumber(telephone);
		registration.setPassword(password);
		registration.setConfirmPassword(password);
		registration.clickNoNewsLetterSubscription();
		registration.clickPrivacyPolicy();
		registration.clickAgreeCheckBox();
		registration.clickSubmitButton();
		sleep();
	
	}
}
