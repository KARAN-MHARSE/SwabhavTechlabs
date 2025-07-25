import java.util.InputMismatchException;
import java.util.Scanner;

import com.aurionpro.tiktactoe.services.GameService;

public class TikTacToeGame {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		GameService gameService = new GameService();

		System.out.println("Let's start the game");

		while (true) {
			try {
				System.out.println("Press \n1: Play Game \n2: Exit Game");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					gameService.startGame(scanner);
					break;

				case 2:
					System.out.println("Thank you for visiting us");
					scanner.close();
					return;

				default:
					System.err.println("Wrong choice code");
					break;
				}

			} catch (InputMismatchException e) {
//				e.printStackTrace();
				System.err.println("Enter the input as number");
				scanner.nextLine();
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		
	}
}
