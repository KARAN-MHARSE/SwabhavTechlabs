package com.aurionpro.foodify.exceptions;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException() {
		System.out.println("Order not found");
	}

	public OrderNotFoundException(UUID id) {
		System.out.println("Order not found of id " + id);
	}
}
