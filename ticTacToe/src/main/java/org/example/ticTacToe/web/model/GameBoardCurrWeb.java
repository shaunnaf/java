package org.example.ticTacToe.web.model;

import org.example.ticTacToe.domain.model.CurrentGameModel;

public class GameBoardCurrWeb {

  private Long id;
  private GameBoardWeb currBoard;

  public Long getId() {
    return id;
  }

  public GameBoardWeb getCurrBoard() {
    return currBoard;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCurrBoard(GameBoardWeb currBoard) {
    this.currBoard = currBoard;
  }
}
