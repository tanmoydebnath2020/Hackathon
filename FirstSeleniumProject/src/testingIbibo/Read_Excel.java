package testingIbibo;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Read_Excel {
	     public static String[] Data =new String[2];
	     public static String[] readExcel(String filename) throws Exception {
	     //To input Excel Sheet
		 FileInputStream fis = new FileInputStream("SampleSheet.xlsx");
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sheet = wb.getSheetAt(0);
		 Row row;
		 Cell cell;
		 //To read origin and destination from sheet
		 cell=sheet.getRow(1).getCell(0);
		 Data[0] = cell.getStringCellValue();
		 cell = sheet.getRow(1).getCell(1);
		 Data[1] = cell.getStringCellValue();
		 return Data;
		
	}
	 
}
