package org.example.ticTacToe.datasource.model;

import org.example.ticTacToe.domain.model.GameBoardModel;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentGameRepo {

  private Long id;
  private GameBoardRepo currentBoard;

  public Long getId() {
    return id;
  }

  public GameBoardRepo getCurrentBoard() {
    return currentBoard;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCurrentBoard(GameBoardRepo currentBoard) {
    this.currentBoard = currentBoard;
  }
}
