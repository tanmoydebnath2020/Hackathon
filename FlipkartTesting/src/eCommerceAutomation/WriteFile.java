package eCommerceAutomation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteFile {
	
	public void writingInformation(String item, String cost, String url) { // This is used to write the required information.
		Properties prop1 = new Properties();
		OutputStream writeFile = null;
		try {
			writeFile = new FileOutputStream("info.properties");
			prop1.setProperty("ItemToBeSearched", item);
			prop1.setProperty("CostPrice", cost);
			prop1.setProperty("BaseURL", url);
			prop1.store(writeFile,null);
			System.out.println("Info Given Successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writeFile != null) {
				try {
					writeFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void writingfile(String mobile1, String mobile2, String mobile3, String mobile4, String mobile5) { // This is used to store the output.
		Properties prop1 = new Properties();
		OutputStream writeFile = null;
		try {
			writeFile = new FileOutputStream("mobile.properties");
			prop1.setProperty("1", mobile1);
			prop1.setProperty("2", mobile2);
			prop1.setProperty("3", mobile3);
			prop1.setProperty("4", mobile4);
			prop1.setProperty("5", mobile5);
			prop1.store(writeFile,null);
			System.out.println("Writting Successfull");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writeFile != null) {
				try {
					writeFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
