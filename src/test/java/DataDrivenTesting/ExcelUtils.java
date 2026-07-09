package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wBk;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String excelFile, String excelSheet) throws IOException {
		
		fi = new FileInputStream(excelFile);
		wBk = new XSSFWorkbook(fi);
		
		wSheet = wBk.getSheet(excelSheet);
		int rowCount = wSheet.getLastRowNum();
		
		wBk.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String excelFile, String excelSheet, int rowNum) throws IOException {
		
		fi = new FileInputStream(excelFile);
		wBk = new XSSFWorkbook(fi);
		wSheet = wBk.getSheet(excelSheet);
		
		row = wSheet.getRow(rowNum);
		int totalCells = row.getLastCellNum();
		
		wBk.close();
		fi.close();
		return totalCells;
	}
	
	public static String getCellData(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException {
		
		fi = new FileInputStream(excelFile);
		wBk = new XSSFWorkbook(fi);
		wSheet = wBk.getSheet(excelSheet);
		row = wSheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		String data;
		try {
			//data = cell.toString();		//same this can be done as follows
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);	//returns the formatted cell value as string regadless of cell type
		}catch(Exception e) {
			data = "";
		}
		
		wBk.close();
		fi.close();
		return data;
	}
	
	
	public static void setCellValue(String excelFile, String excelSheet, int rowNum, int cellNum, String data) throws IOException {
		fi = new FileInputStream(excelFile);	
		wBk = new XSSFWorkbook(fi);
		wSheet = wBk.getSheet(excelSheet);
		
		row = wSheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		if (cell == null) {
	        cell = row.createCell(cellNum);
	    }
		cell.setCellValue(data);
		
		fo = new FileOutputStream(excelFile);	//we need to write it in the file
		wBk.write(fo);
		wBk.close();
		fi.close();
		fo.close();
	}
	
	public static void fillGreenColor(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException{
		fi = new FileInputStream(excelFile);	
		wBk = new XSSFWorkbook(fi);
		wSheet = wBk.getSheet(excelSheet);
		
		row = wSheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		style=wBk.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(excelFile);	
		wBk.write(fo);
		wBk.close();
		fi.close();
		fo.close();
	}

	
	public static void fillRedColor(String excelFile, String excelSheet, int rowNum, int cellNum) throws IOException{
		fi = new FileInputStream(excelFile);	
		wBk = new XSSFWorkbook(fi);
		wSheet = wBk.getSheet(excelSheet);
		
		row = wSheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		style=wBk.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(excelFile);	
		wBk.write(fo);
		wBk.close();
		fi.close();
		fo.close();
	}
}
