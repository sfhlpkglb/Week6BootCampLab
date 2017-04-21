package com.jpassion.movie;


public class RegularMovieCustomerPoints implements CustomerPointsCalculateable {

	private int DAILY_POINTS = 1;
			
	@Override
	public int calclateCustomerBonus(int rentalLengthDays) {
		 
		return rentalLengthDays * DAILY_POINTS;
	}

}
