package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractcomponents.AbstractComponent;

public class HomePage extends AbstractComponent{
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="span.caret")
	WebElement MyAccountDropDown;
	
	@FindBy(linkText="Register")
	WebElement Register;
	
	@FindBy(linkText="Login")
	WebElement Login;
	
	@FindBy(linkText="Logout")
	WebElement Logout;
	
	@FindBy(name="search")
	WebElement Search;
	
	@FindBy(css="i.fa.fa-search")
	WebElement SearchButton;
	
	@FindBy(css="i.fa.fa-home")
	WebElement HomePage;
	
	@FindBy(css="i.fa.fa-caret-down")
	WebElement CurrencyDropDown;
	
	@FindBy(css="button[name='GBP']")
	WebElement PoundSterling;
	
	@FindBy(css="button[name='EUR']")
	WebElement Euro;
	
	@FindBy(linkText="Continue")
	WebElement Continue;
	
	@FindBy(css="a[title='Shopping Cart']")
	WebElement ShoppingCart;
	
	@FindBy(css="a[title='Checkout']")
	WebElement Checkout;
	
	@FindBy(css="a#wishlist-total")
	WebElement WishList;
	
	@FindBy(css="i.fa.fa-phone")
	WebElement ContactUs;
	
	@FindBy(linkText="Returns")
	WebElement Returns;
	
	@FindBy(linkText="Gift Certificates")
	WebElement GiftCertificate;
	
	@FindBy(linkText="Desktops")
	WebElement Desktops;
	
	@FindBy(linkText="Mac (1)")
	WebElement Mac;
	
	@FindBy(linkText="Tablets")
	WebElement Tablets;
	
	@FindBy(linkText="Cameras")
	WebElement Cameras;
	
	@FindBy(linkText="Laptops & Notebooks")
	WebElement LaptopandNoteBooks;
	
	@FindBy(linkText="Show All Laptops & Notebooks")
	WebElement ShowAllLapandNoteBooks;
	
	@FindBy(linkText="MP3 Players")
	WebElement Mp3Players;
	
	@FindBy(linkText="Show All MP3 Players")
	WebElement ShowAllMp3Players;
	
	@FindBy(tagName="footer")
	WebElement Footer;
	
	
	public void clickRegister()
	{
		
		click(MyAccountDropDown);
		click(Register);
	}
	
	public void clickLogin()
	{
		click(MyAccountDropDown);
		click(Login);
	}
	
	public void clickLogout()
	{
		click(MyAccountDropDown);
		click(Logout);
	}
	
	public void clickHomePage()
	{
		click(HomePage);
	}
	
	public void changetoEuroCurrency()
	{
		click(CurrencyDropDown);
		click(Euro);
	}
	
	public void changetoPoundSterling()
	{
		click(CurrencyDropDown);
		click(PoundSterling);
	}
	
	public void searchProduct(String searchproduct)
	{
		sendText(Search, searchproduct);
		click(SearchButton);
	}
	
	public void clickShoppingCart()
	{
		click(ShoppingCart);
	}
	
	public void clickCheckout()
	{
		click(Checkout);
	}
	
	public void clickWishList()
	{
		click(WishList);
	}
	
	public void clickContactUs()
	{
		click(ContactUs);
	}
	
	public void clickReturns()
	{
		click(Returns);
	}
	
	public void clickGiftCertificate()
	{
		click(GiftCertificate);
	}
	
	public void clickContinue()
	{
		click(Continue);
	}
	
	public void clickDesktopandMac()
	{
		click(Desktops);
		waitForVisibility(Mac);
		click(Mac);
	}
	
	public void clickTablets()
	{
		click(Tablets);
	}
	
	public void clickCameras()
	{
		click(Cameras);
	}
	
	public void clickLapNoteBookandShowAll()
	{
		click(LaptopandNoteBooks);
		waitForVisibility(ShowAllLapandNoteBooks);
		click(ShowAllLapandNoteBooks);
	}
	
	public void clickMP3PlayersandShowAll()
	{
		click(Mp3Players);
		waitForVisibility(ShowAllMp3Players);
		click(ShowAllMp3Players);
	}
	
	
	public void clickFooterLinks()
	{
		for(int i = 1;i<Footer.findElements(By.tagName("a")).size(); i++) 
		{ 
			String clicklink=Keys.chord(Keys.CONTROL, Keys.ENTER);
		  Footer.findElements(By.tagName("a")).get(i).sendKeys(clicklink); 
		} 
		// Open all tabs and get title of page 
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator(); 
		while (it.hasNext()) 
		{
		  driver.switchTo().window(it.next()); 
		  System.out.println(driver.getTitle());
		}
		 
	}
}
