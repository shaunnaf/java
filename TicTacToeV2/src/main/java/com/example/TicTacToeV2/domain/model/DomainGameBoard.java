package com.example.TicTacToeV2.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class DomainGameBoard {

  private static final int SIZE = 3;
  private int[][] board;

  public DomainGameBoard() {
    this.board = new int[SIZE][SIZE];
  }

  public void setCellInBoard(int i, int j, int value) {
    board[i][j] = value;
  }
}
