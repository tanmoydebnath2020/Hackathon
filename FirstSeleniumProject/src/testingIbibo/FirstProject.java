package testingIbibo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FirstProject {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Util\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //Maximizing the window.
        driver.get("https://www.goibibo.com/");
		
		//To maximize the Browser
		driver.manage().window().maximize();
		
		//Implement Excel Sheet in selenium
		String arr[] = Read_Excel.readExcel("SampleSheet.xlsx");
		
		//To locate and select origin according to values in excel sheet
		 driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(arr[0]);
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));

		 driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.DOWN);
		 driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.ENTER);
		 
		//To locate and select destination according to values in excel sheet
		 driver.findElement(By.id("gosuggest_inputDest")).sendKeys(arr[1]);
		 WebDriverWait wait1 = new WebDriverWait(driver, 10);
		 wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));

		 driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.DOWN);
		 driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.ENTER);
		 
		 try {
				Thread.sleep(2000);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				//To locate and select dep_time as given in Excel Sheet (considering 20 Nov,2020,Friday here)
				WebElement calender = driver.findElement(By.id("departureCalendar"));
				calender.click();
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				WebElement date = driver.findElement(By.id("fare_20201120"));
				date.click();
				
				 
				//To locate and click  search button
				WebElement search = driver.findElement(By.id("gi_search_btn"));
				search.click();
				try {
					Thread.sleep(8000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				
				//To arrange the page in desecending order according to price 
				WebElement price = driver.findElement(By.xpath("//span[contains(text(),'PRICE')]"));
				price.click();
				try {
					Thread.sleep(2000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				
				// To scroll the page to a certain extent
				JavascriptExecutor jse = (JavascriptExecutor)driver;

				jse.executeScript("scroll(0, 300);");
				
				try {
					Thread.sleep(2000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				jse.executeScript("scroll(0, 600);");
				
				try {
						Thread.sleep(2000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				
				jse.executeScript("scroll(0, 900);");
				
				try {
						Thread.sleep(2000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				jse.executeScript("scroll(0, 1200);");
				
				try {
						Thread.sleep(5000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				System.out.println("All test passed");
				
				//To Close the Browser
				driver.quit();
	}

}
