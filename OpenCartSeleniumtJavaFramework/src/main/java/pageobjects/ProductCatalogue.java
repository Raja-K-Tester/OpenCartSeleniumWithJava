package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import abstractcomponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	HomePage hp=new HomePage(driver);
	LoginPage lp=new LoginPage(driver);
	Faker randomdata=new Faker();
	String Name=randomdata.name().fullName();
	String Email=randomdata.internet().emailAddress();

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="button[onclick=\"cart.add('40', '1');\"]")
	WebElement IphoneAddtoCart;

	@FindBy(css="button[onclick=\"cart.add('41', '1');\"]")
	WebElement IMacAddtoCart;

	@FindBy(css="button[onclick=\"cart.add('49', '1');\"]")
	WebElement SamsungTabAddtoCart;

	@FindBy(css="span#cart-total")
	WebElement CartTotal;

	@FindBy(xpath="//strong[contains(text(),'Cart')]")
	WebElement ViewCart;

	@FindBy(id="input-to-name")
	WebElement RecipientName;

	@FindBy(id="input-to-email")
	WebElement RecipientEmail;

	@FindBy(css="input[value='6']")
	WebElement GiftCertificateTheme;

	@FindBy(id="input-message")
	WebElement Message;

	@FindBy(id="input-message")
	WebElement Amount;

	@FindBy(css="input[name='agree']")
	WebElement Agree;

	@FindBy(css="input.btn.btn-primary")
	WebElement ContinueButton;

	@FindBy(xpath="//p[contains(text(),'Thank you for purchasing')]")
	WebElement text;

	public void addIphone()
	{
		click(IphoneAddtoCart);
		sleep();
		click(CartTotal);
		click(ViewCart);

	}

	public void clickcarttotalandviewcart()
	{
		click(CartTotal);
		click(ViewCart);
	}

	public void addiMac()
	{
		click(IMacAddtoCart);
		sleep();
		click(CartTotal);
		click(ViewCart);
	}

	public void addSamsungGalaxyTab()
	{
		click(SamsungTabAddtoCart);
		sleep();
		click(CartTotal);
		click(ViewCart);
	}

	public void BuyGiftCertificate()
	{
		sendText(RecipientName, Name);
		sendText(RecipientEmail, Email);
		click(GiftCertificateTheme);
		sendText(Message,"Merry Christmas to you and your family!");
		backspace(Amount);
		sendText(Amount, "1");
		click(Agree);
		click(ContinueButton);
		sleep();

	}
}
