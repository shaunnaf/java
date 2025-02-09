package org.example;

import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

public class SearchPage {
  private final ElementsCollection allFoundEquals = $$x("//h2//a");

  /**
   * Возвращает href из первой статьи
   * @return
   */
  public String returnFirst(){
    return allFoundEquals.first().getAttribute("href");
  }

}
