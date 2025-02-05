package org.example.ticTacToe.web.controller;

import org.example.ticTacToe.domain.model.GameBoardModel;
import org.example.ticTacToe.domain.service.GameService;
import org.example.ticTacToe.web.model.GameBoardWeb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/game")
public class GameController {

  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping("/{gameId}")
  public ResponseEntity<GameBoardWeb> updateGame(
      @PathVariable Long gameId,
      @RequestBody GameBoardWeb currentBoard) {

    if (!gameService.validBoard(currentBoard)) {
      return ResponseEntity.badRequest().build();
    }

    if (gameService.isEndGame(currentBoard)) {
      return ResponseEntity.ok(currentBoard);
    }

    GameBoardModel updatedBoard = gameService.nextMove(currentBoard);

    return ResponseEntity.ok(updatedBoard);
  }
}
