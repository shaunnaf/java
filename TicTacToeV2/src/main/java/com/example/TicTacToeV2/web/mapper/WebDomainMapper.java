package com.example.TicTacToeV2.web.mapper;

import com.example.TicTacToeV2.domain.model.DomainCurrentGame;
import com.example.TicTacToeV2.domain.model.DomainGameBoard;
import com.example.TicTacToeV2.domain.service.DomainServiceImpl;
import com.example.TicTacToeV2.web.model.WebCurrentGame;
import com.example.TicTacToeV2.web.model.WebGameBoard;

public class WebDomainMapper {

  public static DomainGameBoard toDomainGameBoard(WebGameBoard webGameBoard) {
    return new DomainGameBoard(webGameBoard.getBoard());
  }

  public static WebGameBoard toWebGameBoard(DomainGameBoard domainGameBoard) {
    return new WebGameBoard(domainGameBoard.getBoard());
  }

  public static DomainCurrentGame toDomainCurrentGame(WebCurrentGame webCurrentGame) {
    return new DomainCurrentGame(webCurrentGame.getId(),
        toDomainGameBoard(webCurrentGame.getBoard()));
  }

  public static WebCurrentGame toWebCurrentGame(DomainCurrentGame domainCurrentGame) {
    return new WebCurrentGame(domainCurrentGame.getId(),
        toWebGameBoard(domainCurrentGame.getBoard()));
  }
}
