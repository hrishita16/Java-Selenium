package gettingStarted3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataInExcel {
	
	public static void writeDynamicData() throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myFile1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DynamicData");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rows you want");
		int totalRows = sc.nextInt();
		
		System.out.println("Enter no of cells you want");
		int totalCells = sc.nextInt();
		
		for(int i=1; i<=totalRows; i++) {
			
			XSSFRow currRow = sheet.createRow(i);
			System.out.println("enter cell values for row "+i);
			
			for(int j=0; j<totalCells; j++) {
				
				XSSFCell currCell = currRow.createCell(j);
				currCell.setCellValue(sc.next());
			}
		}
		
		System.out.println("created..");
		
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
