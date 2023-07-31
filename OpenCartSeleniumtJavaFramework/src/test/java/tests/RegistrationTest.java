package tests;

import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import resources.RandomGenerator;
import testcomponents.BaseTest;

public class RegistrationTest extends BaseTest  {
	
	RandomGenerator rg=new RandomGenerator();
	String firstname=rg.randomFirstName();
	String lastname=rg.randomLastName();
	String telephone=rg.randomNumber();
	public static String email=RandomGenerator.randomEmail();
	public static String password=RandomGenerator.randomPassword();

	@Test
	public void Registration()
	{
		HomePage homepage=new HomePage(driver);
		RegistrationPage registration=new RegistrationPage(driver);
		LoginPage loginpage=new LoginPage(driver);
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
		getScreenshot("RegistrationTest", driver);
		SuccessMessage("Your Account Has Been Created!");
		homepage.clickContinue();
		loginpage.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		homepage.clickContinue();
	}
}
