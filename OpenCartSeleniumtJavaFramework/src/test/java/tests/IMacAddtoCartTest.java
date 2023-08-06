package tests;
import org.testng.annotations.Test;

import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ProductCatalogue;
import testcomponents.BaseTest;

public class IMacAddtoCartTest extends BaseTest  {
	@Test
	public void iMacAddtoCart()
	{

	HomePage hp=new HomePage(driver);
	LoginPage login=new LoginPage(driver);
	ProductCatalogue pc=new ProductCatalogue(driver);
	CheckoutPage cp=new CheckoutPage(driver);
	MyAccountPage map=new MyAccountPage(driver);
	hp.clickLogin();
	login.enterLoginDetails(RegistrationTest.email, RegistrationTest.password);
	hp.clickHomePage();
	hp.changetoPoundSterling();
	hp.clickDesktopandMac();
	pc.addiMac();
	hp.clickCheckout();
	cp.BillingDetails();
	cp.checkoutandplaceorder();
	getScreenshot("IMacTest", driver);
	SuccessMessage("Your order has been placed!");
	hp.clickContinue();
	map.MyAccount();
	map.ViewOrderHistory();
	SuccessMessage("Order History");
	login.clickLogout();
	reload();
	SuccessMessage("Account Logout");
	hp.clickContinue();

	}

}
