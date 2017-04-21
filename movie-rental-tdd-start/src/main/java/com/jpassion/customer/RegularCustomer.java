package com.jpassion.customer;

import java.util.ArrayList;
import java.util.List;

import com.jpassion.examples.Rental;
import com.jpassion.movie.Movie;

public class RegularCustomer implements Customerable {

	private String name;
	private List<Rental> rentals = new ArrayList<>();

	private int BONUS_CUSTOMER_POINTS_FACTOR = 5;
	private double BONUS_CUSTOMER_AMOUNT = 0.30;
	
	public RegularCustomer(String name) {
		this.name = name; 
	}

	/* (non-Javadoc)
	 * @see com.jpassion.examples.Customerable#addRental(com.jpassion.examples.Rental)
	 */
	@Override
	public void addRental(Rental rental) {
		rentals.add(rental);		
	}
	
	/* (non-Javadoc)
	 * @see com.jpassion.examples.Customerable#generateRentalStatement()
	 */
	@Override
	public String generateRentalStatement(){
		StringBuilder sb = new StringBuilder(generateStatementHeader());
		sb.append(generateStatementDetail());
		sb.append(generateRentalTotal());
		sb.append(generateCustomerPoints());
		sb.append(generateBonusAmount());
		sb.append(generateStatementTotal());
		
		return sb.toString();
	}
	
	String getName(){
		return name;
	}

	private Object generateStatementTotal() {
		// calculateTotalRentalAmount()
		return "Statement total is: " + String.format("%.2f", ((calculateTotalRentalAmount()) - (calculateCustomerPoints()/BONUS_CUSTOMER_POINTS_FACTOR) * BONUS_CUSTOMER_AMOUNT));
	}

	private Object generateBonusAmount() {
		return "Customer earned bonus is: " + String.format("%.2f", ((calculateCustomerPoints()/BONUS_CUSTOMER_POINTS_FACTOR) * BONUS_CUSTOMER_AMOUNT)) + "\n";
	}

	private Object generateCustomerPoints() {
		return "Customer points: " + calculateCustomerPoints() + "\n"; 
	}

	private int calculateCustomerPoints() {
		int totalCustomerPoints = 0;
		
		for (Rental rental : rentals) {
			totalCustomerPoints += rental.calculateCustomerPoints(rental.getNumberOfDaysRented());

		}
		return totalCustomerPoints;
	}

	private String generateRentalTotal() {
		return "Rental before customer points: " + String.format("%.2f", calculateTotalRentalAmount()) + "\n"; 
	}

	private double calculateTotalRentalAmount() {
		double totalRentalPrice = 0.00;
		
		for (Rental rental : rentals) {
			totalRentalPrice += rental.calculateMovieRental(rental.getNumberOfDaysRented());
		}
		return totalRentalPrice;
	}
		

	private Object generateStatementDetail() {
		StringBuilder sb = new StringBuilder();
		
		for (Rental rental : rentals) {
			Movie movie = rental.getMovie();
			sb.append(movie.getTitle() + "\n");
		}
		return sb.toString();
	}

	private String generateStatementHeader() {
		return getName() + " Number of rentals is: " + rentals.size() + "\n";
	}

}
