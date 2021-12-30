package com.stockbrokerreports.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Initialize {
		
		public static  WebDriver driver;
		
		public static WebDriver Initializedriver(String url) throws IOException {
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.get(BasicActions.getProperties(url));
			driver.manage().window().maximize();
			return driver;

		}

}
