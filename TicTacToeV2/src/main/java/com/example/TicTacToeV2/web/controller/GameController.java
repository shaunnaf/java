package com.example.TicTacToeV2.web.controller;


import com.example.TicTacToeV2.domain.model.DomainCurrentGame;
import com.example.TicTacToeV2.domain.model.DomainGameBoard;
import com.example.TicTacToeV2.domain.service.DomainServiceImpl;
import org.springframework.ui.Model;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/game")
public class GameController {

  private DomainServiceImpl gameService;

  @Autowired
  public GameController(DomainServiceImpl gameService) {
    this.gameService = gameService;
  }

  @GetMapping
  public String getStart() {
    return "start";
  }

  @PostMapping("/new")
  public String startNewGame(Model model) {
    UUID gameId = UUID.randomUUID();
    DomainCurrentGame newGame = new DomainCurrentGame(gameId, new DomainGameBoard(new int[3][3]));
    gameService.saveGame(newGame);
    gameService.nextMove(newGame);
    model.addAttribute("gameId", gameId);
    model.addAttribute("board", newGame.getBoard().getBoard());
    return "game";
  }

  @PostMapping("/{id}")
  public String makeMove(@PathVariable UUID id, @RequestParam int row, @RequestParam int col,
      @RequestParam int player, Model model) {
    DomainCurrentGame existingGame = gameService.getGame(id);

    DomainCurrentGame game = new DomainCurrentGame(id, existingGame.getBoard());

    if (game.getBoard().getBoard()[row][col] == 0) {
      game.setCellInBoard(row, col, player);
      gameService.nextMove(game);
    }

    model.addAttribute("gameId", id);
    model.addAttribute("board", game.getBoard().getBoard());
    model.addAttribute("status", gameService.isGameEnd(game));

    return "game";
  }

}
