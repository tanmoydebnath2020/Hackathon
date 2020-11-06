package firstSeleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestThree {
	
	static WebDriver driver;
	
	public WebDriver createDriver()
	{
		//Function to create Chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\Util\\chromedriver_win32 (1)\\chromedriver.exe");
        driver=new ChromeDriver();
      //Maximizing the browser window
        driver.manage().window().maximize(); 
        //Opening the www.amazon.in website
        driver.get("https://www.amazon.in/"); 
        return driver;
	}
	
//	public WebDriver createFirefoxDriver()
//	{
//		//Function to create Firefox driver
//		System.setProperty("webdriver.gecko.driver","C:\\Users\\acer\\workspace\\SeleniumProject\\drivers\\geckodriver.exe" );
//		driver=new FirefoxDriver();
//		//Maximizing the browser window
//		driver.manage().window().maximize(); 
//	
//		//Opening the www.amazon.in website
//		driver.get("https://www.amazon.in/");
//		return driver;
//	}
	
	public WebDriver findMobile()
    {
	 driver.findElement(By.linkText("Mobiles")).click();
	 return driver;
	 }
	
	public WebDriver setPriceRange()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("low-price")));
		driver.findElement(By.id("low-price")).sendKeys("20000");
		driver.findElement(By.id("high-price")).sendKeys("30000");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@class='a-button-input']"))));
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click(); 
		return driver;
	}
	
	public String[]  MobileDetails()
	{
		//Function to store (using an ArrayList<String>) all the mobile details (of 1st 5 mobiles) displayed in the search results (except price)
		//And close browser
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		String str = "//span[@class='a-size-medium a-color-base a-text-normal']";
		List<WebElement> element = driver.findElements(By.xpath(str));
		
		 int s1 = element.size();
			 String[] array = new String[s1];
			 for(int i=0;i<5;i++){
				 array[i] = element.get(i).getText();
				 }
				 System.out.println(array);
	/*  for(WebElement mob : element)
	  {
		  System.out.println(mob.getText());
	  }*/
	  
       driver.close();
       return array;
    }
	public static void main(String[] args) {
		
		 
		
		
		
		
	
	}
}
