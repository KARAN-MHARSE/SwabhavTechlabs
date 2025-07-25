package com.aurionpro.day1;

import java.util.Scanner;

public class PigGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		startGame(scanner);

		

	}

	private static void startGame(Scanner scanner) {
		int lastTernPoints = 0;
		int points = 0;
		int turn = 0;
		for (;;) {
			System.out.println("Roll or Hold? (r/h)");
			String choice = scanner.nextLine().toLowerCase();

			if (choice.equals("h")) {
				lastTernPoints += points;
				points = 0;
				turn++;
				System.out.println("Your score points upto current term " + lastTernPoints);
			} else {
				int point = (int) (Math.random() * 6) + 1;
				System.out.println("You got " + point);
				if (point == 1) {
					points = 0;
					turn++;
					System.out.println("You lose all points for the current turn");
				} else {
					points += point;
					if (lastTernPoints + points >= 20) {
						turn++;
						System.out.println("You win the game with the points " + (lastTernPoints + points));
						System.out.println("You take " + turn + " turns to win the game");
						break;
					}
				}
			}
			if (turn > 5) {
				System.out.println("Sorry, you lose the game");
				break;
			}
		}
		
	}

}
