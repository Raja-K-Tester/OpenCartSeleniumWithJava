package tests;

import org.testng.annotations.Test;

import pageobjects.HomePage;
import testcomponents.BaseTest;

public class HeaderFooterLinksTest extends BaseTest {

	@Test
	public void HeaderFooterLinks()
	{
		HomePage hp=new HomePage(driver);
		clickContactUsPage();
		hp.clickHomePage();
		hp.clickFooterLinks();
	}
}
