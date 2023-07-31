package tests;

import org.testng.annotations.Test;

import pageobjects.CheckoutPage;
import pageobjects.CompareProductsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ViewUpdateDeleteProductsPage;
import testcomponents.BaseTest;

public class CompareNoteMacBooksBuyTest extends BaseTest	{
	
	@Test
	public void compareNoteMacBooksPurchase()
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
		hp.clickLapNoteBookandShowAll();
		cpp.addNoteBookMacBooktoCompare();
		reload();
		vp.WindowHandlesForMacNoteBook();
		hp.clickCheckout();
		reload();
		//cp.BillingDetails();
		cp.checkoutandplaceorder();
		getScreenshot("CompareNoteBooksBuyTest", driver);
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
