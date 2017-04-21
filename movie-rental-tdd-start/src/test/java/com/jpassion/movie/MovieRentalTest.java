package com.jpassion.movie;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class MovieRentalTest {

	@Test
	public void should_Calculate_Regular_Movie_Rental() throws Exception {
		
		MovieRentalCalculateable movieRentalCalculateable = new RegularMovieRental();
		
		assertThat(movieRentalCalculateable.calculateMovieRental(10), closeTo(25.00,.001));
		assertThat(movieRentalCalculateable.calculateMovieRental(5), closeTo(10.00,.001));
		assertThat(movieRentalCalculateable.calculateMovieRental(3), closeTo(6.00,.001));
	}
	
	@Test
	public void should_Calculate_New_Release_Movie_Rental() throws Exception {
		
		MovieRentalCalculateable movieRentalCalculateable = new NewReleaseMovieRental();
		
		assertThat(movieRentalCalculateable.calculateMovieRental(10), closeTo(51.00,.001));
		assertThat(movieRentalCalculateable.calculateMovieRental(5), closeTo(21.00,.001));
		assertThat(movieRentalCalculateable.calculateMovieRental(3), closeTo(9.00,.001));
	}
	
	@Test
	public void should_Calculate_Childrens_Movie_Rental() throws Exception {
		
		MovieRentalCalculateable movieRentalCalculateable = new ChildrenMovieRental();
		
		assertThat(movieRentalCalculateable.calculateMovieRental(10), closeTo(13.00,.001));
		assertThat(movieRentalCalculateable.calculateMovieRental(7), closeTo(7.00,.001));
		assertThat(movieRentalCalculateable.calculateMovieRental(3), closeTo(3.00,.001));
	}
}
