package firstSeleniumTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestOne {
	static String mobile1,mobile2,mobile3,mobile4,mobile5;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Util\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //Maximizing the window.
		
		driver.get("https://www.flipkart.com");
		
		driver.navigate().to("https://www.flipkart.com"); // Going to Flipkart website.
		
		Actions action = new Actions(driver);
		
		Action sendEsc = action.sendKeys(Keys.ESCAPE).build();
		
		sendEsc.perform(); // Removing login prompt.
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Smart Phones");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.className("vh79eN")).click(); //This will search mobile phones.
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[5]")));
		
		WebElement newFirst = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[5]")); //Selecting Newest First Tab
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		newFirst.click();
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement price = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
		Select selectingPrice = new Select(price);
		selectingPrice.selectByValue("30000"); //Selecting the maximum price for the phones.
		
		//int count = 0;
		ArrayList<String> mobilePhones = new ArrayList<String>();
		
		
	    boolean mob1 = driver.findElements(By.xpath("//div[contains(text(),'Spinup A9 (Blue, 32 GB)')]")).size() != 0;
		if(mob1) {
			mobile1 = driver.findElement(By.xpath("//div[contains(text(),'Spinup A9 (Blue, 32 GB)')]")).getText();
			mobilePhones.add(mobile1);
			System.out.println("Mobile 1 Added Successfully");
		}
		boolean mob2 = driver.findElements(By.xpath("//div[contains(text(),'Ismart i1 Supreme (Black, 32 GB)')]")).size() != 0;
		if(mob2) {
			mobile2 = driver.findElement(By.xpath("//div[contains(text(),'Ismart i1 Supreme (Black, 32 GB)')]")).getText();
			mobilePhones.add(mobile2);
			System.out.println("Mobile 2 Added Successfully");
			
		}
		boolean mob3 = driver.findElements(By.xpath("//div[contains(text(),'OPPO F17 (Navy Blue, 128 GB)')]")).size() != 0;
		if(mob3) {
			mobile3 = driver.findElement(By.xpath("//div[contains(text(),'OPPO F17 (Navy Blue, 128 GB)')]")).getText();
			mobilePhones.add(mobile3);
			System.out.println("Mobile 3 Added Successfully");
		}
		boolean mob4 = driver.findElements(By.xpath("//div[contains(text(),'Nokia C3 (Nordic Blue, 32 GB)')]")).size() != 0;
		if(mob4) {
			mobile4 = driver.findElement(By.xpath("//div[contains(text(),'Nokia C3 (Nordic Blue, 32 GB)')]")).getText();
			mobilePhones.add(mobile4);
			System.out.println("Mobile 4 Added Successfully");
		}
		boolean mob5 = driver.findElements(By.xpath("//div[contains(text(),'Realme Narzo 20 (Victory Blue, 128 GB)')]")).size() != 0;
		if(mob5) {
			mobile5 = driver.findElement(By.xpath("//div[contains(text(),'Realme Narzo 20 (Victory Blue, 128 GB)')]")).getText();
			mobilePhones.add(mobile5);
			System.out.println("Mobile 5 Added Successfully");
		}
		
		System.out.println(mobilePhones);
		
//		Properties prop1 = new Properties();
//		OutputStream writeFile = null;
//		try {
//			writeFile = new FileOutputStream("first.properties");
//			prop1.setProperty("1", mobile1);
//			prop1.setProperty("2", mobile2);
//			prop1.setProperty("3", mobile3);
//			prop1.setProperty("4", mobile4);
//			prop1.setProperty("5", mobile5);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(writeFile != null) {
//				try {
//					writeFile.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		Properties prop2 = new Properties();
//		InputStream readFile = null;
//		try {
//			readFile = new FileInputStream("first.properties");
//			try {
//				prop2.load(readFile);
//				prop2.getProperty("1");
//				prop2.getProperty("2");
//				prop2.getProperty("3");
//				prop2.getProperty("4");
//				prop2.getProperty("5");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(readFile != null) {
//				try {
//					writeFile.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		
		
		
	}
}
