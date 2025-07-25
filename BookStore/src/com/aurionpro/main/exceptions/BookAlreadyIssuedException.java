package com.aurionpro.main.exceptions;

import com.aurionpro.main.model.Book;

public class BookAlreadyIssuedException extends RuntimeException {

	public BookAlreadyIssuedException() {
		super("Sorry, Book is already issued to someone else");
	}
}
