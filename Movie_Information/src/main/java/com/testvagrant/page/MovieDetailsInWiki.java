package com.testvagrant.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagrant.util.AutoUtil;
import com.testvagrant.util.IAutoConst;

public class MovieDetailsInWiki implements IAutoConst {

	@FindBy(id="searchInput")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[@class='highlight']")
	private WebElement searchResult;
	
	@FindBy(xpath ="//*[text()='Release date']")
	private WebElement movieDetail;
	
	@FindBy(xpath ="//*[text()='Release date']/../..//*[@class='plainlist']")
	private WebElement releaseDate;
	
	@FindBy(xpath="//*[text()='Country']/..//*[@class='infobox-data']")
	private WebElement country;
	
	public MovieDetailsInWiki(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void movieDetailsPage(WebDriver driver) {
		searchBox.sendKeys(AutoUtil.getProperty(CONFIG_PATH, "MOVIE_NAME"));
		searchResult.click();
		AutoUtil.scrollPageTillElement(driver, movieDetail);
	}
	
	public String getMovieReleaseDate(WebDriver driver) {
		String reldate="";
		reldate = releaseDate.getText();
		return reldate;
	}
	
	public String getMovieReleaseCountry(WebDriver driver) {
		String releaseCountry="";
		releaseCountry=country.getText();
		return releaseCountry;
	}

}
