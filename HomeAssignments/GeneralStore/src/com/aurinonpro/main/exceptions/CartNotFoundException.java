package com.aurinonpro.main.exceptions;

public class CartNotFoundException extends RuntimeException {

	public CartNotFoundException() {
		super("Cart not found");
	}
}
