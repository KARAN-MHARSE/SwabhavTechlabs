package com.aurionpro.main.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.main.exceptions.InvalidInputFormat;
import com.aurionpro.main.exceptions.MovieNotFoundException;
import com.aurionpro.main.models.Movie;

public class MovieService {
	private List<Movie> movies;
	private static final String filePath = "C:\\Users\\karan.mharse\\Desktop\\MoviesList.txt";

	public MovieService() {
		movies = new ArrayList<Movie>();
		addInitialMovies();
	}

	public void addInitialMovies() {
		movies.add(new Movie("Lagaan ", "Sports"));
		movies.add(new Movie("Kabhi Khushi Kabhie Gham ", "Sports"));
		movies.add(new Movie("3 Idiots ", "Comedy"));
		movies.add(new Movie("Drishyam  ", "Crime"));
		movies.add(new Movie("Baahubali: The Beginning  ", "Fantasy"));
	}

	public void printMoviesList() {
		if(movies.isEmpty()) throw new MovieNotFoundException();
		movies.forEach(System.out::println);
	}
	public void storeMoviesInFileFromList(List<Movie> movies) throws IOException {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			for (Movie movie : movies) {
				objectOutputStream.writeObject(movie);
			}
			objectOutputStream.close();
			fileOutputStream.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	public List<Movie> getMoviesFromList() throws IOException, ClassNotFoundException {
		List<Movie> moviesFromFile = new ArrayList<Movie>();
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			while (true) {
				try {
					Movie movie = (Movie) objectInputStream.readObject();
					moviesFromFile.add(movie);
				} catch (Exception e) {
					System.err.println(e.getMessage());
					break;
				}
			}
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return moviesFromFile;

	}

	public void saveMovie(Scanner scanner) throws IOException {
		System.out.println("Enter the movie name");
		String movieName = scanner.nextLine();

		System.out.println("Enter the movie genre");
		String genre = scanner.nextLine();

		if (movieName == null || genre == null || movieName.isBlank() || genre.isBlank())
			throw new InvalidInputFormat();
		
		Movie movie = new Movie(movieName, genre);
		movies.add(movie);
		storeMoviesInFileFromList(movies);

		System.out.println("Movie succesfully added");
	}

	public void loadMovies() {
		try {
			movies = getMoviesFromList();

			movies.forEach(System.out::println);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public  void clearMovies() {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(filePath);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(new Movie("",""));
//			objectOutputStream.writeByte("");
			
			movies.removeAll(movies);
			System.out.println("all movies all deleted");
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.err.println("Error clearing movies: " + e.getMessage());
		}
	}

	public void getMovieByName(String movieName) {
		for (Movie movie : movies) {
			if (movie.getName().toLowerCase().trim().equalsIgnoreCase(movieName.toLowerCase().trim()))
				System.out.println(movie); 
			return;
		}
		throw new MovieNotFoundException();
	}

	public void getMovieById(String movieID) {
//		movies.forEach(t ->System.out.println(t));
		for (Movie movie : movies) {
			if (movie.getId().toString().trim().equals(movieID.trim()))
				System.out.println(movie); 
			return;
		}
		throw new MovieNotFoundException();
	}

	public List<Movie> getAllMovies() {
		if (movies.isEmpty()) {
			loadMovies();
		}
		return movies;
	}

	public void deleteMovieByName(String movieName) {
		try {
			for (Movie movie : movies) {
				if (movie.getName().toLowerCase().trim().equals(movieName.toLowerCase().trim())) {
					movies.remove(movie);
					storeMoviesInFileFromList(movies);
					System.out.println("Movie deleted successfully");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		throw new MovieNotFoundException();
	}

}
