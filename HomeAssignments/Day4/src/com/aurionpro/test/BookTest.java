package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;

import com.aurionpro.model.Book;

public class BookTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome into book store");

		Book[] books = new Book[10];
		int booksCount = 0;
		createStoreFiveBook(books);
		booksCount = 5;
		printAllBooks(books, 5);

		boolean isBookCreated = createAndStoreBook(scanner, books, booksCount);
		if (isBookCreated) {
			booksCount++;
			printAllBooks(books, booksCount);
		}

		sortBooksStore(scanner, books, booksCount);
		printAllBooks(books, booksCount);

	}

	private static void createStoreFiveBook(Book[] books) {
		books[0] = new Book("B101", "Masters java", "Karan Mharse", "Star publication", 1500);
		books[1] = new Book("B102", "Mongo from start", "Manish Kanhojiya", "Aflatun publication", 1000);
		books[2] = new Book("B103", "Learn sql from basics", "Satej Patwa", "Patwa publication", 1500);
		books[3] = new Book("B104", "Machine learning", "Shubham Chavan", "Chavan and sons", 1300);
		books[4] = new Book("B105", "Digital Marketing", "Tushar Khapare", "Jay viru publication", 2000);
	}

	private static boolean createAndStoreBook(Scanner scanner, Book[] books, int booksCount) {
		if(booksCount == books.length) {
			System.out.println("Book store already full. sorry!");
			return false;
		}
		String bookId = "B10" + (int) (booksCount + 1);

		System.out.println("Enter the book name");
		String bookName = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the author name");
		String authorName = scanner.next();

		System.out.println("Enter the publication name");
		String publication = scanner.next();

		System.out.println("Enter the price of book");
		double price = scanner.nextDouble();

//			Book book = new Book(bookId,bookName,authorName,publication,price);
		books[booksCount] = new Book(bookId, bookName, authorName, publication, price);
		;

		if (books[booksCount] != null) {
			System.out.println("Book created successfully");
			;
			return true;
		} else {
			System.out.println("Something went wrong!");
			return false;
		}
	}

	private static void sortBooksStore(Scanner scanner, Book[] books, int booksCount) {
		System.out.println("choose 1 for asc and 2 for descending");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			sortBooksInAscendingOrder(books, booksCount);
			break;
		case 2:
			sortBooksInDescendingOrder(books, booksCount);
			break;
		default:
			System.out.println("Wrong choice code");
			break;
		}
	}

	private static void sortBooksInAscendingOrder(Book[] books, int booksCount) {
		for (int i = 0; i < booksCount - 1; i++) {
			for (int j = i + 1; j < booksCount; j++) {

				if (books[i].getPrice() > books[j].getPrice()) {
					Book temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				}

				else if (books[i].getPrice() == books[j].getPrice()) {
					String iBookName = books[i].getName().toLowerCase();
					String jBookName = books[j].getName().toLowerCase();

					int start = 0;
					while (iBookName.charAt(start) == jBookName.charAt(start)) {
						start++;
					}

					if (iBookName.charAt(start) > jBookName.charAt(start)) {
						Book temp = books[i];
						books[i] = books[j];
						books[j] = temp;
					}
				}
			}
		}

	}

	private static void sortBooksInDescendingOrder(Book[] books, int booksCount) {
		for (int i = 0; i < booksCount - 1; i++) {
			for (int j = i + 1; j < booksCount; j++) {

				if (books[i].getPrice() < books[j].getPrice()) {
					Book temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				}

				else if (books[i].getPrice() == books[j].getPrice()) {
					String iBookName = books[i].getName().toLowerCase();
					String jBookName = books[j].getName().toLowerCase();

					int start = 0;
					while (iBookName.charAt(start) == jBookName.charAt(start)) {
						start++;
					}

					if (iBookName.charAt(start) < jBookName.charAt(start)) {
						Book temp = books[i];
						books[i] = books[j];
						books[j] = temp;
					}
				}
			}
		}

	}

	private static void printAllBooks(Book[] books, int bookCount) {
		for (int i = 0; i < bookCount; i++) {
			System.out.println(books[i]);
		}
	}

}
