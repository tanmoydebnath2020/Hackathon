package testingApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	public static void main(String[] args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sampleSheet = workbook.createSheet("FirstSheet");
		System.out.println("Sheet created Successfully");
		
		//Creating a data set
		//Any collection having key value can be used here.
		Map<String,Object[]> dataset = new TreeMap<String,Object[]>();
		dataset.put("1", new Object[] {"ID","Name"});
		dataset.put("2", new Object[] {"1","Tanmoy"});
		dataset.put("3", new Object[] {"2","Saheli"});
		dataset.put("4", new Object[] {"3","Raman"});
		dataset.put("5", new Object[] {"4","Shalu"});
		
		//Entering the data in the set then in the sheet
		
		Set<String> set = dataset.keySet();
		int rowNum = 0;
		for(String key : set) {
			Row row = sampleSheet.createRow(rowNum++);
			Object[] data = dataset.get(key);
			int cellNum = 0;
			for(Object value: data) {
				
				Cell cell = row.createCell(cellNum++);
				
				if(value instanceof String) {
					cell.setCellValue((String) value);
				}else if(value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
				
			}
		}
		try {
			FileOutputStream writeFile = new FileOutputStream("firsSheet.xlsx");
			workbook.write(writeFile);
			System.out.println("File created Successfully");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
