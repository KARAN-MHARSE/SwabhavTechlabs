package com.aurionpro.tiktactoe.exceptions;

public class CellAlreadyMarkedException extends RuntimeException {
public CellAlreadyMarkedException() {
	super("Cell alredy marked");
}
}
