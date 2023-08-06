package abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	 public WebDriverWait wait;
	 private static final int TIMEOUT = 15;


	 public AbstractComponent(WebDriver driver)
	  {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  }

	 public void waitForVisibility(WebElement element)
	  {
        wait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
	  }

	 public void click(WebElement element)
 	  {
		waitForVisibility(element);
        element.click();
	  }

	 public void sendText(WebElement element, String text)
	  {
	    waitForVisibility(element);
	    element.sendKeys(text);
	  }

	 public void backspace(WebElement element) {
			// TODO Auto-generated method stub
			element.sendKeys(Keys.BACK_SPACE);
		}
	 public String getText(WebElement element)
	  {
        waitForVisibility(element);
        return element.getText();
	  }

	 public String selectcountrydropdown(WebElement element,String countryname)
	 {
		 Select country=new Select(element);
		 country.selectByVisibleText(countryname);
		 return countryname;

	 }

	 public String selectstatedropdown(WebElement element,String statename)
	 {
		 Select state=new Select(element);
		 state.selectByVisibleText(statename);
		 return statename;

	 }

	 public String selectcolordropdown(WebElement element,String yellow)
	 {
		 Select color=new Select(element);
		 color.selectByValue(yellow);
		 return yellow;

	 }

	 public void scrollPage()
	  {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
      }

	 public void sleep()
	 {
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	 public void sleepwith20Seconds()
	 {
		 try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}
