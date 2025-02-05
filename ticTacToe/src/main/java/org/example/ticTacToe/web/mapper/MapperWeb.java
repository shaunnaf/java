package org.example.ticTacToe.web.mapper;

import org.example.ticTacToe.domain.model.CurrentGameModel;
import org.example.ticTacToe.domain.model.GameBoardModel;
import org.example.ticTacToe.web.model.GameBoardCurrWeb;
import org.example.ticTacToe.web.model.GameBoardWeb;

public class MapperWeb {

  public CurrentGameModel toDomain(GameBoardCurrWeb web) {
    CurrentGameModel model = new CurrentGameModel();
    model.setId(web.getId());
    model.setBoard(toDomain(web.getCurrBoard()));
    return model;
  }

  private GameBoardModel toDomain(GameBoardWeb web) {
    GameBoardModel model = new GameBoardModel();
    model.setBoard(web.getGameBoard());
    return model;
  }

  public GameBoardCurrWeb toEntity(CurrentGameModel model) {
    GameBoardCurrWeb entity = new GameBoardCurrWeb();
    entity.setId(model.getId());
    entity.setCurrBoard(toEntity(model.getBoard()));
    return entity;
  }

  private GameBoardWeb toEntity(GameBoardModel model) {
    GameBoardWeb web = new GameBoardWeb();
    web.setGameBoard(model.getBoard());
    return web;
  }
}
