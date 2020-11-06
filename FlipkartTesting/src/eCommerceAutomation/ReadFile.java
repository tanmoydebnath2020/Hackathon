package eCommerceAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFile {
	
	public void readFile() { //Used to read the output stored in the properties files.
		Properties prop = new Properties();
		InputStream readFile = null;
		try {
			readFile = new FileInputStream("mobile.properties");
			try {
				prop.load(readFile);
				System.out.println(prop.getProperty("1"));
				System.out.println(prop.getProperty("2"));
				System.out.println(prop.getProperty("3"));
				System.out.println(prop.getProperty("4"));
				System.out.println(prop.getProperty("5"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(readFile != null) {
				try {
					readFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public String readItem() { //Used to read the item that has to be searched in the properties file.
		
		Properties prop = new Properties();
		InputStream readFile = null;
		String item = null;
		try {
			readFile = new FileInputStream("info.properties");
			try {
				prop.load(readFile);
				item = prop.getProperty("ItemToBeSearched");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(readFile != null) {
				try {
					readFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return item;
		
	}
	public String readPrice() { //Used to read the cost price stored in the properties file.
		
		Properties prop = new Properties();
		InputStream readFile = null;
		String price = null;
		try {
			readFile = new FileInputStream("info.properties");
			try {
				prop.load(readFile);
				price = prop.getProperty("CostPrice");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(readFile != null) {
				try {
					readFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return price;
	}
	
	public String readURL() { //Used to read the base url store in the document.
		
		Properties prop = new Properties();
		InputStream readFile = null;
		String url = null;
		try {
			readFile = new FileInputStream("info.properties");
			try {
				prop.load(readFile);
				url = prop.getProperty("BaseURL");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(readFile != null) {
				try {
					readFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return url;
		
	}
		
	

}
