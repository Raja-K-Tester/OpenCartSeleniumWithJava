package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class CompareProductsPage extends AbstractComponent	{

	WebDriver driver;
	HomePage hp=new HomePage(driver);

	public CompareProductsPage(WebDriver driver)
	 {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	 }

	@FindBy(css="button[onclick=\"compare.add('30');\"]")
	WebElement AddCanonEOS5DCompare;

	@FindBy(css="button[onclick=\"compare.add('31');\"]")
	WebElement AddNikonD300Compare;

	@FindBy(css="button[onclick=\"compare.add('48');\"]")
	WebElement AddIPodClassicCompare;

	@FindBy(css="button[onclick=\"compare.add('36');\"]")
	WebElement AddIPodNanoCompare;

	@FindBy(css="button[onclick=\"compare.add('34');\"]")
	WebElement AddIPodShuffleCompare;

	@FindBy(css="button[onclick=\"compare.add('32');\"]")
	WebElement AddIPodTouchCompare;

	@FindBy(css="button[onclick=\"compare.add('43');\"]")
	WebElement AddMacBookCompare;

	@FindBy(css="button[onclick=\"compare.add('44');\"]")
	WebElement AddMacBookAirCompare;

	@FindBy(css="button[onclick=\"compare.add('45');\"]")
	WebElement AddMacBookProCompare;

	@FindBy(css="button[onclick=\"compare.add('46');\"]")
	WebElement AddSonyVAIOCompare;

	@FindBy(css="a#compare-total")
	WebElement ProductsCompareLink;


	public void addCamerastoCompare()
	{
		click(AddCanonEOS5DCompare);
		sleep();
		click(AddNikonD300Compare);
		sleep();
		click(ProductsCompareLink);
	}


	public void addNoteBookMacBooktoCompare()
	{
		click(AddMacBookCompare);
		sleep();
		click(AddMacBookAirCompare);
		sleep();
		click(AddMacBookProCompare);
		sleep();
		click(AddSonyVAIOCompare);
		sleep();
		click(ProductsCompareLink);
	}

	public void addMp3PlayerstoCompare()
	{
		click(AddIPodClassicCompare);
		sleep();
		click(AddIPodNanoCompare);
		sleep();
		click(AddIPodShuffleCompare);
		sleep();
		click(AddIPodTouchCompare);
		sleep();
		click(ProductsCompareLink);
		scrollPage();
		sleep();
	}
}
