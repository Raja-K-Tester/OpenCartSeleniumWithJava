package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class MyAccountPage extends AbstractComponent  {

	WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="span.caret")
	WebElement MyAccountDropDown;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']")
	WebElement MyAccountLink;

	@FindBy(linkText="View your order history")
	WebElement OrderHistory;

	@FindBy(linkText="Modify your wish list")
	WebElement WishlistModify;

	@FindBy(linkText="View your return requests")
	WebElement ReturnRequest;

	@FindBy(linkText = "Continue")
	WebElement ContinueButton;

	public void MyAccount()
	{
		click(MyAccountDropDown);
		waitForVisibility(MyAccountLink);
		click(MyAccountLink);
	}

	public void ModifyWishList()
	{
		click(WishlistModify);
	}

	public void ViewOrderHistory()
	{
		click(OrderHistory);
	}

	public void ViewReturnRequest()
	{
		click(ReturnRequest);
	}

}
