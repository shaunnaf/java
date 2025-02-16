package org.example.ticTacToe.datasource.mapper;

import org.example.ticTacToe.datasource.model.GameBoardRepo;
import org.example.ticTacToe.domain.model.GameBoardModel;

interface MapperGameBoard {

  GameBoardRepo toEntity(GameBoardModel model);

  GameBoardModel toDomain(GameBoardRepo repo);

}
