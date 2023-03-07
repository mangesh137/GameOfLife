package com.swiggy;

public class GameOfLife {

    public static int[][] generateInitialBoard(int row, int column) {
        int[][] board = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = (int) Math.round(Math.random());
            }
            System.out.println();
        }
        return board;
    }

    public static void drawBoard(int[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] nextGeneration(int board[][], int rows, int columns) {
        int nextGenerationBoard[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int aliveNeighboursCount = getAliveNeighboursCount(board, rows, columns, i, j);
                if ((board[i][j] == 1) && (aliveNeighboursCount < 2 || aliveNeighboursCount > 3)) {
                    nextGenerationBoard[i][j] = 0;
                } else if ((board[i][j] == 0) && (aliveNeighboursCount == 3)) {
                    nextGenerationBoard[i][j] = 1;
                } else {
                    nextGenerationBoard[i][j] = board[i][j];
                }
            }
        }
        return nextGenerationBoard;
    }

    public static int getAliveNeighboursCount(int board[][], int rows, int columns, int r, int c) {
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((r + i >= 0 && r + i < rows) && (c + j >= 0 && c + j < columns)) {
                    aliveNeighbours += board[r + i][c + j];
                }
            }
        }
        aliveNeighbours -= board[r][c];
        return aliveNeighbours;
    }

    public static void main(String[] args) {

        int row = 5, column = 5, interation = 3;
        int[][] board = generateInitialBoard(row, column);

        System.out.println("-------------Initial------------");
        drawBoard(board, row, column);

        for (int i = 0; i < interation; i++) {
            System.out.println("-------------Next Generation------------");
            board = nextGeneration(board, row, column);
            drawBoard(board, row, column);
        }
    }
}
