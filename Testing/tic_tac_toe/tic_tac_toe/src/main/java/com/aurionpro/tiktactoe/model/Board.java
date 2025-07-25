package com.aurionpro.tiktactoe.model;

import com.aurionpro.tiktactoe.enums.Mark;

public class Board {
	private Cell[][] gameBoard;
	
	public Board() {
		gameBoard = new Cell[3][3];
		for(int i=0;i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard[0].length;j++) {
				gameBoard[i][j] = new Cell( Mark.None);
			}
		}
		
	}
	
	public Cell[][] getGameBoard() {
		
		return gameBoard;
	}

	public void setGameBoard(Cell[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	
	
	
	
}