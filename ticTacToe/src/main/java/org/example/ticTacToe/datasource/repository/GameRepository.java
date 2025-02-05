package org.example.ticTacToe.datasource.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.example.ticTacToe.domain.model.GameBoardModel;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {

  private final Map<Long, GameBoardModel> games = new ConcurrentHashMap<>();

  public void saveGame(Long id, GameBoardModel board) {
    games.put(id, board);
  }

  public GameBoardModel loadGame(Long id) {
    return games.get(id);
  }
}
