package com.aurionpro.day1;

import java.util.Scanner;

public class NumberGuesser {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int maxAttempts = 5;
		boolean playAgain = true;

		while (playAgain) {
			int number = (int) (Math.random() * 100 + 1);

			int attempts = 0;

			while (attempts < maxAttempts) {
				System.out.println("Guess of the number");
				int userNumber = scanner.nextInt();
				scanner.nextLine();

				attempts++;

				if (userNumber == number) {
					System.out.println("You won: in attempt: " + attempts);
					break;
				} else if (userNumber < number) {
					System.out.println("Sorry too  low");
				} else {
					System.out.println("Sorry too  high");
				}
			}

			if (attempts >= maxAttempts) {
				System.out.println("You lost the game.");
			}
			
			System.out.println("Do you want to play this game again.(yes/no)");
			String isPlayAgain = scanner.nextLine();
			
			if (isPlayAgain.equalsIgnoreCase("yes")) {
				attempts = 0;
			} else {
				System.out.println("Thank you!");
				playAgain = false;
			}

		}

	}

}
