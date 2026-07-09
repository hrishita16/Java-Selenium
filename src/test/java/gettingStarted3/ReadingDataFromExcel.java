package gettingStarted3;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File --- >Workbook --- >Sheets --- >Rows ---- Cells
public class ReadingDataFromExcel {
	
	public static void readData() throws IOException {
		
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("total rows: "+totalRows);
		System.out.println("total cells/cols: "+totalCells);
		
		/* note: in excel --> rows start from 0 and cells start from 1
		 		 in java --> rows and cells both start from 0
		*/
		for(int i=0;i<=totalRows;i++) {
			
			XSSFRow currRow =  sheet.getRow(i);
			for(int j=0;j<totalCells;j++) {	//as in excel, cells are counted from 1, but here we start from 0, hence we write j<totalCells
				XSSFCell cell = currRow.getCell(j);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
		
	}
}

/*
 * FileInputStream - reading 
 * FileOutputStream - writing
 * XSSFWorkbook - workbook 
 * XSSFSheet - sheet 
 * XSSFROw - row 
 * XSSFCe11 - cell
 */