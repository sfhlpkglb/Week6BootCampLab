package com.jpassion.examples;

import com.jpassion.movie.CustomerPointsCalculateable;
import com.jpassion.movie.Movie;
import com.jpassion.movie.MovieRentalCalculateable;

public class Rental {

	private int numberOfDaysRented;
	private Movie movie;
	private MovieRentalCalculateable movieRentalCalculateable;
	CustomerPointsCalculateable customerPointsCalculateable;
	
	public Rental(Movie movie, int numberOfDaysRented, MovieRentalCalculateable movieRentalCalculateable, CustomerPointsCalculateable customerPointsCalculateable) {
		this.movie = movie;
		this.numberOfDaysRented = numberOfDaysRented;
		this.movieRentalCalculateable = movieRentalCalculateable;
		this.customerPointsCalculateable = customerPointsCalculateable;
	}
	
	
	
	public int getNumberOfDaysRented() {
		return numberOfDaysRented;
	}



	public Movie getMovie() {
		return movie;
	}



	public MovieRentalCalculateable getMovieRentalCalculateable() {
		return movieRentalCalculateable;
	}



	private CustomerPointsCalculateable getCustomerPointsCalculateable() {
		return customerPointsCalculateable;
	}



	public double calculateMovieRental(int numberOfDaysRented){
		return movieRentalCalculateable.calculateMovieRental(numberOfDaysRented);
	}
	
	public int calculateCustomerPoints(int numberOfDaysRented){
		return customerPointsCalculateable.calclateCustomerBonus(numberOfDaysRented);
	}
	
}
