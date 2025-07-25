package com.aurinonpro.main.exceptions;

public class OrderNotFoundException extends RuntimeException{

	public OrderNotFoundException() {
		super("Order not found");
	}
}
