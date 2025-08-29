package com.aurionpro.main.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	public void addGuitar(Guitar guitar) {
		if (guitar == null)
			throw new RuntimeException("Guitar is empty");
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		return guitars.stream().filter(guitar -> guitar.getSerialNumber().equalsIgnoreCase(serialNumber)).findFirst()
				.orElse(null);
	}

	public List<Guitar> search(GuitarSpec guitarSpec) {
		List<Guitar> matchingGuitars = new ArrayList<Guitar>();
		for(Guitar guitar: guitars) {
			if(guitar.getGuitarSpec().matches(guitarSpec)) {
				matchingGuitars.add(guitar);
			}
		}
		return matchingGuitars;
	}

}
