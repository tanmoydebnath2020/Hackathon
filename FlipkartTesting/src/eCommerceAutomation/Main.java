package eCommerceAutomation;
//Importing the required headerfiles
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class Main {
	
	//Declaring the required static variables
    static WebDriver driver;
    static Wait w = new Wait();
    static String mobile1,mobile2,mobile3,mobile4,mobile5; // Xpaths.
    static String mob1, mob2, mob3, mob4, mob5;
    static String mobile;
    static WriteFile wf = new WriteFile();
    static ReadFile rf = new ReadFile();
    static String item,cost,url;
    static Scanner x = new Scanner(System.in);
    static DriverSetup ds = new DriverSetup();
    
    //Driver Setup(Chrome Driver) 
    public static WebDriver createChromeDriver() {
    	
    	driver = new DriverSetup().googleDriver();
    	return driver;
    }
    public static WebDriver createFirefoxDriver(){
    	driver = new DriverSetup().firfoxdriver();
    	return driver;
    }
    
    //Navigating to the official site of Flipkart.
    public static void navigation(String url) {
    	
    	driver.get(url);
		driver.navigate().to(url);
    }
    
    // Removing login prompt.
    public static void removeLogin() {
    
    	Actions action = new Actions(driver);
    	Action sendEsc = action.sendKeys(Keys.ESCAPE).build();
    	sendEsc.perform();
	}
	
    //finding the mobile phones by passing the driver and xpath as parameters
    public static String findingPhones(WebDriver driver, String xpath) { 
    	
    	boolean mob = driver.findElements(By.xpath(xpath)).size() != 0;
    	if(mob) {
    		mobile = driver.findElement(By.xpath(xpath)).getText();
    	}
    	return mobile;
    }
    
    public static WebDriver selectingBrowser(int n){ //Selecting the browser depending on platform requirements.
    	
    	
    	switch(n){
    		case 1: driver = ds.googleDriver(); break;
    		case 2: driver = ds.firfoxdriver(); break;
    		default: System.out.println("Try again");
    	}
    	
    	
    	
    	return driver;
    }
    
    //Working on the Main Method
	public static void main(String[] args) {
		
		//Driver Setup(Depending on the requirement)
		System.out.println("Your Browser Choice: \n");
    	System.out.println("1. Google Chrome");
    	System.out.println("2. Firefox");
    	System.out.println("Enter your choice: \r");
    	int n = x.nextInt();
    	
    	driver = selectingBrowser(n) ;
		
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		//Writing Information in Properties file.
		wf.writingInformation("Mobile Phones", "30000", "https://www.flipkart.com");
		
		url = rf.readURL();
		
		//Navigating to the official site of Flipkart.
		navigation(url);
		
		// Removing login prompt.
		removeLogin();
		w.wait(driver);
		
		item = rf.readItem();
		cost = rf.readPrice();
		
		
		
		
		//Searching for the Mobile Phones
		driver.findElement(By.name("q")).sendKeys(item);
		w.wait(driver);
		driver.findElement(By.className("vh79eN")).click();
		w.wait(driver);
		
		//Selecting Newest First Tab
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[5]")));
		WebElement newFirst = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[5]")); 
		w.wait(driver);
		newFirst.click(); 
		
		//Selecting the Price Range to a maximum value of 30,000.
		WebElement price = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
		Select selectingPrice = new Select(price);
		selectingPrice.selectByValue(cost);
		
		
		
		//Assigning the xpaths to the respective variables. 
		mobile1 = "//div[contains(text(),'Vivo Y20')]";
		mobile2 = "//div[contains(text(),'Karbonn Titanium S9 Plus (Midnight Blue, 32 GB)')]";
		mobile3 = "//div[contains(text(),'Realme Narzo 20 (Glory Sliver, 128 GB)')]";
		mobile4 = "//div[contains(text(),'POCO X3 (Shadow Gray, 128 GB)')]";
		mobile5 = "//div[contains(text(),'POCO X3 (Cobalt Blue, 128 GB)')]";
		
		//Getting the text.
		mob1 = findingPhones(driver, mobile1);
	
		mob2 = findingPhones(driver, mobile2);
		
		mob3 = findingPhones(driver, mobile3);
		
		mob4 = findingPhones(driver, mobile4);
		
		mob5 = findingPhones(driver, mobile5);
		
		
		
		//Saving all the mobiles in Properties file. Named: mobile.properties
		wf.writingfile(mob1, mob2, mob3, mob4, mob5);
		
		//Reading all the mobile stored in properties file.
		rf.readFile();
		
		
		//Closing the browser. 
		driver.close();
		
		//Closing the driver
		driver.quit();
		}
		
	}


