package gettingStarted3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel {

	public static void writingDataDemo() throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myFile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("java");
		row1.createCell(1).setCellValue(19);
		row1.createCell(2).setCellValue("automation");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("python");
		row2.createCell(1).setCellValue(14);
		row2.createCell(2).setCellValue("automation");
		
		XSSFRow row3 = sheet.createRow(2);
		row2.createCell(0).setCellValue("C");
		row2.createCell(1).setCellValue(16);
		row2.createCell(2).setCellValue("automation");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("file created....");
	}
}
