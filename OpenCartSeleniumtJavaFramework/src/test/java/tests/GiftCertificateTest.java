package tests;

import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProductCatalogue;
import pageobjects.ViewUpdateDeleteProductsPage;
import testcomponents.BaseTest;

public class GiftCertificateTest extends BaseTest	{

	@Test
	public void GiftCertificatePurchase()
	{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		ProductCatalogue pp=new ProductCatalogue(driver);
		ViewUpdateDeleteProductsPage vp=new ViewUpdateDeleteProductsPage(driver);
		hp.clickLogin();
		lp.enterLoginDetails("abc@test1.com", "abcd1");
		hp.clickHomePage();
		hp.clickGiftCertificate();
		pp.BuyGiftCertificate();
		getElementScreenshot("GiftCertificateTest", driver);
		hp.clickContinue();
		vp.removeGiftcertificate();
		reload();
		getScreenshot("GiftCertificateRemoveTest", driver);
		SuccessMessage("Your shopping cart is empty!");
		hp.clickLogout();
		reload();
		SuccessMessage("Account Logout");
		hp.clickContinue();
	}

}
