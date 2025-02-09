package org.example;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AppleTest {
  private final static String BASE_URL = "https://appleinsider.ru";
  private final static String FOUND_STRING = "Чем iPhone 13 отличается от iPhone 12";

  @Test
  public void checkRef() {
    assertTrue(new MainPage(BASE_URL)
        .search(FOUND_STRING)
        .returnFirst()
        .contains("iphone-13"));
  }
}
