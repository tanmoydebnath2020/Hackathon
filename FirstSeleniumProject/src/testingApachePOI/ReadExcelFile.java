package testingApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public static void main(String[] args) throws IOException {
		FileInputStream readFile = new FileInputStream("firsSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
		XSSFSheet sheet = workbook.getSheet("FirstSheet");
		Row row;
		Cell cell;
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()){
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				cell = cellIterator.next();
				
				DataFormatter dataformatter = new DataFormatter();
				String text = dataformatter.formatCellValue(cell);
				System.out.print(text);
				System.out.println("\n");
			}
		}
		
		
	}
}
