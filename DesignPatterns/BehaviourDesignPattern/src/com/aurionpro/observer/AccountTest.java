package com.aurionpro.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.observer.models.Account;
import com.aurionpro.observer.notificationTypes.EmailNotification;
import com.aurionpro.observer.notificationTypes.SmsNotification;
import com.aurionpro.observer.notificationTypes.WhatsappNotification;
import com.aurionpro.observer.repo.INotifier;

public class AccountTest {
	public static Account currentUser = new Account("Prathamesh", 1000, null);

	public static void main(String args[]) {
		List<INotifier> notificationWays = new ArrayList<INotifier>(
				Arrays.asList(new EmailNotification(), new SmsNotification(), new WhatsappNotification()));
		currentUser.setNotifcationWays(notificationWays);

		Scanner scanner = new Scanner(System.in);

		start(scanner);
	}

	private static void start(Scanner scanner) {
		System.out.println("Welcome to III Bank");

		boolean isContinue = true;
		while (isContinue) {
			System.out.println(
					"Select the choice code \n1.Create account \n2.Credit amount \n3.Debit amount \4.Add notification Ways \n5.Remove Notification way \n6.exit");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				createAccount(scanner);
				break;
			case 2:
				System.out.println("Enter the amount to credit");
				double amount = scanner.nextDouble();
				scanner.nextLine();
				currentUser.credit(amount);
				break;
			case 3:
				System.out.println("Enter the amount to debit");
				double amount1 = scanner.nextDouble();
				scanner.nextLine();
				currentUser.debit(amount1);
				break;
			case 4:
				System.out.println("Enter the notification way \n1.Sms \n2.whatsapp \n3.email");
				int notificationWayChoice = scanner.nextInt();
				scanner.nextLine();
				if (notificationWayChoice < 0 || notificationWayChoice > 3) {
					System.err.println("Wrong choice code");
					break;
				}
				if (notificationWayChoice == 1) {
					currentUser.addNotificationWay(new SmsNotification());
					break;
				}
				if (notificationWayChoice == 2) {
					currentUser.addNotificationWay(new WhatsappNotification());
					break;
				}
				if (notificationWayChoice == 3) {
					currentUser.addNotificationWay(new EmailNotification());
					break;
				}
				break;
			case 5:
				removeNotificationWay(scanner);
				break;
			case 6:
				isContinue = false;
				System.out.println("Thank you");
				break;
			}
		}

	}

	private static void removeNotificationWay(Scanner scanner) {
		System.out.println("Enter the notification way \n1.Sms \n2.whatsapp \n3.email");
		int notificationWayChoice = scanner.nextInt();
		scanner.nextLine();
		if (notificationWayChoice < 0 || notificationWayChoice > 3) {
			System.err.println("Wrong choice code");
			return;
		}
		if (notificationWayChoice == 1) {
			currentUser.removeNotificationWay(new SmsNotification());
			return;
		}
		if (notificationWayChoice == 2) {
			currentUser.removeNotificationWay(new WhatsappNotification());
			return;
		}
		if (notificationWayChoice == 3) {
			currentUser.removeNotificationWay(new EmailNotification());
		}

	}

	private static void createAccount(Scanner scanner) {
		System.out.println("Enter your name");
		String name = scanner.nextLine();

		System.out.println("Enter intital balance");
		double amount = 0;
		while (true) {
			if (amount > 0) {
				amount = scanner.nextDouble();
				scanner.nextLine();
				break;
			}
			System.out.println("Amount should be greater than 0, Enter again");
		}
		
		List<INotifier> notifierways = new ArrayList<INotifier>();
		
		while(true) {
			System.out.println("Enter the notification way \n1.Sms \n2.whatsapp \n3.email \n4.No One");
			int notificationWayChoice = scanner.nextInt();
			scanner.nextLine();
			
			
			
			if (notificationWayChoice < 0 || notificationWayChoice > 3) {
				System.err.println("Wrong choice code");
			}
			if (notificationWayChoice == 1) {
				notifierways.add(new SmsNotification());
			}
			if (notificationWayChoice == 2) {
				notifierways.add(new WhatsappNotification());			}
			if (notificationWayChoice == 3) {
				notifierways.add(new EmailNotification());
			}
			else {
				break;
			}
		}
		
		currentUser = new Account(name, amount, notifierways);
		System.out.println("Account created");

	}
}
