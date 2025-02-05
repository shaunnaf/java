package org.example.ticTacToe.datasource.mapper;

import org.example.ticTacToe.datasource.model.GameBoardRepo;
import org.example.ticTacToe.domain.model.GameBoardModel;

public interface MapperGameBoard {

  GameBoardRepo toEntity(GameBoardModel model);

  GameBoardModel toDomain(GameBoardRepo repo);

}
