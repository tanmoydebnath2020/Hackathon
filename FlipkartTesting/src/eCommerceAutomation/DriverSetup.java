package eCommerceAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	private static WebDriver driver1;
	private static WebDriver driver2;
	
	public WebDriver googleDriver() {
		String chromeDriverPath = "\\Drivers\\chromedriver.exe";
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+chromeDriverPath);
		driver1 = new ChromeDriver();
		return driver1;
	}
	public WebDriver firfoxdriver() {
		String firefoxDriverPath = "\\Drivers\\geckodriver.exe";
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", path+firefoxDriverPath);
		driver2 = new FirefoxDriver();
		return driver2;
	}
	
//	String chromeDriverPath = "\\Drivers\\chromedriver.exe";
//	String path=System.getProperty("user.dir");
//	System.setProperty("webdriver.chrome.driver", path+chromeDriverPath);

	

	

}
