package com.testvagrant.actions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.testvagrant.util.IAutoConst;

public class BaseTest implements IAutoConst {
	
	ArrayList<String> lst=new ArrayList<String>();
	static ArrayList<String> lst2 = new ArrayList<String>();
	
	public WebDriver driver;
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);		
	}	
		
	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	@Parameters("URL")
	public void launchBrowser(String url) {
		driver=new ChromeDriver();
		String URL=url;
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void apps(ITestResult testResult) {
		lst2.addAll(lst);
		driver.quit();
	}

	@AfterSuite
	public void validateResult() {
		String movieReleaseDateInImdb=lst2.get(0);
		String movieReleasedCountryInImdb=lst2.get(1);
		String movieReleaseDateInWiki=lst2.get(2);
		String movieReleasedCountryInWiki=lst2.get(3); 
		
		SoftAssert asrt=new SoftAssert();
		asrt.assertEquals(movieReleaseDateInImdb, movieReleaseDateInWiki);
		asrt.assertEquals(movieReleasedCountryInImdb, movieReleasedCountryInWiki);
		asrt.assertAll();
	}
}
