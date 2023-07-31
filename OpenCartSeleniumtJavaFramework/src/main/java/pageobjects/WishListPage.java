package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractcomponents.AbstractComponent;


public class WishListPage extends AbstractComponent  {
	
	WebDriver driver;
	HomePage hp=new HomePage(driver);

	public WishListPage(WebDriver driver) 
	 {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	 }

	@FindBy(xpath="//button[@onclick=\"wishlist.add('43');\"]")
	WebElement MacBookWishList;
	
	@FindBy(xpath="//button[@onclick=\"cart.add('43');\"]")
	WebElement MacBookCart;
	
	@FindBy(xpath="//button[@onclick=\"wishlist.add('40');\"]")
	WebElement IPhoneWishList;
	
	@FindBy(xpath="//button[@onclick=\"cart.add('40');\"]")
	WebElement IPhoneCart;
	
	@FindBy(xpath="//button[@onclick=\"wishlist.add('42');\"]")
	WebElement AppleCinema30WishList;
	
	@FindBy(xpath="//div[@id='input-option218']/div[3]/label/input")
	WebElement LargeRadioOption;
	
	@FindBy(xpath="//div[@id='input-option223']/div[4]/label/input")
	WebElement LargeCheckBox;
	
	@FindBy(id="input-option217")
	WebElement SelectYellow;
	
	@FindBy(css="textarea#input-option209")
	WebElement TextArea;
	
	@FindBy(css="button#button-upload222")
	WebElement FileUpload;
	
	@FindBy(id="input-option219")
	WebElement Date;
	
	@FindBy(id="input-option221")
	WebElement Time;
	
	@FindBy(css="button#button-cart")
	WebElement AddtoCartButton;
	
	@FindBy(xpath="//button[@onclick=\"cart.add('42');\"]")
	WebElement AppleCinema30Cart;
	
	@FindBy(xpath="//button[@onclick=\"wishlist.add('30');\"]")
	WebElement CanonEOS5DWishList;
	
	@FindBy(xpath="//a[@href='https://thetestingworld.com/shop/index.php?route=account/wishlist&remove=30']")
	WebElement RemoveCanonEOS5DWishList;
	
	public void additemstoWishList()
	{
		click(MacBookWishList);
		waitForVisibility(IPhoneWishList);
		click(IPhoneWishList);
		sleep();
		click(AppleCinema30WishList);
		sleep();
		click(CanonEOS5DWishList);
	}
	
	public void removeCanonEOS5DWishList()
	{
		click(RemoveCanonEOS5DWishList);
	}
			
	public void addiPhoneMacBookCart()
	{
		click(IPhoneCart);
		sleep();
		click(MacBookCart);
		sleep();
	}
	
	public void addAppleCinema()
	{
		click(AppleCinema30Cart);
		click(LargeRadioOption);
		click(LargeCheckBox);
		selectcolordropdown(SelectYellow, "2");
		sendText(TextArea, "Welcome to my Project.Thanks for your time to test this application");
		waitForVisibility(FileUpload);
		click(FileUpload);
	}
	
	public void continueAppleCinemaCart()
	{
		sendText(Date, "2023/07/28");
		waitForVisibility(Time);
		sendText(Time, "11:30");
		waitForVisibility(AddtoCartButton);
		click(AddtoCartButton);
	}

}
