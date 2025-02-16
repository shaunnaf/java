package com.example.TicTacToeV2.datasource.model;

public class DataSourceGameBoard {

  private static final int SIZE = 3;
  private int[][] board;

  public DataSourceGameBoard() {
    board = new int[SIZE][SIZE];
  }

  public DataSourceGameBoard(int[][] board) {
    this.board = board;
  }

  public int[][] getBoard() {
    return board;
  }

  public void setCellInBoard(int i, int j, int value) {
    board[i][j] = value;
  }

  public static int getSIZE() {
    return SIZE;
  }

  public void setBoard(int[][] board) {
    this.board = board;
  }
}
