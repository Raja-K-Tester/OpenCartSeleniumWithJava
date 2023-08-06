package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	HomePage hp=new HomePage(driver);
	LoginPage lp=new LoginPage(driver);
	ProductCatalogue pc=new ProductCatalogue(driver);
	Faker randomdata=new Faker();
	String pfname=randomdata.name().firstName();
	String plname=randomdata.name().lastName();
	String paddress=randomdata.address().fullAddress();
	String pcity=randomdata.address().city();
	String postcode=randomdata.address().zipCode();
	String pcountry="India";
	String pstate="Karnataka";

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input#button-payment-address")
	WebElement BillingDetails;

	@FindBy(xpath="//label[normalize-space()='I want to use an existing address']")
	WebElement ExistingAddress;

	@FindBy(id="input-payment-firstname")
	WebElement PaymentFirstName;

	@FindBy(id="input-payment-lastname")
	WebElement PaymentLastName;

	@FindBy(id="input-payment-address-1")
	WebElement PaymentAddress;

	@FindBy(id="input-payment-city")
	WebElement PaymentCity;

	@FindBy(id="input-payment-postcode")
	WebElement PostCode;

	@FindBy(id="input-payment-country")
	WebElement PaymentCountry;

	@FindBy(id="input-payment-zone")
	WebElement PaymentState;

	@FindBy(id="button-shipping-address")
	WebElement DeliveryDetails;

	@FindBy(css="textarea[name='comment']")
	WebElement OrderComments;

	@FindBy(xpath="//div[@class='panel-body']/p[3]/textarea")
	WebElement DeliveryComments;

	@FindBy(id="button-shipping-method")
	WebElement DeliveryMethod;

	@FindBy(css="a.agree")
	WebElement TermsandConditions;

	@FindBy(css="button.close")
	WebElement CloseButton;

	@FindBy(name="agree")
	WebElement AgreeCheckBox;

	@FindBy(id="button-payment-method")
	WebElement PaymentMethod;

	@FindBy(id="button-confirm")
	WebElement ConfirmOrder;

	public void checkoutandplaceorder()
	{
		click(BillingDetails);
		waitForVisibility(DeliveryDetails);
		click(DeliveryDetails);
		sendText(OrderComments, "Make sure the Product you delivered is a high quality product");
		waitForVisibility(DeliveryMethod);
		click(DeliveryMethod);
		waitForVisibility(DeliveryComments);
		sendText(DeliveryComments, "Urgent!Please deliver it as early as possible");
		waitForVisibility(TermsandConditions);
		click(TermsandConditions);
		click(CloseButton);
		click(AgreeCheckBox);
		click(PaymentMethod);
		waitForVisibility(ConfirmOrder);
		click(ConfirmOrder);
		sleep();
	}

	public void BillingDetails()
	{
		sendText(PaymentFirstName,pfname);
		sendText(PaymentLastName,plname);
		sendText(PaymentAddress,paddress);
		sendText(PaymentCity,pcity);
		sendText(PostCode,postcode);
		waitForVisibility(PaymentCountry);
		selectcountrydropdown(PaymentCountry,pcountry);
		waitForVisibility(PaymentState);
		selectstatedropdown(PaymentState,pstate);
	}

}
