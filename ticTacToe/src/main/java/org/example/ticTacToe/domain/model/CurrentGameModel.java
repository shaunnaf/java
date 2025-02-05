package org.example.ticTacToe.domain.model;

public class CurrentGameModel {

  private Long id;
  private GameBoardModel board;

  public Long getId() {
    return id;
  }

  public GameBoardModel getBoard() {
    return board;
  }

  public void setBoard(GameBoardModel board) {
    this.board = board;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
