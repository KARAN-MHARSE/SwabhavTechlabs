package com.aurionpro.day2;

import java.util.Scanner;

public class ShiftCharacter {

	private static String characterShifting(String word, int shiftBy) {
		StringBuilder shiftedWord = new StringBuilder();

		for (char ch : word.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				int integerCharValue = (ch + shiftBy);
				if(integerCharValue<'a') {
					shiftedWord.append((char) (integerCharValue + 26));
				}
				else if (integerCharValue > 'z') {
					shiftedWord.append((char) (integerCharValue - 26));
				} else {
					shiftedWord.append((char) (integerCharValue));
				}
			} else if (ch >= 'A' && ch <= 'Z') {
				int integerCharValue = (ch + shiftBy);
				if(integerCharValue<'A') {
					shiftedWord.append((char) (integerCharValue + 26));
				}
				if (integerCharValue > 'Z') {
					shiftedWord.append((char) (integerCharValue - 26));
				} else {
					shiftedWord.append((char) (integerCharValue));
				}
			} else {
				int integerCharValue = ch + shiftBy;
				shiftedWord.append((char) (integerCharValue));
			}

		}

		return shiftedWord.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the word for you want to shift the characters:");
		String word = scanner.nextLine();
		
		System.out.println("Enter the number by which you want to shift the characters:");
		int shiftBy = scanner.nextInt();
		String shiftedWord = characterShifting(word,shiftBy);
		System.out.println("The shifted character word for " + word + " is: " + shiftedWord);

	}

}
