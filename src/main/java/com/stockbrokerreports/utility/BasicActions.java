package com.stockbrokerreports.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class BasicActions {
	
	public static String currentDate;
	public static String proppath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\stockbrokerreports\\resources\\ImpResource.properties";

	public static  String getProperties(String value) throws IOException {

		FileInputStream fis= new FileInputStream(proppath);
		Properties prop= new Properties();
		prop.load(fis);
		String propkey=prop.getProperty(value);
		return propkey;
	}
	
	public static String getdatetime() {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss");
			Date date = Calendar.getInstance().getTime();
			currentDate = dateFormat.format(date);

			return currentDate;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
