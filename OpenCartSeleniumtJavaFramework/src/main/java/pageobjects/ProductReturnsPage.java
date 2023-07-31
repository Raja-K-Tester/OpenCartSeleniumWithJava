package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class ProductReturnsPage extends AbstractComponent {
	
	WebDriver driver;
	HomePage hp=new HomePage(driver);

	public ProductReturnsPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="input-order-id")
	WebElement OrderID;
	
	@FindBy(id="input-date-ordered")
	WebElement OrderDate;
	
	@FindBy(id="input-product")
	WebElement ProductName;
	
	@FindBy(id="input-model")
	WebElement ProductCode;
	
	@FindBy(id="input-quantity")
	WebElement Quantity;
	
	@FindBy(xpath="//label[normalize-space()='Dead On Arrival']")
	WebElement ReturnReason;
	
	@FindBy(xpath="//label[@class='radio-inline']/input[@value='1']")
	WebElement ProductOpenedorNot;
	
	@FindBy(id="input-comment")
	WebElement TextArea;
	
	@FindBy(css="input.btn.btn-primary")
	WebElement Submit;
	
	public void ReturnProduct()
	{
		sendText(OrderID, "196");
		waitForVisibility(OrderDate);
		sendText(OrderDate, "2023-07-28");
		waitForVisibility(ProductName);
		sendText(ProductName, "iPhone");
		waitForVisibility(ProductCode);
		sendText(ProductCode, "product11");
		backspace(Quantity);
		sendText(Quantity, "1");
		click(ReturnReason);
		waitForVisibility(ProductOpenedorNot);
		click(ProductOpenedorNot);
		waitForVisibility(TextArea);
		sendText(TextArea, "Need Replacement");
		click(Submit);
		sleep();
	}
	
}
