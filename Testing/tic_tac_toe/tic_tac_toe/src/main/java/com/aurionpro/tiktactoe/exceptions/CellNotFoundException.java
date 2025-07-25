package com.aurionpro.tiktactoe.exceptions;

public class CellNotFoundException  extends RuntimeException{

	public CellNotFoundException() {
		super("Wrong cell number");
	}
}
