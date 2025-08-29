package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Computer {
	@Value("HP")
	private String name;
	@Autowired
	private HardDisk hardDisk;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}

	public Computer(String name, HardDisk hardDisk) {
		super();
		this.name = name;
		this.hardDisk = hardDisk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HardDisk getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", hardDisk=" + hardDisk + "]";
	}

	
}
