package com.aurionpro.basic.controlstatement;

import java.util.Scanner;

public class TreasureIsland {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to treasure island");
		System.out.println("Enter the direction (left/right)");
		String direction = scanner.nextLine();

		if (direction.equals("left")) {
			System.out.println("Choose swim or wait");
			String swimOrWait = scanner.nextLine();
			if (swimOrWait.equals("wait")) {
				System.out.println("Choose door from red,blue, yellow, else");
				String door = scanner.nextLine();

				if (door.equals("red")) {
					System.out.println("Burned by fire. Game over");
				} else if (door.equals("yellow")) {
					System.out.println("You win");
				} else if (door.equals("blue")) {
					System.out.println("Eaten by beasts. Game over");
				} else {
					System.out.println("Game Over");
				}
			} else {
				System.out.println("Attack by trout, Game over");
			}
		} else {
			System.out.println("Fall into a hole. Game over");
		}

//		if (!direction.equals("left")) {
//			System.out.println("Fall into a hole. Game over");
//		} else {
//			System.out.println("Choose swim or wait");
//			String swimOrWait = scanner.nextLine();
//			if (!swimOrWait.equals("wait")) {
//				System.out.println("Attack by trout, Game over");
//			} else {
//				System.out.println("Choose door from red,blue, yellow, else");
//				String door = scanner.nextLine();
//
//				if (door.equals("red")) {
//					System.out.println("Burned by fire. Game over");
//				} else if (door.equals("yellow")) {
//					System.out.println("You win");
//				} else if (door.equals("blue")) {
//					System.out.println("Eaten by beasts. Game over");
//				} else {
//					System.out.println("Game Over");
//				}
//			}
//		}
	}

}
