package testingIbibo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Sheet {

	public static void writeExcel(){
		// TODO Auto-generated method stub
		//Blank workbook
		XSSFWorkbook wb = new XSSFWorkbook();
		//Create sheet
		XSSFSheet sheet = wb.createSheet("SampleSheet");
		//create row and cell and  insert values in Excel Sheet
		Cell cell = null;
		Row row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Origin");
		cell = row.createCell(1);
		cell.setCellValue("Destination");
		cell = row.createCell(2);
		cell.setCellValue("Dept. Date");
		cell = row.createCell(3);
		cell.setCellValue("Passengers");
		Row row1 = sheet.createRow(1);
		cell = row1.createCell(0);
		cell.setCellValue("Delhi");
		cell = row1.createCell(1);
		cell.setCellValue("Silchar");
		cell = row1.createCell(2);
		cell.setCellValue("20-11-2020,Friday");
		cell = row1.createCell(3);
		cell.setCellValue("1");
		
		//Write file on harddisk
		
		try {
			FileOutputStream output = new FileOutputStream("SampleSheet.xlsx");
			wb.write(output);
			output.close();
			System.out.println("Sheet created successfully");
		}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[]args) {
	Excel_Sheet ex = new Excel_Sheet();
	ex.writeExcel();
	}
}