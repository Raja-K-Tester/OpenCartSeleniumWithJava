package tests;

import org.testng.annotations.Test;
import pageobjects.CheckoutPage;
import pageobjects.CompareProductsPage;
import pageobjects.EndToEndPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ProductCatalogue;
import pageobjects.ProductReturnsPage;
import pageobjects.ViewUpdateDeleteProductsPage;
import pageobjects.WishListPage;
import testcomponents.BaseTest;
import testcomponents.Retry;

public class EndToEndTest extends BaseTest {

	@Test(priority=1)
	public void compare() 
	{
		EndToEndPage ep = new EndToEndPage(driver);
		LoginPage login = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CompareProductsPage cpp = new CompareProductsPage(driver);
		ViewUpdateDeleteProductsPage vp = new ViewUpdateDeleteProductsPage(driver);
		CheckoutPage cp = new CheckoutPage(driver);
		MyAccountPage map = new MyAccountPage(driver);
		
		// Account Registration
		ep.registration();
		getScreenshot("RegistrationTest", driver);
		SuccessMessage("Your Account Has Been Created!");
		homepage.clickContinue();
		homepage.clickHomePage();
		
		// Compare Cameras Test
		homepage.clickCameras();
		cpp.addCamerastoCompare();
		reload();
		vp.clicktNikonD300();
		homepage.clickCheckout();
		cp.BillingDetails();
		cp.checkoutandplaceorder();
		SuccessMessage("Your order has been placed!");
		homepage.clickContinue();
		map.MyAccount();
		map.ViewOrderHistory();
		SuccessMessage("Order History");

		// Logout from the website
		login.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		homepage.clickContinue();
		reload();
	}

	@Test(priority = 4,retryAnalyzer = Retry.class)
	public void wishlist() 
	{
		EndToEndPage ep = new EndToEndPage(driver);
		LoginPage login = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		WishListPage wp = new WishListPage(driver);
		ProductCatalogue pc = new ProductCatalogue(driver);
		CheckoutPage cp = new CheckoutPage(driver);
		MyAccountPage map = new MyAccountPage(driver);
		
		// Account Registration
		ep.registration();
		getScreenshot("RegistrationTest", driver);
		SuccessMessage("Your Account Has Been Created!");
		homepage.clickContinue();
		homepage.clickHomePage();
		
		// WishList Test
		homepage.changetoEuroCurrency();
		wp.additemstoWishList();
		homepage.clickWishList();
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
		homepage.clickCheckout();
		cp.BillingDetails();
		cp.checkoutandplaceorder();
		getScreenshot("WishListTest", driver);
		SuccessMessage("Your order has been placed!");
		homepage.clickContinue();
		map.MyAccount();
		map.ViewOrderHistory();
		SuccessMessage("Order History");
		login.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		homepage.clickContinue();
		reload();
	}

	@Test(priority = 3)
	public void returnproduct() 
	{
		
		LoginPage login = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ProductReturnsPage pp = new ProductReturnsPage(driver);
		
		// Return Product Test
		homepage.clickLogin();
		login.enterLoginDetails("abc@test1.com", "abcd1");
		homepage.clickHomePage();
		homepage.clickReturns();
		pp.ReturnProduct();
		getScreenshot("ReturnProductTest", driver);
		SuccessMessage("Thank you for submitting your return request.");
		homepage.clickReturns();
		login.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		homepage.clickContinue();
		reload();
	}

	@Test(priority = 2)
	public void updatedeletetablet() 
	{
		HomePage homepage = new HomePage(driver);
		ViewUpdateDeleteProductsPage vp = new ViewUpdateDeleteProductsPage(driver);
		ProductCatalogue pc = new ProductCatalogue(driver);
		
		// Update,Remove Tablet Test
		homepage.clickTablets();
		pc.addSamsungGalaxyTab();
		pc.clickcarttotalandviewcart();
		vp.galaxytabupdateremove();
		reload();
		getScreenshot("TabletUpdateRemoveTest", driver);
		SuccessMessage("Your shopping cart is empty!");
		homepage.clickContinue();
	}
}
