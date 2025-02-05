package org.example.ticTacToe.datasource.mapper;

import org.example.ticTacToe.datasource.model.CurrentGameRepo;
import org.example.ticTacToe.datasource.model.GameBoardRepo;
import org.example.ticTacToe.domain.model.CurrentGameModel;
import org.example.ticTacToe.domain.model.GameBoardModel;

public class CurrentGameDTO implements MapperCurrGame {

  private final GameBoardDTO gameBoardDTO = new GameBoardDTO();

  @Override
  public CurrentGameRepo toEntity(CurrentGameModel model) {
    CurrentGameRepo entity = new CurrentGameRepo();
    entity.setId(model.getId());
    entity.setCurrentBoard(
        gameBoardDTO.toEntity(model.getBoard()));
    return entity;
  }

  @Override
  public CurrentGameModel toDomain(CurrentGameRepo repo) {
    CurrentGameModel game = new CurrentGameModel();
    game.setId(repo.getId());
    game.setBoard(gameBoardDTO.toDomain(repo.getCurrentBoard()));
    return game;
  }
}
