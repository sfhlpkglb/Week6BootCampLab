package com.jpassion.movie;


public class ChildrenMovieRental implements MovieRentalCalculateable {
	
	private double FIRST_TIME_PERIOD_RATE = 1.00;
	private int FIRST_TIME_PERIOD_MAX_DAYS = 7;
	private double ADDITIONAL_DAYS_RATE = 2.00;
	
			/*
			 *    	-Children's movie - $1 per day for the first 7 days and $2 after that
		   	-Regular movie - $2 per day for the first 5 days and $3 after that
		   	-New release - $3 per day for the first 3 days, $6 dollars after that
			 */		

	@Override
	public double calculateMovieRental(int rentalLengthDays) {
		int additionalDays = (rentalLengthDays > FIRST_TIME_PERIOD_MAX_DAYS)?(rentalLengthDays - FIRST_TIME_PERIOD_MAX_DAYS):0;
		int primaryDays = (additionalDays > 0)?FIRST_TIME_PERIOD_MAX_DAYS:rentalLengthDays;
		return (additionalDays * ADDITIONAL_DAYS_RATE) + (primaryDays * FIRST_TIME_PERIOD_RATE);
	}

}
