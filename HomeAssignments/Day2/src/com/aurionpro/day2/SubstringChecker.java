package com.aurionpro.day2;

import java.util.Scanner;

public class SubstringChecker {
	private static void checkSubstring(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();

		for (int i = 0; i <= length1 - length2; i++) {
			int j;
			for (j = 0; j < length2; j++) {
				if (word1.charAt(i+j) != word2.charAt(j)) {
					break;
				}
			}
			if (j == length2) {
				System.out.println(word2 + " is substring of " + word1);
				return;
			}

		}
		System.out.println(word2 + " is not substring of " + word1);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the first String");
		String word1 = scanner.nextLine();

		System.out.println("Enter the substring for checking");
		String word2 = scanner.nextLine();

		checkSubstring(word1, word2);

	}

}
