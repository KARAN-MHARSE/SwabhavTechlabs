package com.aurionpro.main.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.main.exceptions.CustomException;
import com.aurionpro.main.model.Book;
import com.aurionpro.main.model.User;
import com.aurionpro.main.services.LibraryServices;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		List<Book> books = new ArrayList<>(Arrays.asList(new Book("Masters java", "John snow"),
				new Book("Advaanced Sql", "Binod Bhaiyya"), new Book("Cricket with stars", "Virat Kohli"),
				new Book("Web developement with SRK", "Sharukh Khan")));

		List<User> users = new ArrayList<User>(Arrays.asList(new User("Karan")));

		boolean isContinued = true;
		while (isContinued) {
			System.out.println(
					"Choose the choice code: \n1.Create user account \n2.Add a new book \n3.Display all books \n4.Display all issued books \n5.Issue book \n6.Return a book \n7.Sort Books \n8.Exit");
			int choice = scanner.nextInt();

			try {
				switch (choice) {
				case 1:
					createNewUser(scanner, users);
					break;
				case 2:
					addNewBook(scanner, books);
					break;
				case 3:
					displayAllBooks(books);
					break;
				case 4:
					displayIssuedBooks(books);
					break;
				case 5:
					issueBook(scanner, users, books);
					break;
				case 6:
					returnBook(scanner, users, books);
					break;
				case 7:
					sortBooks(scanner, books);
					break;
				case 8:
					System.out.println("Thank you for visiting.");
					isContinued = false;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}

		}
	}

	public static User findUser(List<User> users, int userId) {
		return users.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(null);
	}

	public static Book findBook(List<Book> books, int bookId) {
		return books.stream().filter(book -> book.getBookId() == bookId).findFirst().orElse(null);
	}

	public static void createNewUser(Scanner scanner, List<User> users) {
		System.out.println("Enter the user name");
		String userName = scanner.next();
		if (userName == null || userName.isEmpty())
			throw new RuntimeException("Wrong userName");
		User user = new User(userName);
		users.add(user);
		System.out.println("User successfully created with user id " + user.getUserId());
	}

	public static void addNewBook(Scanner scanner, List<Book> books) {
		System.out.println("Enter the Book name");
		String bookName = scanner.next();
		System.out.println("Enter the Author name");
		String authorName = scanner.next();

		if (bookName == null || authorName == null || bookName.isEmpty() || authorName.isEmpty())
			throw new RuntimeException("Wrong book details");
		Book book = new Book(bookName, authorName);
		books.add(book);
		System.out.println("Book successfully created.");

	}

	public static void displayAllBooks(List<Book> books) {
		if (books.isEmpty())
			throw new CustomException("No books found");
		books.forEach(System.out::println);
	}

	private static void displayIssuedBooks(List<Book> books) {
		int count = 0;
		for (Book book : books) {
			if (book.getIsIssued()) {
				System.out.println(book);
				count++;
			}
		}
		if (count == 0)
			System.out.println("No issued books available");

	}

	private static void issueBook(Scanner scanner, List<User> users, List<Book> books) {
		System.out.println("Enter yout user id");
		int userId = scanner.nextInt();

		User currentUser = findUser(users, userId);
		if (currentUser == null)
			throw new CustomException("No such user found");
		System.out.println("Here is the list of available books:");
		books.stream().filter(book -> !book.getIsIssued()).forEach(System.out::println);
		System.out.println("Enter the book id");
		int bookId = scanner.nextInt();

		Book requiredBook = findBook(books, bookId);

		if (requiredBook == null)
			throw new CustomException("Wrong book id, sorry try again");
		requiredBook.issueBook(currentUser);
		currentUser.issueBook(requiredBook);
//		currentUser.getBooks().add(requiredBook);
		System.out.println("Book issued succesfully.");

	}

	private static void returnBook(Scanner scanner, List<User> users, List<Book> books) {
		System.out.println("Enter your user id");
		int userId = scanner.nextInt();
		System.out.println("Here is the list of books that you issued:");
		books.stream().filter(book -> book.getIsIssued() && book.getIssuedTo().getUserId() == userId).forEach(System.out::println);
		System.out.println("Enter the book id that you want to return");
		int bookId = scanner.nextInt();

		User user = findUser(users, userId);
		if (user == null)
			throw new CustomException("No such user found");

		Book bookToReturn = null;
		bookToReturn = findBook(books, bookId);
//		for (Book book : user.getBooks()) {
//			if (book.getBookId() == bookId) {
//				bookToReturn = book;
//			}
//		}

		if (bookToReturn == null)
			throw new CustomException("Book not found with id " + bookId);

		bookToReturn.returnBook(user);
		user.returnBook(bookToReturn);
//		user.getBooks().remove(bookToReturn);
		System.out.println("Book suucessfully return");

	}

	private static void sortBooks(Scanner scanner, List<Book> books) {
		Collections.sort(books);
		System.out.println("To see sorted books choose option 3");

	}

}
