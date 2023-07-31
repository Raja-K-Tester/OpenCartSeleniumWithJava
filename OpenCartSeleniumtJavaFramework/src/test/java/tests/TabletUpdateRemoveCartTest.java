package tests;

import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProductCatalogue;
import pageobjects.ViewUpdateDeleteProductsPage;
import testcomponents.BaseTest;

public class TabletUpdateRemoveCartTest extends BaseTest  {

	@Test
	public void UpdateandDeleteTablet()
	{
		HomePage hp=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		ProductCatalogue pc=new ProductCatalogue(driver);
		ViewUpdateDeleteProductsPage vp=new ViewUpdateDeleteProductsPage(driver);
		hp.clickLogin();
		login.enterLoginDetails(RegistrationTest.email, RegistrationTest.password);
		hp.clickHomePage();
		hp.clickTablets();
		pc.addSamsungGalaxyTab();
		pc.clickcarttotalandviewcart();
		vp.galaxytabupdateremove();
		reload();
		getScreenshot("TabletUpdateRemoveTest", driver);
		SuccessMessage("Your shopping cart is empty!");
		hp.clickContinue();
		hp.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		hp.clickContinue();
	}
}
