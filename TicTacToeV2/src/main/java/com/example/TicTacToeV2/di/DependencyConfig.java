package com.example.TicTacToeV2.di;

import com.example.TicTacToeV2.datasource.repository.SavedGames;
import com.example.TicTacToeV2.domain.service.DomainServiceImpl;
import org.springframework.context.annotation.Bean;

public class DependencyConfig {

  @Bean
  public SavedGames savedGames() {
    return new SavedGames();
  }

  @Bean
  public DomainServiceImpl domainService(SavedGames savedGames) {
    return new DomainServiceImpl(savedGames);
  }
}
