package com.aurionpro.tiktactoe.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.PlainDocument;

import com.aurionpro.tiktactoe.enums.Mark;
import com.aurionpro.tiktactoe.exceptions.CellAlreadyMarkedException;
import com.aurionpro.tiktactoe.exceptions.CellNotFoundException;
import com.aurionpro.tiktactoe.model.Board;
import com.aurionpro.tiktactoe.model.Cell;
import com.aurionpro.tiktactoe.model.Pair;
import com.aurionpro.tiktactoe.model.Player;
import com.aurionpro.tiktactoe.utils.PrintFormattingClass;

public class GameService {
	Board board;
	Cell[][] gameBoard;

	public GameService() {
		board = new Board();
		gameBoard = board.getGameBoard();
	}
	
	
	public void startGame(Scanner scanner) {
		Player player1 = new Player(Mark.None, "Player1");
		Player player2 = new Player(Mark.None, "Player2");

		
		takeUserChoiceMark(scanner, player1, player2);
		PrintFormattingClass.displayBoard(gameBoard);

		int moves = 0;
		Player currentPlayer = player1;
		
		while (moves < 9) {
			try {
				int cellNumber = makeMove(scanner, currentPlayer);
				if (checkWin(currentPlayer, cellNumber)) {
					PrintFormattingClass.displayBoard(gameBoard);
					System.out.println("🎉🎊 " + currentPlayer.getName() + " (" + currentPlayer.getMark() + ") wins the game! 🏆✨");
					resetBoard();
					moves=0;
					return;
					
				}

				moves++;
				PrintFormattingClass.displayBoard(gameBoard);
				currentPlayer = (currentPlayer == player1) ? player2 : player1;

			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please enter a number between 1 and 9.");
//				System.err.println(e.getMessage());
				scanner.nextLine();
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		System.out.println("Game ended in a draw!");

	}
	
	private void takeUserChoiceMark(Scanner scanner, Player player1, Player player2) {
		boolean isMark = false;
		while (!isMark) {
			System.out.println("Player 1 choose your mark \n1. X \n2. O");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				player1.setMark(Mark.X);
				player2.setMark(Mark.O);
				isMark = true;
				break;
			case 2:
				player1.setMark(Mark.O);
				player2.setMark(Mark.X);
				isMark = true;
				break;

			default:
				System.err.println("Enter write choice code");
			}
		}
	}

	private int makeMove(Scanner scanner, Player currentPlayer) {
		System.out.println(currentPlayer.getName()+": Choose the cell number.");
		int cellNumber = scanner.nextInt();
		scanner.nextLine();

		validateMove(currentPlayer, cellNumber);

		return cellNumber;

	}

	

	public boolean validateMove(Player currentPlayer, int cellNumber) {
		if(cellNumber <=0 || cellNumber>9) 
			throw new CellNotFoundException();
		
		
		Pair pair = getRowColFromCellNumber(cellNumber);
		Cell currentCell = gameBoard[pair.getRow()][pair.getCol()];
		if (!currentCell.getMark().equals(Mark.None))
			throw new CellAlreadyMarkedException();

		currentCell.setMark(currentPlayer.getMark());

		return true;
	}

	private boolean checkWin(Player currentPlayer, int cellNumber) {
		Pair pair = getRowColFromCellNumber(cellNumber);

//		Check for same row
		int row = pair.getRow();
		if (gameBoard[row][0].getMark() == currentPlayer.getMark()
				&& gameBoard[row][1].getMark() == currentPlayer.getMark()
				&& gameBoard[row][2].getMark() == currentPlayer.getMark()) {
			return true;

		}

//		For column
		int col = pair.getCol();
		if (gameBoard[0][col].getMark() == currentPlayer.getMark()
				&& gameBoard[1][col].getMark() == currentPlayer.getMark()
				&& gameBoard[2][col].getMark() == currentPlayer.getMark()) {
			return true;

		}

//	for digonals
		if (gameBoard[0][0].getMark() == currentPlayer.getMark() && gameBoard[1][1].getMark() == currentPlayer.getMark()
				&& gameBoard[2][2].getMark() == currentPlayer.getMark()) {
			return true;

		}

		if (gameBoard[0][2].getMark() == currentPlayer.getMark() && gameBoard[1][1].getMark() == currentPlayer.getMark()
				&& gameBoard[2][0].getMark() == currentPlayer.getMark()) {
			return true;

		}
		return false;
	}
	
	private Pair getRowColFromCellNumber(int cellNumber) {

		switch (cellNumber) {
		case 1:
			return new Pair(0, 0);
		case 2:
			return new Pair(0, 1);
		case 3:
			return new Pair(0, 2);
		case 4:
			return new Pair(1, 0);
		case 5:
			return new Pair(1, 1);
		case 6:
			return new Pair(1, 2);
		case 7:
			return new Pair(2, 0);
		case 8:
			return new Pair(2, 1);
		case 9:
			return new Pair(2, 2);
		default:
			throw new CellNotFoundException();
		}
	}

	
	private void resetBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j].setMark(Mark.None);
			}
		}
	}
}