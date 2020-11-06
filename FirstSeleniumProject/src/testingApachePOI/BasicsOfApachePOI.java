package testingApachePOI;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
public class BasicsOfApachePOI {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		OutputStream writeFile = null;
		try {
			writeFile = new FileOutputStream("first.properties");
			prop.setProperty("Name", "Tanmoy Debnath");
			prop.setProperty("Age", "22");
			prop.setProperty("MobileNumber", "7550170324");
			
			prop.store(writeFile, null);
			System.out.println("File Created Successfully");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(writeFile != null) {
				try {
					writeFile.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		Properties prop2 = new Properties();
		InputStream readFile = null;
		try {
			readFile = new FileInputStream("first.properties");
			prop2.load(readFile);
			System.out.println(prop2.getProperty("Name"));
			System.out.println(prop2.getProperty("Age"));
			System.out.println(prop2.getProperty("MobileNumber"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(readFile != null) {
				try {
					readFile.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
