package org.example.ticTacToe.datasource.mapper;

import org.example.ticTacToe.datasource.model.CurrentGameRepo;
import org.example.ticTacToe.domain.model.CurrentGameModel;

public interface MapperCurrGame {

  CurrentGameRepo toEntity(CurrentGameModel model);

  CurrentGameModel toDomain(CurrentGameRepo repo);

}
