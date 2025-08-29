package com.karan.spring_core.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Computer {
	@Value("Dell")
	private String name;
	@Autowired
	private Memory memory;

	public Computer() {
		super();
	}

	public Computer(String name, Memory memory) {
		super();
		this.name = name;
		this.memory = memory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", memory=" + memory + "]";
	}

}
