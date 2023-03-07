package com.swiggy.controller;

import com.swiggy.helper.GameOfLifeHelper;
import com.swiggy.model.Board;

public class Application {

    public static void main(String[] args) {
        Board board = new Board();
        GameOfLifeHelper helper = new GameOfLifeHelper();
        board.setRows(5);
        board.setColumn(5);
        board.setIteration(3);
        board.setBoard(helper.generateInitialBoard(board.getRows(), board.getColumn()));

        System.out.println("-------------Initial------------");
        helper.drawBoard(board.getBoard(), board.getRows(), board.getColumn());

        for (int i = 0; i < board.getIteration(); i++) {
            System.out.println("-------------Next Generation------------");
            board.setBoard(helper.nextGeneration(board.getBoard(), board.getRows(), board.getColumn()));
            helper.drawBoard(board.getBoard(), board.getRows(), board.getColumn());
        }
    }
}
