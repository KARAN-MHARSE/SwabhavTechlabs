package com.aurionpro.day1;

import java.util.Scanner;

public class CurrencyDenominationApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the amount.");
		System.out.println("Note: Amount should multiple of 100 and not more than 50000");

		int ammount = scanner.nextInt();
		if (ammount % 100 != 0  ) {
			System.out.println("Note: Amount should be in multiples of 100");
		}
		else if (ammount > 50000 && ammount < 0) {
			System.out.println("Note: Amount exceeds withdrwal limit of 50000 or not less than zero.");
		}else {
			int twoThousands = 0;
			int fiveHundreds = 0;
			int twoHundreds = 0;
			int oneHundreds = 0;

			twoThousands = ammount / 2000;
			ammount %= 2000;

			fiveHundreds = ammount / 500;
			ammount %= 500;

			twoHundreds = ammount / 200;
			ammount %= 200;

			oneHundreds = ammount / 100;
			ammount %= 100;

			System.out.println("twoThousands: " + twoThousands);
			System.out.println("fiveHundreds: " + fiveHundreds);
			System.out.println("twoHundreds: " + twoHundreds);
			System.out.println("oneHundreds: " + oneHundreds);

		}

	}

}
