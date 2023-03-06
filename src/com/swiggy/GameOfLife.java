package com.swiggy;

public class GameOfLife {

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
        /*int[][] board = {
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int row = 5 , column = 4;*/

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        int row = 4, column = 3;
        System.out.println("-------------Initial------------");
        drawBoard(board, row, column);
        System.out.println("-------------Next Generation------------");
        drawBoard(nextGeneration(board, row, column), row, column);

    }
}
