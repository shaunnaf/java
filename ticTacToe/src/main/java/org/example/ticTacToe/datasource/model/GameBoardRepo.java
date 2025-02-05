package org.example.ticTacToe.datasource.model;

import org.springframework.stereotype.Repository;

@Repository
public class GameBoardRepo {

  private int[][] board;

  public int[][] getBoard() {
    return board;
  }

  public void setBoard(int[][] board) {
    this.board = board;
  }
}
