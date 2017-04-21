package com.jpassion.movie;


public class ChildrenMovieCustomerPoints implements CustomerPointsCalculateable {

	private int DAILY_POINTS = 1;
	private int BONUS_DAYS = 3;
	private int BONUS_DAILY_POINTS = 2;
			
	@Override
	public int calclateCustomerBonus(int rentalLengthDays) {
		
		int bonusDays = (rentalLengthDays > BONUS_DAYS)?(rentalLengthDays - BONUS_DAYS):0;
		int primaryDays = (bonusDays > 0)?BONUS_DAYS:rentalLengthDays;
		return (bonusDays * BONUS_DAILY_POINTS) + (primaryDays * DAILY_POINTS);
	}

}
