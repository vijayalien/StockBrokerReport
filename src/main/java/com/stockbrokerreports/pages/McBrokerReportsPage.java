package com.stockbrokerreports.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class McBrokerReportsPage {

	public   WebDriver driver;
	
	private By marketsTitle = By.xpath("//body[1]/div[1]/header[1]/div[1]/div[3]/nav[1]/div[1]/ul[1]/li[3]/a[1]");
	
	public McBrokerReportsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement validateMarkettitle() {
		return driver.findElement(marketsTitle);
	}
}
