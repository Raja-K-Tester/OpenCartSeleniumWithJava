package tests;

import org.testng.annotations.Test;

import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ProductCatalogue;
import testcomponents.BaseTest;

public class SearchIphoneAddtoCartTest extends BaseTest  {

	@Test
	public void SearchandAddtoCart()
	{

		HomePage hp=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		ProductCatalogue pc=new ProductCatalogue(driver);
		CheckoutPage cp=new CheckoutPage(driver);
		MyAccountPage map=new MyAccountPage(driver);
		hp.clickLogin();
		login.enterLoginDetails(RegistrationTest.email, RegistrationTest.password);
		hp.searchProduct("iphone");
		pc.addIphone();
		hp.clickCheckout();
		cp.BillingDetails();
		cp.checkoutandplaceorder();
		getScreenshot("SearchIphoneAddtoCart", driver);
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
