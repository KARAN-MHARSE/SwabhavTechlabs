package com.aurionpro.main.exceptions;

public class MovieNotFoundException extends RuntimeException {
	public MovieNotFoundException() {
		super("Movie not found");
	}
}
