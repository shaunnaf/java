package com.example.TicTacToeV2.datasource.model;

import java.util.UUID;

public class DataSourceCurrentGame {

  private final UUID id;
  private final DataSourceGameBoard board;

  public DataSourceCurrentGame(UUID id, DataSourceGameBoard board) {
    this.id = id;
    this.board = board;
  }

  public DataSourceCurrentGame(UUID id) {
    this.id = id;
    this.board = new DataSourceGameBoard();
  }

  public DataSourceGameBoard getBoard() {
    return board;
  }

  public UUID getId() {
    return id;
  }

  public void setCellInBoard(int i, int j, int value) {
    board.setCellInBoard(i, j, value);
  }

}
