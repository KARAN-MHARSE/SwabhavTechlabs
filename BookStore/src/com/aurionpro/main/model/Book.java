package com.aurionpro.main.model;

import java.time.LocalDate;

import com.aurionpro.main.exceptions.BookAlreadyIssuedException;
import com.aurionpro.main.exceptions.InvalidBookDetailsException;
import com.aurionpro.main.exceptions.UserNotFoundException;

public class Book implements Comparable<Book> {
	private int bookId;
	private String bookName;
	private String author;
	private boolean isIssued;
	private User issuedTo;
	private LocalDate issuedDate;
	private static int count = 0;

	public Book() {
		throw new InvalidBookDetailsException("All fields are required");
	}

	public Book(String bookName, String author) {
		if (bookName== null || author==null || bookName.isBlank() || author.isBlank())
			throw new InvalidBookDetailsException();
		this.bookName = bookName;
		this.author = author;
		this.bookId = 100+count;
		count++;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean getIsIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public User getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(User issuedTo) {
		this.issuedTo = issuedTo;
	}

	public LocalDate getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}

	public void issueBook(User user) {
		if (isIssued)
			throw new BookAlreadyIssuedException();

		this.issuedTo = user;
		this.isIssued = true;
		this.issuedDate = LocalDate.now();
		
	}

	public void returnBook(User user) {
		if (!isIssued || !issuedTo.equals(user))
			throw new RuntimeException("Cannot return: Book not issued or wrong user.");

		this.issuedTo = null;
		this.isIssued = false;
		this.issuedDate = null;
	}

	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + "]";
	}

	@Override
	public int compareTo(Book book) {
		return this.bookId-book.getBookId();
	}
}
