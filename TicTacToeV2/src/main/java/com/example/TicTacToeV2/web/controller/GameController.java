package com.example.TicTacToeV2.web.controller;

import static com.example.TicTacToeV2.web.mapper.WebDomainMapper.toWebCurrentGame;

import com.example.TicTacToeV2.domain.model.DomainCurrentGame;
import com.example.TicTacToeV2.domain.service.DomainServiceImpl;
import com.example.TicTacToeV2.web.model.WebCurrentGame;
import com.example.TicTacToeV2.web.model.WebGameBoard;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

  private final DomainServiceImpl gameService;

  public GameController(DomainServiceImpl gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/new")
  public ResponseEntity<WebCurrentGame> createNewGame() {
    WebCurrentGame webCurrentGame = new WebCurrentGame(UUID.randomUUID());
    gameService.addNewGame(webCurrentGame);
    return ResponseEntity.ok(webCurrentGame);
  }

  @PostMapping("{id}")
  public ResponseEntity<WebCurrentGame> updateGame(@PathVariable UUID id,
      @RequestBody WebCurrentGame webCurrentGame) {

    if (!gameService.gameExists(id)) {
      return ResponseEntity.badRequest().body(new WebCurrentGame(id, new WebGameBoard()));
    }

    DomainCurrentGame domainGame = gameService.getGameById(id);
    if (domainGame == null) {
      return ResponseEntity.badRequest().body(new WebCurrentGame(id, new WebGameBoard()));
    }
    WebCurrentGame webGame = toWebCurrentGame(gameService.nextMove(domainGame));

    String gameStatus = gameService.isGameEnd(domainGame);
    webGame.setGameStatus(gameStatus);

    return ResponseEntity.ok(webGame);
  }


}
