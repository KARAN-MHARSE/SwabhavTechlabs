package com.aurionpro.main;

import java.util.Scanner;

import com.aurionpro.main.controller.MovieController;

public class MoviesFlix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the MoviesFlix");
		
		MovieController.displayMenu(scanner);
	}

}
