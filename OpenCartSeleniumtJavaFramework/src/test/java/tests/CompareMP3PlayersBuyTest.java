package tests;

import org.testng.annotations.Test;

import pageobjects.CheckoutPage;
import pageobjects.CompareProductsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ViewUpdateDeleteProductsPage;
import testcomponents.BaseTest;

public class CompareMP3PlayersBuyTest extends BaseTest	{
	
	@Test
	public void compareMp3PlayersPurchase()
	{
		HomePage hp=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		CompareProductsPage cpp=new CompareProductsPage(driver);
		ViewUpdateDeleteProductsPage vp=new ViewUpdateDeleteProductsPage(driver);
		CheckoutPage cp=new CheckoutPage(driver);
		MyAccountPage map=new MyAccountPage(driver);
		hp.clickLogin();
		login.enterLoginDetails(RegistrationTest.email, RegistrationTest.password);
		hp.clickHomePage();
		hp.clickMP3PlayersandShowAll();
		cpp.addMp3PlayerstoCompare();
		reload();
		vp.WindowHandlesForMP3Players();
		hp.clickCheckout();
		//cp.BillingDetails();
		cp.checkoutandplaceorder();
		SuccessMessage("Your order has been placed!");
		hp.clickContinue();
		map.MyAccount();
		map.ViewOrderHistory();
		SuccessMessage("Order History");
		hp.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		hp.clickContinue();
	}

}
