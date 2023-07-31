package tests;
import org.testng.annotations.Test;

import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ProductCatalogue;
import pageobjects.WishListPage;
import testcomponents.BaseTest;


public class WishListTest extends BaseTest 	{

	@Test
	public void wishlist()
	{

	HomePage hp=new HomePage(driver);
	LoginPage login=new LoginPage(driver);
	ProductCatalogue pc=new ProductCatalogue(driver); 
	WishListPage wp=new WishListPage(driver);
	CheckoutPage cp=new CheckoutPage(driver);
	MyAccountPage map=new MyAccountPage(driver);
	hp.clickLogin();
	login.enterLoginDetails(RegistrationTest.email, RegistrationTest.password);
	hp.clickHomePage();
	hp.changetoEuroCurrency();
	wp.additemstoWishList();
	hp.clickWishList();
	reload();
	wp.removeCanonEOS5DWishList();
	reload();
	SuccessMessage("Success: You have modified your wish list!");
	wp.addiPhoneMacBookCart();
	wp.addAppleCinema();
	fileupload();
	wp.continueAppleCinemaCart();
	pc.clickcarttotalandviewcart();
	reload();
	hp.clickCheckout();
	cp.BillingDetails();
	cp.checkoutandplaceorder();
	getScreenshot("WishListTest", driver);
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
