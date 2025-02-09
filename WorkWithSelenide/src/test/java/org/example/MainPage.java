package org.example;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

/**
 * Главная страница appleinsider.ru
 */

public class MainPage {
  private static final SelenideElement searchElement = $x("//input[@type=\"text\"]");

  public MainPage(String url){
    open(url);
  }

  /**
   * Выполняется поиск на сайте нужного текста
   * @param text поисковый текст
   */
  public SearchPage search(String text){
    searchElement.setValue(text);
    searchElement.sendKeys(Keys.ENTER);
    return new SearchPage();
  }
}
