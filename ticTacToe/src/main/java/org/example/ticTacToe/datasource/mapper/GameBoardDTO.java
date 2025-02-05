package org.example.ticTacToe.datasource.mapper;

import org.example.ticTacToe.datasource.model.GameBoardRepo;
import org.example.ticTacToe.domain.model.GameBoardModel;

public class GameBoardDTO implements MapperGameBoard {

  @Override
  public GameBoardRepo toEntity(GameBoardModel model) {
    GameBoardRepo entity = new GameBoardRepo();
    entity.setBoard(model.getBoard());
    return entity;
  }

  @Override
  public GameBoardModel toDomain(GameBoardRepo repo) {
    GameBoardModel model = new GameBoardModel();
    model.setBoard(repo.getBoard());
    return model;
  }
}
