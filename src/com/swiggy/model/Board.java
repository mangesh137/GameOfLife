package com.swiggy.model;

public class Board {
    int rows;

    int column;

    int iteration;

    int[][] board;

    public Board() {
    }

    public Board(int rows, int column, int iteration, int[][] board) {
        this.rows = rows;
        this.column = column;
        this.iteration = iteration;
        this.board = board;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

}
