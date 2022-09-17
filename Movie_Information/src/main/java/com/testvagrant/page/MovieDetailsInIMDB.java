package com.testvagrant.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagrant.util.AutoUtil;
import com.testvagrant.util.IAutoConst;

public class MovieDetailsInIMDB implements IAutoConst {
	
	@FindBy(id="suggestion-search")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[@class='sc-d2740ffb-2 STkQo searchResult__constTitle']")
	private WebElement searchResult;
	
	@FindBy(xpath ="//*[text()='Details']")
	private WebElement movieDetail;
	
	@FindBy(xpath = "//*[text()='Release date']/..//*[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link']")
	private WebElement releaseDate;
	
	@FindBy(xpath="//*[text()='Country of origin']/..//*[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link']")
	private WebElement country;
	
	public MovieDetailsInIMDB(WebDriver driver) {
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
