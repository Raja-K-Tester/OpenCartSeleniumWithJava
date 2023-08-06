package tests;

import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import testcomponents.BaseTest;
public  class LoginTest extends BaseTest  {



	@Test
	public void LoginPageTest()
	{
		HomePage hp=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		hp.clickLogin();
		login.clickForgotPassword(RegistrationTest.email);
		SuccessMessage("An email with a confirmation link has been sent your email address.");
		login.enterLoginDetails(RegistrationTest.email,RegistrationTest.password);
		login.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		hp.clickContinue();

	}


}
