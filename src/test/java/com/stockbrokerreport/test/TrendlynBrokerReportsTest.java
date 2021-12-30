package com.stockbrokerreport.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.stockbrokerreports.pages.TrendlynBrokerReportsPage;
import com.stockbrokerreports.utility.ExcelReports;
import com.stockbrokerreports.utility.Initialize;



public class TrendlynBrokerReportsTest {
	
	public static Initialize initialize;
	public static WebDriver driver;
	public static TrendlynBrokerReportsPage trendlynBrokerPage;
	public static ExcelReports excelReports;
	
	@BeforeTest
	public static void initialize() {
		try {
			initialize = new Initialize();
			driver=initialize.Initializedriver("URL1");	
			trendlynBrokerPage=new TrendlynBrokerReportsPage(driver);
			excelReports = new ExcelReports(driver);
						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public static void trendlynReport() throws InvalidFormatException, IOException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30); // you can reuse this one

		WebElement modalButton = trendlynBrokerPage.modalButton();
		wait.until(ExpectedConditions.visibilityOf(modalButton));
		modalButton.click();
		
		trendlynBrokerPage.reportCollapseButton().click();
		
		Awaitility.await().timeout(5,TimeUnit.SECONDS).untilAsserted(()->Assert.assertEquals(trendlynBrokerPage.stockReportMainTitle().isDisplayed(), true));
		trendlynBrokerPage.buyButton().click();
				
		//int headerSize = trendlynBrokerPage.tableHeader().size();
		int titleCol = 0;
		for(WebElement reportTitle : trendlynBrokerPage.tableHeader()) {
			String title = reportTitle.getText();
			System.out.println( "The title is :" +title);
			excelReports.createExcel("Trendlyn Reports", 0, titleCol, title);
			titleCol++;
		}
		
		Awaitility.await().timeout(5,TimeUnit.SECONDS).untilAsserted(()->Assert.assertEquals(trendlynBrokerPage.expandTabButton().isDisplayed(),true));				
		trendlynBrokerPage.expandTabButton().click();
			
		int totalTableRows = trendlynBrokerPage.totalReportRows().size();
		System.out.println("Total number of reports rows are :"+totalTableRows);
				
		String firstpart= "//tbody[@id='allreportsbody']/tr[";
		String secondpart="]/td[";
		String thirdpart="]";
		for(int i=1;i<=totalTableRows-1;) {
			for(int j=1;j<=9;j++) {
				String finalpart =firstpart+i+secondpart+j+thirdpart;
				String txt=driver.findElement(By.xpath(finalpart)).getText();
				System.out.println(txt);
				excelReports.createExcel("Trendlyn Reports", i, j-1, txt);
							
			}i++;
		}
	
	}
	
	@AfterTest
	public static void closeBrowser() {
		driver.close();
		
	}

}
