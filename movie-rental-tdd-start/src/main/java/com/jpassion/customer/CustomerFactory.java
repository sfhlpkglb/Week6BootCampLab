package com.jpassion.customer;


public class CustomerFactory {
	
	public CustomerFactory(){
	}

	public Customerable getCustomer(CustomerType customerType, String name) {

		Customerable customerable = null;
		
		switch (customerType) {
		case REGULAR:
				customerable = new RegularCustomer(name);
			break;

		default:
			break;
		}
		return customerable;
	}
	
}
