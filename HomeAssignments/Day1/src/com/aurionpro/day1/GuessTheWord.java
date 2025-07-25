package com.aurionpro.day1;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
	private static StringBuilder generateBlankString(int size) {
		StringBuilder blankSpace = new StringBuilder();
		for (int i = 0; i < size; i++) {
			blankSpace.append("_");
		}
		return blankSpace;
	}

	private static String generateRandomWord() {
		Random random =new Random();
		
		String[] words = {"Apple","Banana","Orange","Mango","Pineapple","Grapes","Strawberry","Watermelon","Papaya","Kiwi"};
		
		int index = random.nextInt(words.length);
		return words[index];
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String randomWordString = generateRandomWord();
		StringBuilder randomWord =new StringBuilder(randomWordString) ;
		System.out.println(randomWordString);
		
		int size = randomWord.length();

		System.out.println("Predict the word of length " + size);
		StringBuilder predictedWord = generateBlankString(size);
		
		System.out.println(predictedWord);

		final int totalLives = size + 5;
		int live = 0;
		int correctMoves = 0;

		while (live < totalLives) {
			System.out.println("Guess the letter");
			String guessCharacter = scanner.nextLine();

			live++;

			if (randomWord.indexOf(guessCharacter) != -1) {
				correctMoves++;
				int rightLocation = randomWord.indexOf(guessCharacter);
				predictedWord.replace(rightLocation, rightLocation + 1, guessCharacter);
				randomWord.replace(randomWord.indexOf(guessCharacter), randomWord.indexOf(guessCharacter) + 1, "1");
				System.out.println(predictedWord);
				if (correctMoves == size) {
					System.out.println("You guess the correct word: " + predictedWord);
					System.out.println("Moves taken: " + live);
					break;
				}
			}

			if (live == totalLives) {
				System.out.println("You lose the game. The right word is: " + randomWordString);
				break;
			}

		}
	}

}
