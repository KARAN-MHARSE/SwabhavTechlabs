package com.aurinonpro.main.exceptions;

public class CustomerNotFoundException  extends RuntimeException {

	public CustomerNotFoundException() {
		super("Customer not found");
	}
}
