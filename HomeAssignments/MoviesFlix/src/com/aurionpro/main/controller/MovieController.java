package com.aurionpro.main.controller;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.main.models.Movie;
import com.aurionpro.main.service.MovieService;

public class MovieController {

	public static void displayMenu(Scanner scanner) {
		MovieService movieService = new MovieService();
		boolean isContinue = true;
		
		while (isContinue) {
			try {
				System.out.println("**************************************************");
//				\n7.Update movie details
				System.out.println(
						"Choose the choice code \n1.View movieslist \n2.Add new movie \n3.Delete movie by name \n4.Search movie by id \n5.Search movie by name \n6.Delete all movies  \n10.Exit");

				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1: 
					movieService.printMoviesList();
					break;
				case 2:
					movieService.saveMovie(scanner);
					break;
				case 3:
					System.out.println("Enter the movie name");
					String movieName =scanner.nextLine();
					movieService.deleteMovieByName(movieName);
					break;
				case 4:
					System.out.println("Enter the movie id");
					String movieId =scanner.nextLine();
					movieService.getMovieById(movieId);
					break;
				case 5:
					System.out.println("Enter the movie name");
					String movieName1 =scanner.nextLine();
					movieService.getMovieByName(movieName1);
					break;
				case 6:
					movieService.clearMovies();
					break;
				case 10:
					isContinue = false;
					System.out.println("Thank you for visiting the movies flix");
					break;
					
					
				default:
					System.err.println("Wrong choice code");
				}
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
	}

}
