package com.aurionpro.main.model;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.main.exceptions.CustomException;

public class User {
	private int userId;
	private String userName;
	private List<Book> books;
	private static int count =0;
	
	
	public User(String userName) {
		if (userName==null || userName.isBlank()) throw new CustomException("username is required");
		this.userName = userName;
		this.userId = 200+count;
		this.books = new ArrayList<>();
		count++;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	public List<Book> getBooks() {
		return books;
	}
	
	public void issueBook(Book book) {
        books.add(book);
    }

    public void returnBook(Book book) {
        books.remove(book);
    }

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	
	
	
	

}
