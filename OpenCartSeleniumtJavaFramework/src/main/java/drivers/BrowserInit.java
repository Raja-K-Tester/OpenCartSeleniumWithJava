package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserInit {

    protected static final String URL = "https://thetestingworld.com/shop";
    private static final int TIMEOUT = 15;
    private WebDriver driver;

    public WebDriver initializeDriver() throws IOException
	{
		// properties class
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
				//prop.getProperty("browser");
		boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless"));
		if(browserName.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(isHeadless)
					{
						options.addArguments("headless");
					}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().deleteAllCookies();
		    driver.get(URL);
		
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			 FirefoxBinary firefoxBinary = new FirefoxBinary();
			if(isHeadless)
			{
				firefoxBinary.addCommandLineOptions("--headless");
			}
			FirefoxOptions options=new FirefoxOptions();
			options.setBinary(firefoxBinary);
			driver = new FirefoxDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().deleteAllCookies();
		    driver.get(URL);
	
		} else if (browserName.equalsIgnoreCase("edge")) {
			
			EdgeOptions options=new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			if(isHeadless)
			{
				options.addArguments("headless");
			}
			driver = new EdgeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().deleteAllCookies();
		    driver.get(URL);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		return driver;
	}
    
}
