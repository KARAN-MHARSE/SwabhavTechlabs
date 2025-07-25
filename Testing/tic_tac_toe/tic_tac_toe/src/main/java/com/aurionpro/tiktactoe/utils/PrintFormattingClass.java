package com.aurionpro.tiktactoe.utils;

import com.aurionpro.tiktactoe.enums.Mark;
import com.aurionpro.tiktactoe.model.Cell;

public class PrintFormattingClass {

    public static void displayBoard(Cell[][] board) {
        System.out.println("-------------------------------------");

        int cellNumber = 1;
        for (int i = 0; i < 3; i++) {
            System.out.println("|           |           |           |");
            for (int j = 0; j < 3; j++) {
                String displayValue;
                if (board[i][j].getMark() == Mark.None) {
                    displayValue = String.valueOf(cellNumber);  
                } else {
                    displayValue = board[i][j].getMark().toString();  
                }

                System.out.print("|    " + String.format("%-7s", displayValue)); 
                cellNumber++;
            }
            System.out.println("|");
            System.out.println("|           |           |           |");
            System.out.println("-------------------------------------");
        }
    }
}
