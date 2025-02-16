package com.example.TicTacToeV2.domain.service;

import static com.example.TicTacToeV2.datasource.mapper.DataSourceDomainMapper.toDataSourceCurrentGame;
import static com.example.TicTacToeV2.datasource.mapper.DataSourceDomainMapper.toDomainCurrentGame;
import static com.example.TicTacToeV2.datasource.mapper.DataSourceDomainMapper.toDomainGameBoard;
import static com.example.TicTacToeV2.web.mapper.WebDomainMapper.toDomainCurrentGame;


import com.example.TicTacToeV2.datasource.model.DataSourceCurrentGame;
import com.example.TicTacToeV2.datasource.model.DataSourceGameBoard;
import com.example.TicTacToeV2.datasource.repository.SavedGames;
import com.example.TicTacToeV2.domain.model.DomainCurrentGame;
import com.example.TicTacToeV2.web.model.WebCurrentGame;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceImpl implements DomainService {

  private final SavedGames repository;

  public DomainServiceImpl(SavedGames repository) {
    this.repository = repository;
  }

  @Override
  public DomainCurrentGame nextMove(DomainCurrentGame prevBoard) {
    if (!repository.containsGame(prevBoard.getId())) {
      throw new IllegalArgumentException("Game not found: " + prevBoard.getId());
    }

    DataSourceCurrentGame savedGame = repository.getGame(prevBoard.getId());
    DomainCurrentGame currentGame = toDomainCurrentGame(savedGame);

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (currentGame.getBoard().getBoard()[i][j] == 0) {
          currentGame.setCellInBoard(i, j, 2);
          repository.saveGame(toDataSourceCurrentGame(currentGame));
          return currentGame;
        }
      }
    }
    return currentGame;
  }


  @Override
  public Boolean validCurrentGame(DomainCurrentGame board) {
    //todo
    return true;
  }

  @Override
  public String isGameEnd(DomainCurrentGame board) {
    for (int i = 0; i < 3; i++) {
      if ((board.getBoard().getBoard()[i][0] == 1 && board.getBoard().getBoard()[i][1] == 1
          && board.getBoard().getBoard()[i][2] == 1) || (board.getBoard().getBoard()[0][i] == 1
          && board.getBoard().getBoard()[1][i] == 1
          && board.getBoard().getBoard()[2][i] == 1)) {
        return "WIN";
      } else if ((board.getBoard().getBoard()[i][0] == 2 && board.getBoard().getBoard()[i][1] == 2
          && board.getBoard().getBoard()[i][2] == 2) || (board.getBoard().getBoard()[1][i] == 2
          && board.getBoard().getBoard()[0][i] == 2
          && board.getBoard().getBoard()[2][i] == 2)) {
        return "LOSE";
      }
    }
    if ((board.getBoard().getBoard()[0][0] == 1 && board.getBoard().getBoard()[1][1] == 1
        && board.getBoard().getBoard()[2][2] == 1) || (board.getBoard().getBoard()[0][2] == 1
        && board.getBoard().getBoard()[1][1] == 1 && board.getBoard().getBoard()[2][0] == 1)) {
      return "WIN";
    }
    if ((board.getBoard().getBoard()[0][0] == 2 && board.getBoard().getBoard()[1][1] == 2
        && board.getBoard().getBoard()[2][2] == 2) || (board.getBoard().getBoard()[0][2] == 2
        && board.getBoard().getBoard()[1][1] == 2 && board.getBoard().getBoard()[2][0] == 2)) {
      return "LOSE";
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board.getBoard().getBoard()[i][j] == 0) {
          return null;
        }
      }
    }
    return "DRAW";
  }

  public void addNewGame(WebCurrentGame webCurrentGame) {
    repository.saveGame(toDataSourceCurrentGame(toDomainCurrentGame(webCurrentGame)));
  }

  public boolean gameExists(UUID id) {
    return repository.getGame(id) != null;
  }

  public DomainCurrentGame getGameById(UUID id) {
    DataSourceGameBoard dataSourceGameBoard = repository.getGame(id).getBoard();
    if (dataSourceGameBoard == null) {
      return null;
    }
    return new DomainCurrentGame(id, toDomainGameBoard(dataSourceGameBoard));
  }


}
