package com.example.TicTacToeV2.domain.model;

import java.util.UUID;

public class DomainCurrentGame {

  private UUID id;
  private DomainGameBoard board;

  public DomainCurrentGame(UUID id, DomainGameBoard board) {
    this.id = id;
    this.board = board;
  }

  public DomainCurrentGame(UUID id) {
    this.id = id;
    this.board = new DomainGameBoard();
  }

  public DomainCurrentGame() {
  }

  public DomainGameBoard getBoard() {
    return board;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setBoard(DomainGameBoard board) {
    this.board = board;
  }

  public void setCellInBoard(int i, int j, int value) {
    board.setCellInBoard(i, j, value);
  }
}
