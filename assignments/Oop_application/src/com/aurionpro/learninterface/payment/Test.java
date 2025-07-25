package com.aurionpro.learninterface.payment;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double amount = 1000;

		boolean isTransactionPending = true;
		System.out.println("You have to pay the amount: "+ amount);
		while (isTransactionPending) {
			System.out.println(
					"Chose one of the payment option to pay: \n1.Credit card \n2.DebitCard \n3.UPI \n4.Paypal");
			int choice = scanner.nextInt();
			PaymentGateway paymentGateway = null;

			switch (choice) {

			case 1:
				paymentGateway = new CreditCardPayment();
				paymentGateway.pay(amount);
				paymentGateway.generateTransactionNumber();
				isTransactionPending = false;
				break;
			case 2:
				paymentGateway = new DebitCardPayment();
				paymentGateway.pay(amount);
				isTransactionPending = false;
				break;
			case 3:
				paymentGateway = new UpiPayment();
				paymentGateway.pay(amount);
				isTransactionPending = false;
				break;
			case 4:
				paymentGateway = new PaypalPayment();
				paymentGateway.pay(amount);
				isTransactionPending = false;
				break;
			default:
				System.out.println("Wrong choice code");
				break;
			}
		}

	}

}
