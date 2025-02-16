package com.example.TicTacToeV2.datasource.mapper;

import com.example.TicTacToeV2.datasource.model.DataSourceCurrentGame;
import com.example.TicTacToeV2.datasource.model.DataSourceGameBoard;
import com.example.TicTacToeV2.domain.model.DomainCurrentGame;
import com.example.TicTacToeV2.domain.model.DomainGameBoard;

public class DataSourceDomainMapper {

  public static DomainGameBoard toDomainGameBoard(DataSourceGameBoard dataSourceGameBoard) {
    return new DomainGameBoard(dataSourceGameBoard.getBoard());
  }

  public static DataSourceGameBoard toDataSourceGameBoard(DomainGameBoard domainGameBoard) {
    return new DataSourceGameBoard(domainGameBoard.getBoard());
  }

  public static DataSourceCurrentGame toDataSourceCurrentGame(DomainCurrentGame domainCurrentGame) {
    return new DataSourceCurrentGame(domainCurrentGame.getId(),
        toDataSourceGameBoard(domainCurrentGame.getBoard()));
  }

  public static DomainCurrentGame toDomainCurrentGame(DataSourceCurrentGame dataSourceCurrentGame) {
    return new DomainCurrentGame(dataSourceCurrentGame.getId(),
        toDomainGameBoard(dataSourceCurrentGame.getBoard()));
  }
}

