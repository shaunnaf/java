package com.example.TicTacToeV2.domain.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class DomainCurrentGame {

  private final UUID id;
  private final DomainGameBoard board;

  public DomainCurrentGame(UUID id) {
    this.id = id;
    this.board = new DomainGameBoard(); // Инициализация пустого поля
  }

  public void setCellInBoard(int i, int j, int value) {
    board.setCellInBoard(i, j, value);
  }
}
