package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class RegistrationPage extends AbstractComponent{

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	WebElement FirstName;
	
	@FindBy(id="input-lastname")
	WebElement LastName;
	
	@FindBy(id="input-email")
	WebElement Email;
	
	@FindBy(id="input-telephone")
	WebElement Telephone;
	
	@FindBy(id="input-password")
	WebElement Password;
	
	@FindBy(id="input-confirm")
	WebElement ConfirmPassword;
	
	@FindBy(css="input[value='1']")
	WebElement NewsletterYes;
	
	@FindBy(css="input[value='0']")
	WebElement NewsletterNo;
	
	@FindBy(tagName="b" )
	WebElement PrivacyPolicy;
	
	@FindBy(css="button.close")
	WebElement Close;
	
	@FindBy(css="input[name='agree']")
	WebElement IAgreeCheckBox;
	
	@FindBy(css="input.btn.btn-primary")
	WebElement SubmitButton;
	
	
	public void setFirstName(String fname) 
	 {
		waitForVisibility(FirstName);
		sendText(FirstName, fname);
		
     }
         
	public void setLastName(String lname) 
	 {
		waitForVisibility(LastName);
		sendText(LastName, lname);
		
     }
	
    public void setEMail(String email) 
     {
    	waitForVisibility(Email);
    	sendText(Email, email);
    	
     }
    
    public void setTelephoneNumber(String telephone)
     {
    	sendText(Telephone, telephone);
     }
    
    public void setPassword(String password) 
     {
    	waitForVisibility(Password);
    	sendText(Password, password);
    	
     }
    
    public void setConfirmPassword(String cpassword) 
     {
    	waitForVisibility(ConfirmPassword);
    	sendText(ConfirmPassword, cpassword);
    	
     }
		
	public void clickYesNewsLetterSubscription()
	{
		click(NewsletterYes);
	}
	
	public void clickNoNewsLetterSubscription()
	{
		click(NewsletterNo);
	}
	
	public void clickPrivacyPolicy()
	{
		click(PrivacyPolicy);
		click(Close);
		
	}
	
	public void clickAgreeCheckBox()
	{
		click(IAgreeCheckBox);
	}
	
	public void clickSubmitButton()
	{
		click(SubmitButton);
	}
	
}
