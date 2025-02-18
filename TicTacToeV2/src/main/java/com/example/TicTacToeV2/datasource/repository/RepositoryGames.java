package com.example.TicTacToeV2.datasource.repository;

import com.example.TicTacToeV2.domain.model.DomainCurrentGame;
import com.example.TicTacToeV2.domain.model.DomainGameBoard;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryGames {

  private final ConcurrentMap<UUID, DomainGameBoard> myGames = new ConcurrentHashMap<>();

  public void saveGame(DomainCurrentGame game) {
    myGames.put(game.getId(), game.getBoard());
  }

  public DomainGameBoard getGame(UUID id) {
    return myGames.get(id);
  }

  public boolean containsGame(UUID id) {
    return myGames.containsKey(id);
  }
}

