package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class ViewUpdateDeleteProductsPage extends AbstractComponent  {

	WebDriver driver;
	HomePage hp=new HomePage(driver);
	LoginPage lp=new LoginPage(driver);

	public ViewUpdateDeleteProductsPage(WebDriver driver)
	 {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	 }

	@FindBy(xpath="//div[@class='input-group btn-block']/input")
	WebElement Quantity;

	@FindBy(css="button[data-original-title='Update']")
	WebElement Update;

	@FindBy(css="button[data-original-title='Remove']")
	WebElement Remove;

	@FindBy(xpath="//strong[contains(text(),'Nikon D300')]")
	WebElement NikonD300Product;

	@FindBy(linkText="Reviews (0)" )
	WebElement Reviews;

	@FindBy(xpath="//ul[@class='thumbnails']/li[1]")
	WebElement Image;

	@FindBy(css="button[title='Next (Right arrow key)']")
	WebElement RightArrowKey;

	@FindBy(css="button[title='Close (Esc)']")
	WebElement Close;

	@FindBy(css="button#button-cart")
	WebElement AddtoCartButton;

	@FindBy(xpath="//tbody[1]/tr[1]/td[2]/a[1]")
	WebElement MacBookProductLink;

	@FindBy(xpath="//tbody[1]/tr[1]/td[3]/a[1]")
	WebElement MacBookAirLink;

	@FindBy(xpath="//tbody[1]/tr[1]/td[4]/a[1]")
	WebElement MacBookProLink;

	@FindBy(xpath="//tbody[1]/tr[1]/td[5]/a[1]")
	WebElement SonyVAIOProductLink;

	@FindBy(linkText = "iPod Classic")
	WebElement iPodClassicLink;

	@FindBy(linkText = "iPod Touch")
	WebElement iPodTouchLink;

	public void galaxytabupdateremove()
	{
		backspace(Quantity);
		sendText(Quantity, "4");
		click(Update);
		click(Remove);
	}

	public void clicktNikonD300()
	{
		scrollPage();
		sleep();
		click(NikonD300Product);
		scrollPage();
		sleepwith20Seconds();
		click(Reviews);
		sleep();
		click(Image);
		sleep();
		click(RightArrowKey);
		sleep();
		click(RightArrowKey);
		sleep();
		click(RightArrowKey);
		sleep();
		click(RightArrowKey);
		sleep();
		click(Close);
		sleep();
		click(AddtoCartButton);
		sleep();
	}

	public void WindowHandlesForMacNoteBook()
	{
		String clickandopentab =Keys.chord(Keys.CONTROL,Keys.ENTER);
		sendText(MacBookProductLink, clickandopentab);
		sendText(MacBookAirLink, clickandopentab);
		sendText(MacBookProLink, clickandopentab);
		sendText(SonyVAIOProductLink, clickandopentab);
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentid=it.next();
		String notebook=it.next();
		String macpro=it.next();
		String macair=it.next();
		String macbook=it.next();

		for(String win : windows) {
			if(win==parentid)
			{
				driver.switchTo().window(notebook);
		        macandnotebook(driver);
		        driver.switchTo().window(macpro);
		        airandpro(driver);
		        driver.switchTo().window(macair);
		        airandpro(driver);
		        driver.switchTo().window(macbook);
		        macandnotebook(driver);
			}
		}


		driver.switchTo().window(parentid);

	}

	public void macandnotebook(WebDriver driver)
	{
		scrollPage();
	    sleep();
	    click(Image);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(Close);
	    click(AddtoCartButton);
	    sleep();
	}

	public void airandpro(WebDriver driver)
	{
		scrollPage();
	    sleep();
	    click(Image);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(Close);
	    click(AddtoCartButton);
	    sleep();
    }

	public void WindowHandlesForMP3Players()
	{
		String clickandopentab =Keys.chord(Keys.CONTROL,Keys.ENTER);
		sendText(iPodClassicLink, clickandopentab);
		sendText(iPodTouchLink, clickandopentab);
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentid=it.next();
		String ipodtouch=it.next();
		String ipodclassic=it.next();


		for(String win : windows) {
			if(win==parentid)
			{
				driver.switchTo().window(ipodtouch);
		        iPodTouch();
		        driver.switchTo().window(ipodclassic);
		        iPodClassic();

			}
		}


		driver.switchTo().window(parentid);

	}

	public void iPodTouch()
	{
		scrollPage();
	    sleep();
	    click(Image);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(Close);
	    click(AddtoCartButton);
	    sleep();
	}

	public void iPodClassic()
	{
		scrollPage();
	    sleep();
	    click(Image);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(RightArrowKey);
	    sleep();
	    click(Close);
	    click(AddtoCartButton);
	    sleep();
    }

	public void removeGiftcertificate()
	{
		click(Remove);
		sleep();
	}
}
