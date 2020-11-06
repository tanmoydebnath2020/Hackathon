package firstSeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTwo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Util\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.oyorooms.com/");
		driver.navigate().to("https://www.oyorooms.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement location= driver.findElement(By.id("autoComplete__home"));
		location.sendKeys(Keys.ENTER);
		location.sendKeys("Mumbai");	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		location.sendKeys(Keys.DOWN);
		location.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//To fix the calendar
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div/div/div[2]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div/div/div[2]/div/span/div/div/div[2]/table/tbody/tr[3]/td[4]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div/div/div[2]/div/span/div/div/div[2]/table/tbody/tr[3]/td[6]/span")).click();
		
		//To click the search button
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		
		//To select the Price range.
		WebElement left = driver.findElement(By.xpath("//div[contains(@class,'rangepicker')]//div/div[1]/span[1]/div"));
		WebElement right= driver.findElement(By.xpath("//div[contains(@class,'rangepicker')]//div/div[1]/span[2]/div"));
        int width = left.getSize().getWidth();
        System.out.println(width);
        
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(left).clickAndHold().moveByOffset(188,0).release().perform();
        //action.dragAndDropBy(left,19,0).build().perform();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriverWait wait=new WebDriverWait(driver,10);
        //action.moveToElement(right).clickAndHold().moveByOffset(0,450).release().perform();
        action.dragAndDropBy(right,80, 0).build().perform();
      
	}

}
