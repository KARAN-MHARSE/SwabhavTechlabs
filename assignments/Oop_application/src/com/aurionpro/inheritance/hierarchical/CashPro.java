package com.aurionpro.inheritance.hierarchical;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.aurionpro.inheritance.hierarchical.exceptions.CustomException;

public class CashPro {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accounts = new ArrayList<Account>(
				Arrays.asList(new SavingAccount("Ramesh", 3000), new CurrentAccount("Paresh", 8000),
						new CurrentAccount("Vijay", 89898), new SavingAccount("Ganesh", 9090)));

		System.out.println("Welcome in TJSB Bank");
		boolean isContinue = true;
		while (isContinue) {
			System.out.println(
					"Choose the choice code \n1.Create Bank Account \n2.Print Passbook \n3.Deposit Amount \n4.Withdraw amount   \n5.Bank To Bank Transfer \n6.Sort Bank Accounts by Name   \n7.Sort Bank Accounts by Salary  \n8.Sort Bank Accounts in asc by id \n9.Sort Bank Accounts in desc by id \n10.PrintAllAccounts \n11.Exit");
			int choice = scanner.nextInt();

			try {
				switch (choice) {
				case 1:
					System.out.println("Create account");
					createBankAccount(scanner, accounts);
					break;
				case 2:
					printPassbook(scanner, accounts);
					break;
				case 3:
					depositMoney(scanner, accounts);
					break;
				case 4:
					withdrawMoney(scanner, accounts);
					break;
				case 5:
					bankToBankTransfer(scanner, accounts);
					break;
				case 6:
					sortBankAccountByName(accounts);
					break;
				case 7:
					sortBankAccountBySalary(accounts);
					break;
				case 8:
					sortBankAccountInAsc(accounts);
					break;
				case 9:
					sortBankAccountInDesc(accounts);
					break;
				case 10:
					printAllAccounts(accounts);
					break;

				case 11:
					System.out.println("Exit");
					isContinue = false;
					break;
				default:
					System.out.println("Wrong choice code");
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		scanner.close();
	}

	private static void printAllAccounts(ArrayList<Account> accounts) {
		if (accounts.isEmpty())
			throw new RuntimeException("No accounts fount");
		accounts.forEach(System.out::println);

	}

	private static void sortBankAccountBySalary(ArrayList<Account> accounts) {
		if (accounts.isEmpty())
			throw new RuntimeException("No accounts found");
		Collections.sort(accounts, new AccountsComparatorBySalary());

	}

	private static void sortBankAccountByName(ArrayList<Account> accounts) {
		if (accounts.isEmpty())
			throw new RuntimeException("No accounts found");
		Collections.sort(accounts, new AccountsComparatorByName());

	}

	private static void sortBankAccountInAsc(ArrayList<Account> accounts) {
		if (accounts.isEmpty())
			throw new RuntimeException("No accounts found");
		Collections.sort(accounts);

	}

	private static void sortBankAccountInDesc(ArrayList<Account> accounts) {
		sortBankAccountInAsc(accounts);
		Collections.reverse(accounts);

	}

	private static Account findBankAccount(ArrayList<Account> accounts, String accountNumber) {
		for (Account account : accounts) {
			if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
				return account;
			}
		}
		throw new CustomException("Account Number not found");
	}

	private static void createBankAccount(Scanner scanner, ArrayList<Account> accounts) {
		System.out.println("Enter your name");
		String userName = scanner.next();

		double balance = 0;
		while (true) {
			System.out.println("Enter starting balance");
			balance = scanner.nextDouble();
			if (balance > 500)
				break;
			System.out.println("initial balance should be Greaterthan 500");
		}

		System.out.println("Select 1 for Current account & 2 for Saving Account");
		int accountTypeChoice = scanner.nextInt();
		if (accountTypeChoice == 1) {
			CurrentAccount account = new CurrentAccount(userName, balance);
			accounts.add(account);
			storeObjectToFile(account);
			System.out.println("Account Successfullycreated and your account number is " + account.getAccountNumber());
//			(account == null) ? System.out.println("Something went wrong. Try again") :System.out.println("Account Successfullycreated and your account number is "+ account.getAccountNumber());;
			return;
		}

		SavingAccount account = new SavingAccount(userName, balance);
		accounts.add(account);
		System.out.println("Account Successfullycreated and your account number is " + account.getAccountNumber());

	}

	private static void printPassbook(Scanner scanner, ArrayList<Account> accounts) {
		System.out.println("Enter the account number to view passbook");
		String accountNumber = scanner.next();

		for (Account account : accounts) {
			if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
				account.printPassbook();
				return;
			}
		}
		System.out.println("Wrong account number");

	}

	private static void depositMoney(Scanner scanner, ArrayList<Account> accounts) {
		System.out.println("Enter the account number to view passbook");
		String accountNumber = scanner.next();

		for (Account account : accounts) {
			if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
				System.out.println("Enter the amount to deposit");
				double amount = scanner.nextDouble();
				account.creditAmount(amount);
				return;
			}
		}
		System.out.println("Wrong account number");

	}

	private static void withdrawMoney(Scanner scanner, ArrayList<Account> accounts) {
		System.out.println("Enter the account number");
		String accountNumber = scanner.next();

		for (Account account : accounts) {
			if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
				System.out.println("Enter the amount to withdraw");
				double amount = scanner.nextDouble();
				account.debit(amount);
				return;
			}
		}
		System.out.println("Wrong account number");
	}

	private static void bankToBankTransfer(Scanner scanner, ArrayList<Account> accounts) {
		System.out.println("Enter your account number");
		String selfAccountNumber = scanner.next();

		System.out.println("Enter the receiver account number");
		String toAccountNumber = scanner.next();
		Account senderAccount = null;
		Account receiverAccount = null;

		for (Account account : accounts) {
			if (selfAccountNumber.equalsIgnoreCase(account.getAccountNumber())) {
				senderAccount = account;
			}
			if (toAccountNumber.equalsIgnoreCase(account.getAccountNumber())) {
				receiverAccount = account;
			}
		}
		if (senderAccount == null || receiverAccount == null) {
			throw new CustomException("Wrong account numbers");
		}
		System.out.println("Enter the amount to transfer");
		double amount = scanner.nextDouble();
		boolean isDebited = senderAccount.debit(amount);
		if (!isDebited) {
			System.out.println("Something went wrong");
			return;
		}
		receiverAccount.creditAmount(amount);

	}

	public static void storeObjectToFile(Account account) {
		try {
			FileOutputStream fileInputStream = new FileOutputStream(
					"C:\\Users\\karan.mharse\\Desktop\\BankAccounts.txt");
			ObjectOutputStream objectInputStream = new ObjectOutputStream(fileInputStream);

			objectInputStream.writeObject(account);
			objectInputStream.writeObject(account);

			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
