package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static Workbook wb;
	static Sheet sheet;
	
	//load excel file
	public static void setExcelFile(String path, String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);	
	}
	
	//get cell data as string
	public static String getCellData(int rowNum, int colNum) {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		return cell.toString();
	}
	
	//get total rows
	public static int getRowCount() {
		return sheet.getLastRowNum() + 1;
	}

	

}
