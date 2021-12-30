package com.stockbrokerreports.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;



public class ExcelReports {
	public static WebDriver driver;

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	public static FileInputStream fis;

	public static String path = System.getProperty("user.dir") + "\\ExcelReports\\BrokerReport_"
			+ BasicActions.getdatetime() + ".xlsx";

	public  ExcelReports(WebDriver driver) throws IOException {
		this.driver=driver;
	}

	public void createExcel(String sheetname, int rownum, int colNum, String value)
			throws IOException, InvalidFormatException {

		File file = new File(path);
		if (!file.exists()) {
			wb = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			wb.write(fos);
		}

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

		if (wb.getSheetIndex(sheetname) == -1) {
			wb.createSheet(sheetname);
		}
		sheet = wb.getSheet(sheetname);

		if (sheet.getRow(rownum) == null)
			sheet.createRow(rownum);

		row = sheet.getRow(rownum);
		cell = row.createCell(colNum);
		cell.setCellValue(value);
		fos = new FileOutputStream(path);

		wb.write(fos);
		wb.close();

		fis.close();
		fos.close();

	}

	public static void setExcel() throws IOException {

		wb.write(fos);
		wb.close();
		fos.close();
	}

}
