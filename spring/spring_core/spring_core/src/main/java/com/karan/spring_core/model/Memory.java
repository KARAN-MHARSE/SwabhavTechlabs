package com.karan.spring_core.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Memory {
	@Value("Samsung")
	private String name;
	@Value("1000")
	private int capacity;

	public Memory() {
		super();
	}

	public Memory(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Memory [name=" + name + ", capacity=" + capacity + "]";
	}

}
