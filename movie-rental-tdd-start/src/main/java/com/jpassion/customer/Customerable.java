package com.jpassion.customer;

import com.jpassion.examples.Rental;

public interface Customerable {

	public abstract void addRental(Rental rental);

	public abstract String generateRentalStatement();

}