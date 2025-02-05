package org.example.ticTacToe.domain.service;

import org.example.ticTacToe.datasource.repository.GameRepository;
import org.example.ticTacToe.domain.model.GameBoardModel;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

  private final GameRepository gameRepository;
  private final Random random = new Random(); // Генератор случайных ходов

  public GameServiceImpl(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  @Override
  public GameBoardModel nextMove(GameBoardModel currentBoard) {
    if (isEndGame(currentBoard)) {
      return currentBoard; // Игра уже закончена
    }

    // Выполняем случайный ход за компьютер
    int[][] board = currentBoard.getBoard();
    for (int i = 0; i < 9; i++) { // До 9 попыток найти свободное место
      int row = random.nextInt(3);
      int col = random.nextInt(3);

      if (board[row][col] == ' ') { // Если клетка свободна
        board[row][col] = 'O'; // Компьютер играет 'O'
        break;
      }
    }

    currentBoard.setBoard(board);
    return currentBoard;
  }

  @Override
  public boolean validBoard(GameBoardModel currentBoard) {
    int[][] board = currentBoard.getBoard();
    int countX = 0, countO = 0;

    for (int[] row : board) {
      for (int cell : row) {
        if (cell == 'X') {
          countX++;
        }
        if (cell == 'O') {
          countO++;
        }
      }
    }

    // Проверяем, что X не больше чем O + 1 (нельзя делать 2 хода подряд)
    return countX == countO || countX == countO + 1;
  }

  @Override
  public boolean isEndGame(GameBoardModel currentBoard) {
    int[][] board = currentBoard.getBoard();

    // Проверяем строки, столбцы и диагонали на победу
    for (int i = 0; i < 3; i++) {
      if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        return true;
      }
      if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        return true;
      }
    }

    if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      return true;
    }
    if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
      return true;
    }

    // Проверяем, остались ли пустые клетки
    for (int[] row : board) {
      for (int cell : row) {
        if (cell == ' ') {
          return false; // Игра продолжается
        }
      }
    }

    return true; // Если нет пустых клеток — ничья
  }
}
