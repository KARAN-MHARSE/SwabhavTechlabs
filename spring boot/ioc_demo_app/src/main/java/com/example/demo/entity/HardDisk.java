package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Value;

public class HardDisk {
	@Value("1000")
	private int capacity;

	public HardDisk() {
		super();
	}

	public HardDisk(int capacity) {
		super();
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "HardDisk [capacity=" + capacity + "]";
	}
	
	

}
