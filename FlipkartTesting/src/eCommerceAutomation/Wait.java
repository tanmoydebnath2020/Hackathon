package eCommerceAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Wait {
	private WebDriver driver;
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		
	}
}
