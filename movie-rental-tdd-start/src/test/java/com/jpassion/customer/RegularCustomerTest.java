package com.jpassion.customer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jpassion.customer.CustomerFactory;
import com.jpassion.customer.CustomerType;
import com.jpassion.customer.Customerable;
import com.jpassion.examples.Rental;
import com.jpassion.movie.ChildrenMovieCustomerPoints;
import com.jpassion.movie.ChildrenMovieRental;
import com.jpassion.movie.CustomerPointsCalculateable;
import com.jpassion.movie.Movie;
import com.jpassion.movie.MovieRentalCalculateable;
import com.jpassion.movie.MovieType;
import com.jpassion.movie.NewReleaseMovieCustomerPoints;
import com.jpassion.movie.NewReleaseMovieRental;
import com.jpassion.movie.RegularMovieCustomerPoints;
import com.jpassion.movie.RegularMovieRental;

public class RegularCustomerTest {
	
	CustomerFactory customerFactory = new CustomerFactory();
	Customerable customer;
	
	MovieRentalCalculateable rental_Regular_Movie = new RegularMovieRental();
	CustomerPointsCalculateable customer_Points_Regular_Movie = new RegularMovieCustomerPoints();
	MovieRentalCalculateable rental_Children_Movie = new ChildrenMovieRental();
	CustomerPointsCalculateable customer_Points_Children_Movie = new ChildrenMovieCustomerPoints();
	MovieRentalCalculateable rental_NewRelease_Movie = new NewReleaseMovieRental();
	CustomerPointsCalculateable customer_Points_NewRealease_Movie = new NewReleaseMovieCustomerPoints();
	
	@Before
	public void setup(){
		customer = customerFactory.getCustomer(CustomerType.REGULAR, "Test Name");
	}
	
	@Test
	public void should_Be_Customer_With_One_Rental() throws Exception {
		
		customer.addRental(new Rental(new Movie("Movie 1", MovieType.MOVIE_REGULAR),5, rental_Regular_Movie, customer_Points_Regular_Movie));
		
		String expected = "Test Name Number of rentals is: 1\nMovie 1\nRental before customer points: 10.00\nCustomer points: 5\nCustomer earned bonus is: 0.30\nStatement total is: 9.70";
		assertThat(customer.generateRentalStatement(), equalTo(expected));
		
	}
	
	@Test
	public void should_Be_Customer_With_Three_Rental() throws Exception {
		
		customer.addRental(new Rental(new Movie("Movie 1", MovieType.MOVIE_REGULAR),5, rental_Regular_Movie, customer_Points_Regular_Movie));
		customer.addRental(new Rental(new Movie("Movie 2", MovieType.MOVIE_CHILDREN),10, rental_Children_Movie, customer_Points_Children_Movie));
		customer.addRental(new Rental(new Movie("Movie 3", MovieType.MOVIE_NEW_RELEASE),4, rental_NewRelease_Movie, customer_Points_NewRealease_Movie));
		String expected = "Test Name Number of rentals is: 3\nMovie 1\nMovie 2\nMovie 3\nRental before customer points: 38.00\nCustomer points: 34\nCustomer earned bonus is: 1.80\nStatement total is: 36.20";
		assertThat(customer.generateRentalStatement(), equalTo(expected));
		
	}
	
}
