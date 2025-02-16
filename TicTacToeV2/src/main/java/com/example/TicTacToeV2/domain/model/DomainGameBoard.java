package com.example.TicTacToeV2.domain.model;

public class DomainGameBoard {

  private static final int SIZE = 3;
  private int[][] board;

  public DomainGameBoard(int[][] board) {
    this.board = board;
  }

  public DomainGameBoard() {
    board = new int[SIZE][SIZE];
  }

  public int[][] getBoard() {
    return board;
  }

  public void setCellInBoard(int i, int j, int value) {
    board[i][j] = value;
  }
}
