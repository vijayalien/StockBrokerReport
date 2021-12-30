package com.stockbrokerreports.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrendlynBrokerReportsPage {
	public   WebDriver driver;
	
	private By modalButton = By.xpath("//button[@class='close']");
	private By reportsCollapse = By.xpath("//a[@aria-controls='reportsCollapsingNavbar']");
	private By buyButton = By.xpath("//body[1]/div[3]/div[1]/ul[1]/li[4]/a[1]");
	private By brokerTableHeader = By.xpath("//table[@id='brokerTable']/thead/tr/th");
	private By stockReportTitle = By.xpath("//div[@class='m-l-1 pl05rem report-head-title']");
	private By totalReportTableRows = By.xpath("//tbody[@id='allreportsbody']/tr");
	private By expandTab = By.xpath("//body[1]/div[3]/div[2]/div[4]/div[1]/div[5]/div[3]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[11]");
	
	
	public TrendlynBrokerReportsPage(WebDriver driver) {
		 this.driver=driver;
		}

	public WebElement reportCollapseButton() {
		return driver.findElement(reportsCollapse);
	}
	
	public WebElement buyButton() {
		return driver.findElement(buyButton);
	}
	
	public List<WebElement> tableHeader(){
		return driver.findElements(brokerTableHeader);
	}
	
	public WebElement modalButton() {
		return driver.findElement(modalButton);
	}
	
	public WebElement stockReportMainTitle() {
		return driver.findElement(stockReportTitle);
	}
	
	public List<WebElement> totalReportRows() {
		return driver.findElements(totalReportTableRows);
	}
	
	public WebElement expandTabButton() {
		return driver.findElement(expandTab);
	}
}
