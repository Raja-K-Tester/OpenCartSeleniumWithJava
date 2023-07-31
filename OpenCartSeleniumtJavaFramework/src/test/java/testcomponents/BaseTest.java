package testcomponents;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers.BrowserInit;
import pageobjects.HomePage;


public class BaseTest extends BrowserInit{
	
	public WebDriver driver;
	public HomePage homepage;
	
	
	public String getScreenshot(String testCaseName,WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	public String getElementScreenshot(String testCaseName,WebDriver driver)
	{
		WebElement text=driver.findElement(By.xpath("//p[contains(text(),'Thank you for purchasing')]"));
		File file=text.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		try {
			FileUtils.copyFile(file,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
	}
	public void reload()
	{
		driver.navigate().refresh();
		
	}
	
	public void fileupload()
	{
		try {
			Thread.sleep(30000);
			Runtime.getRuntime().exec("C:\\eclipse-workspace\\OpenCartSeleniumtJavaFramework\\AutoIT\\opencartfileupload1.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().dismiss();
	}
	
	public void clickContactUsPage()
	{
		//Header Contact Link
		driver.findElement(By.xpath("//div[@id='top-links']/ul/li[1]/a")).click();
		driver.findElement(By.id("input-name")).sendKeys("ab");
		driver.findElement(By.id("input-email")).sendKeys("ab");
		driver.findElement(By.id("input-enquiry")).sendKeys("ab");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// Verify Error Message
		String namemsg=driver.findElement(By.xpath("//div[contains(text(),'Name')]")).getText();
		String emailmsg=driver.findElement(By.xpath("//div[contains(text(),'E-Mail')]")).getText();
		String enqmsg=driver.findElement(By.xpath("//div[contains(text(),'Enquiry')]")).getText();
		Assert.assertEquals(namemsg,"Name must be between 3 and 32 characters!");
		Assert.assertEquals(emailmsg,"E-Mail Address does not appear to be valid!");
		Assert.assertEquals(enqmsg,"Enquiry must be between 10 and 3000 characters!");
	}
	
	 public void SuccessMessage(String message) {
	        boolean pageSource = driver.getPageSource().contains(message);
	        Assert.assertTrue(pageSource);
	    }
	 
	
	
	@BeforeMethod(alwaysRun = true)
	public void launchApplication()
	{
		try {
			driver=initializeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
	


}