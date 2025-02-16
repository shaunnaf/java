package com.example.TicTacToeV2.domain.service;

import com.example.TicTacToeV2.domain.model.DomainCurrentGame;

public interface DomainService {

  DomainCurrentGame nextMove(DomainCurrentGame prevBoard);

  Boolean validCurrentGame(DomainCurrentGame board);

  String isGameEnd(DomainCurrentGame board);
}
