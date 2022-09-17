package com.testvagrant.actions;

import org.testng.annotations.Test;

import com.testvagrant.page.MovieDetailsInWiki;

public class RunTestInWiki extends BaseTest {
	@Test
	public void movieDetailsInWiki() throws InterruptedException {
		MovieDetailsInWiki wiki=new MovieDetailsInWiki(driver);
		wiki.movieDetailsPage(driver);
		String releaseDate=wiki.getMovieReleaseDate(driver);
		String country=wiki.getMovieReleaseCountry(driver);				
		lst.add(releaseDate);
		lst.add(country);
	}
}
