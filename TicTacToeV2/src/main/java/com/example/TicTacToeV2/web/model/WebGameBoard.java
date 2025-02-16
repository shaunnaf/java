package com.example.TicTacToeV2.web.model;

public class WebGameBoard {

  private static final int SIZE = 3;
  private int[][] board;

  public WebGameBoard() {
    board = new int[SIZE][SIZE];
  }

  public WebGameBoard(int[][] board) {
    this.board = board;
  }

  public int[][] getBoard() {
    return board;
  }

  public static int getSIZE() {
    return SIZE;
  }

  public void setCellInBoard(int i, int j, int value) {
    board[i][j] = value;
  }
}
