package com.aurionpro.tiktactoe.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aurionpro.tiktactoe.enums.Mark;
import com.aurionpro.tiktactoe.exceptions.CellAlreadyMarkedException;
import com.aurionpro.tiktactoe.exceptions.CellNotFoundException;
import com.aurionpro.tiktactoe.model.Board;
import com.aurionpro.tiktactoe.model.Cell;
import com.aurionpro.tiktactoe.model.Player;

class GameServiceTest {
	 GameService service;
	 Player currentPlayer;
	 Cell[][] board;
	
	@BeforeEach
	void init() {
		service = new GameService();
		currentPlayer = new Player(Mark.O, "Karan");
		board = new Board().getGameBoard();
	}
	

	@Test
	void testValidCell() {
		assertEquals(true,service.validateMove(currentPlayer, 9));
		
	}
	
	@Test
	void testValidCell_greaterCellNumberThan9() {
		assertThrows(CellNotFoundException.class, ()-> service.validateMove(currentPlayer, 10));
	}
	
	@Test
	void testValidCell_smallerCellNumberThan9() {
		assertThrows(CellNotFoundException.class, ()-> service.validateMove(currentPlayer, -2));
	}
	
	@Test
	void testIsCellEmpty() {
		
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				assertEquals(Mark.None, board[i][j].getMark());
			}
		}
	}
	
	@Test
	void testNotDoubleMarkTheSameCell(){
//		board[0][0].setMark(Mark.X);
		service.validateMove(currentPlayer, 1);
		
		assertThrows(CellAlreadyMarkedException.class, ()->service.validateMove(currentPlayer, 1));
	}
	
	

}
