package com.aurionpro.bms.exceptions;

public class InsufficientBalanceException extends RuntimeException {
	public InsufficientBalanceException() {
		super("Insufficient balance");
	}
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
