package com.example.TicTacToeV2.web.model;

import java.util.UUID;

public class WebCurrentGame {

  private UUID id;
  private WebGameBoard webGameBoard;
  private String errorMessage;
  private String gameStatus;

  public WebCurrentGame(UUID id, WebGameBoard webGameBoard) {
    this.id = id;
    this.webGameBoard = webGameBoard;
  }

  public WebCurrentGame() {

  }

  public WebGameBoard getWebGameBoard() {
    return webGameBoard;
  }


  public WebCurrentGame(UUID id) {
    this.id = id;
    webGameBoard = new WebGameBoard();
  }

  public UUID getId() {
    return id;
  }

  public WebGameBoard getBoard() {
    return webGameBoard;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public String getGameStatus() {
    return gameStatus;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void setGameStatus(String gameStatus) {
    this.gameStatus = gameStatus;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setWebGameBoard(WebGameBoard webGameBoard) {
    this.webGameBoard = webGameBoard;
  }

}
