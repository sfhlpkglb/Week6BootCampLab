package com.jpassion.movie;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerPointsTest {

	@Test
	public void should_Calculate_Regular_Movie_Custome_Points() throws Exception {
		
		CustomerPointsCalculateable customerPointsCalculateable = new RegularMovieCustomerPoints();
		
		assertThat(customerPointsCalculateable.calclateCustomerBonus(10), equalTo(10));
		assertThat(customerPointsCalculateable.calclateCustomerBonus(5), equalTo(5));
		assertThat(customerPointsCalculateable.calclateCustomerBonus(3), equalTo(3));
	}
	
	@Test
	public void should_Calculate_New_Release_Movie_Customer_Points() throws Exception {
		
		CustomerPointsCalculateable customerPointsCalculateable = new NewReleaseMovieCustomerPoints();
		
		assertThat(customerPointsCalculateable.calclateCustomerBonus(10), equalTo(30));
		assertThat(customerPointsCalculateable.calclateCustomerBonus(5), equalTo(15));
		assertThat(customerPointsCalculateable.calclateCustomerBonus(3), equalTo(9));
	}
	
	@Test
	public void should_Calculate_Childrens_Movie_Customer_Points() throws Exception {
		
		CustomerPointsCalculateable customerPointsCalculateable = new ChildrenMovieCustomerPoints();
		
		assertThat(customerPointsCalculateable.calclateCustomerBonus(10), equalTo(17));
		assertThat(customerPointsCalculateable.calclateCustomerBonus(7), equalTo(11));
		assertThat(customerPointsCalculateable.calclateCustomerBonus(3), equalTo(3));
	}
}
