package org.example.ticTacToe.domain.service;

import org.example.ticTacToe.domain.model.GameBoardModel;

public interface GameService {

  GameBoardModel nextMove(GameBoardModel currentBoard);

  boolean validBoard(GameBoardModel currentBoard);

  boolean isEndGame(GameBoardModel currentBoard);
}
