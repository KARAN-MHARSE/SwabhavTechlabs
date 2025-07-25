package com.aurionpro.main.models;

import java.io.Serializable;
import java.util.UUID;

public class Movie implements Serializable {
	private UUID id;
	private String name;
	private  String genre;
	
	public Movie(String name, String genre) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.genre = genre;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genre=" + genre + "]";
	}
	
	
}
