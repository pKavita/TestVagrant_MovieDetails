package com.testvagrant.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoUtil {

	public static void scrollPageTillElement(WebDriver driver, WebElement ele) {
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getPhoto(WebDriver driver, String folder) {
		String path="";
		try {
			String d=new Date().toString();
			String dateTime=d.replace(";", "-");
			path=folder+dateTime+".png";
			TakesScreenshot t=(TakesScreenshot) driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(path));			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getProperty(String path, String key) {
		String v="";
		try {
			Properties p= new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
}
