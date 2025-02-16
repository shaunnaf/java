package com.example.TicTacToeV2.datasource.repository;

import com.example.TicTacToeV2.datasource.model.DataSourceCurrentGame;
import com.example.TicTacToeV2.datasource.model.DataSourceGameBoard;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Repository;

@Repository
public class SavedGames {

  private final ConcurrentMap<UUID, DataSourceCurrentGame> myGames = new ConcurrentHashMap<>();

  public void saveGame(DataSourceCurrentGame game) {
    myGames.put(game.getId(), game);
  }

  public DataSourceCurrentGame getGame(UUID id) {
    return myGames.get(id);
  }

  public boolean containsGame(UUID id) {
    return myGames.containsKey(id);
  }
}

