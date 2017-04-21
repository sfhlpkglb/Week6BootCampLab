package com.jpassion.movie;


public class NewReleaseMovieCustomerPoints implements CustomerPointsCalculateable {

	private int DAILY_POINTS = 3;
			
	@Override
	public int calclateCustomerBonus(int rentalLengthDays) {
		 
		return rentalLengthDays * DAILY_POINTS;
	}

}
