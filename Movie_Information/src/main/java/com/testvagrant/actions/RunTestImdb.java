package com.testvagrant.actions;

import org.testng.annotations.Test;

import com.testvagrant.page.MovieDetailsInIMDB;

public class RunTestImdb extends BaseTest{
	@Test
	public void movieDetailsInImdb() throws InterruptedException {		
		UIPageActions actions=new UIPageActions();
		MovieDetailsInIMDB imdb=new MovieDetailsInIMDB(driver);
		imdb.movieDetailsPage(driver);
		String relDate=imdb.getMovieReleaseDate(driver);
		String releaseDate=actions.splitString(relDate);
		String country=imdb.getMovieReleaseCountry(driver);			
		lst.add(releaseDate);
		lst.add(country);
	}	
}