package com.example.TicTacToeV2.domain.service;

import com.example.TicTacToeV2.datasource.repository.RepositoryGames;
import com.example.TicTacToeV2.domain.model.DomainCurrentGame;
import com.example.TicTacToeV2.domain.model.DomainGameBoard;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceImpl implements DomainService {

  private final RepositoryGames repository;

  public DomainServiceImpl(RepositoryGames repository) {
    this.repository = repository;
  }

  @Override
  public DomainCurrentGame nextMove(DomainCurrentGame prevBoard) {
    DomainGameBoard board = prevBoard.getBoard();
    int[][] cells = board.getBoard();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (cells[i][j] == 0) {
          cells[i][j] = 2;
          board.setBoard(cells);
          return new DomainCurrentGame(prevBoard.getId(), board);
        }
      }
    }
    return prevBoard;
  }

  @Override
  public Boolean validCurrentGame(DomainCurrentGame game) {
    return repository.containsGame(game.getId());
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

  public DomainCurrentGame getGame(UUID id) {
    return new DomainCurrentGame(id, repository.getGame(id));
  }

  public void saveGame(DomainCurrentGame game) {
    repository.saveGame(game);
  }

}
