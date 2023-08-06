package tests;

import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProductReturnsPage;
import testcomponents.BaseTest;

public class ReturnProductTest extends BaseTest		{

	@Test
	public void returnProduct()
	{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		ProductReturnsPage pp=new ProductReturnsPage(driver);
		hp.clickLogin();
		lp.enterLoginDetails("abc@test1.com", "abcd1");
		hp.clickHomePage();
		hp.clickReturns();
		pp.ReturnProduct();
		getScreenshot("ReturnProductTest", driver);
		SuccessMessage("Thank you for submitting your return request.");
		hp.clickReturns();
		lp.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		hp.clickContinue();

	}

}
