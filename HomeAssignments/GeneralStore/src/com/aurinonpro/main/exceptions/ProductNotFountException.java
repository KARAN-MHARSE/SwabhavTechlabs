package com.aurinonpro.main.exceptions;

public class ProductNotFountException extends RuntimeException {
	public ProductNotFountException() {
		super("Product not found");
	}

	public ProductNotFountException(int productId) {
		super("Product not found with id " + productId);

	}
}
