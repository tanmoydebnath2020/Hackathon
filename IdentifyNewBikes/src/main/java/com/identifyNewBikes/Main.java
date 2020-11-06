package com.identifyNewBikes;

import java.util.ArrayList;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;

public class Main {
	
	    //Declaration of static variables.
		public static String Url= "https://www.zigwheels.com";
		public static Scanner sc=new Scanner(System.in);
		static Wait wait = new Wait();
		
	    //Method selecting the browser depending on platform requirements.
		
	    public static WebDriver driver;
	    
	    //Getting the driver 
	    public static void getDriver() throws Exception {
	    	String[] data=ExcelUtils.readExcelData("Sheet1");
	    	//Browser Choices
			String ChromeDriver_WindowsOS=data[4];
			String FirefoxDriver_WindowsOS=data[5];
			String OperaDriver_WindowsOS=data[6];
			String ChromeDriver_MacOS=data[7];
			String OperaDriver_MacOS=data[8];
			
			//Enter your browser choice in between the inverted Commas
			driver=DriverSetup.invokeDriver(ChromeDriver_WindowsOS);
	    	
	    }
	    
		
		//Navigating to the official site of Zigwheels
		public static void navigation(WebDriver driver){
			driver.manage().window().maximize();
			driver.get(Url);
			driver.navigate().to(Url);
		}
		
		public static void getGoogleSignIn() throws Exception {
			//Google Sign-in
			GoogleSignIn.googleSignIn(driver);
			
			String[] data=ExcelUtils.readExcelData("Sheet1");
			String emailInvalid=data[0];
			String passwordInvalid=data[1];
			
			//Filling the Invalid details		
			GoogleSignIn.fillLoginForm(emailInvalid,passwordInvalid, driver);
			
		}
		
		public static void getPopularUsedCars() throws Exception {
			ArrayList<String> cars = PopularUsedCars.popularUsedCars(driver);
			//Writing them in a file
			WritingPropertiesFile.writingfile(cars, "Used-Cars");
		}
		
		public static void getUpcomingBikes() throws Exception {
			ArrayList<String> bikes = UpcomingBikes.findingUpcomingBikes(driver);
			//Writing them
			WritingExcelFile.writeExcel(bikes);
		}
		
		//Closing the Driver
		public static void closeApplication(WebDriver driver){
			driver.close();
			driver.quit();
		}
		
		public static void main(String[] args) throws Exception{
			
			//Invoking the Driver.
		    getDriver();
			
		    //Google Sign-in
			getGoogleSignIn();
			
			//Navigating to the official site of Zigwheels.
			navigation(driver);
			
			//Popular Cars in Chennai
			getPopularUsedCars();
						
			//Upcoming Honda Bikes
			getUpcomingBikes();
			
			//Closing the driver.
			closeApplication(driver);
	     } 
	

}
