package com.stockbrokerreport.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;


import com.stockbrokerreports.utility.ExcelReports;
import com.stockbrokerreports.utility.Initialize;

public class McBrokerReportTest {
	public static Initialize initialize;
	public static WebDriver driver;
	public static ExcelReports excelReports;
	
	@BeforeTest
	public static void initialize() {
		try {
			initialize = new Initialize();
			driver=initialize.Initializedriver("URL2");	
		
			excelReports = new ExcelReports(driver);
						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void validateHomePage() {
		
	}
	

}
