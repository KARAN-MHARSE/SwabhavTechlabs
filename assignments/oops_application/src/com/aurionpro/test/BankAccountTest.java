package com.aurionpro.test;

import java.lang.reflect.Array;
import com.aurionpro.model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.aurionpro.model.Account;
import com.aurionpro.*;

public class BankAccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Account[] accounts = new Account[10];
		int numberOfAccountHolders = 0;

		System.out.println("Welcome to Karan World Bank.");

		boolean isContinue = true;
		while (isContinue) {
			System.out.println("What you want to do, choose the code");
			System.out.println("1. Create an account");
			System.out.println("2. View Balance");
			System.out.println("3. Deposit cash");
			System.out.println("4. WithDraw money");
			System.out.println("5. View Passbook");
			System.out.println("6. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				int isCreated = createAccount(scanner, accounts, numberOfAccountHolders);
				numberOfAccountHolders += isCreated;
				break;
			case 2:
				viewBalance(scanner, accounts);

				break;
			case 3:
				deposit(scanner, accounts);
				break;
			case 4:
				withdraw(scanner, accounts);
				break;
			case 5:
				viewPassbook(scanner, accounts);
				break;
			case 6:
				isContinue = false;
				break;
			}
			System.out.println();
		}
		showAllAccount(accounts);
	}

	public static String generateRandomAccountNumber() {
		StringBuilder accountNumber = new StringBuilder("IDBI000");
		Random random = new Random();
		int min = 1000;
		int max = 8000;
		long randomNumber = random.nextLong(max) + min;

		accountNumber.append(randomNumber);
		return accountNumber.toString();
	}

	private static Account findUserAccount(Account[] accounts, String accountHolderName) {
	    for (Account account : accounts) {
	        if (account != null && accountHolderName.equalsIgnoreCase(account.getName())) {
	            return account;
	        }
	    }
	    return null;
	}


	private static void viewPassbook(Scanner scanner, Account[] accounts) {
		System.out.println("Enter the user name");
		String accountHolderName = scanner.next();

		Account currentUserAccount = findUserAccount(accounts, accountHolderName);

		if (currentUserAccount == null) {
			System.out.println("No such used account found");
			return;
		} else {
			System.out.println(currentUserAccount);
		}

	}

	private static void withdraw(Scanner scanner, Account[] accounts) {
		System.out.println("Enter the account holder name: ");
		String accountHolderName = scanner.next();

		System.out.println("Enter the ammount to withdraw");
		double withdrawAmmount = scanner.nextDouble();

		Account currentUserAccount = findUserAccount(accounts, accountHolderName);

		if (currentUserAccount == null) {
			System.out.println("No such used account found");
			return;
		} else {
			boolean isSuccesfullTransaction = currentUserAccount.withdraw(withdrawAmmount);
			if (isSuccesfullTransaction) {
				System.out.println("ammount is succesfully withdraw ");
			}
		}

	}

	private static void deposit(Scanner scanner, Account[] accounts) {
		System.out.println("Enter the Account holder name");
		String accountHolderName = scanner.next();

		System.out.println("Enter the ammount to deposit");
		double ammount = scanner.nextDouble();

		Account currentUserAccount = findUserAccount(accounts, accountHolderName);

		if (currentUserAccount == null) {
			System.out.println("No such used account found");
			return;
		} else {
			currentUserAccount.deposit(ammount);
			System.out.println("Deposit successfully");
		}

	}

	private static void viewBalance(Scanner scanner, Account[] accounts) {
		System.out.println("Enter the user name");
		String accountHolderName = scanner.next();

		Account currentUserAccount = findUserAccount(accounts, accountHolderName);

		if (currentUserAccount == null) {
			System.out.println("No such used account found");
			return;
		} else {
			System.out.println("Account balance is: " + currentUserAccount.getBalance());
		}

	}

	private static int createAccount(Scanner scanner, Account[] accounts, int numberOfAccountHolders) {

		String accountNumber = generateRandomAccountNumber();
		System.out.println("Enter the user name");
		String accountHOlderName = scanner.next();
		System.out.println("Enter the account type.(1 for saving/2 for current)");
		int choice = scanner.nextInt();
		AccountType accountType;
		if(choice == 1) {
			accountType = AccountType.saving;
		}else {
			accountType = AccountType.current;
		}
		boolean isMinimumAccountAmount = false;

		double ammount = 0;
		while (!isMinimumAccountAmount) {
			System.out.println("Enter the initial ammount greatter than 500 to open account");
			ammount = scanner.nextDouble();
			if (ammount >= 500) {
				isMinimumAccountAmount = true;
			}
		}

		Account newAccount = new Account(accountNumber, accountHOlderName, ammount, accountType);
		accounts[numberOfAccountHolders] = newAccount;
		if (newAccount != null) {
			System.out.println("Bank account created successfully");
			return 1;
		} else {
			System.out.println("Bank account Not created due to some issued");
			return 0;
		}

	}

	private static void showAllAccount(Account[] accounts) {
		for(Account account : accounts) {
			System.out.println(account);
		}
	}
}
