import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;


public class ResumePage {

  private final SelenideElement genderElement = $x(
      "//span[@data-qa='resume-personal-gender']");
  private final SelenideElement ageElement = $x(
      "//span[@data-qa='resume-personal-age']/span");
  private final SelenideElement cityElement = $x(
      "//span[@data-qa='resume-personal-address']");
  private final SelenideElement liveData = $x(
      "//span[@data-qa='resume-personal-address']/ancestor::p");
  private final ElementsCollection languageData = $$x(
      "//p[@data-qa=\"resume-block-language-item\"]");

  public static final String GENDER = "Пол";
  public static final String AGE = "Возраст";
  public static final String CITY = "Город";
  public static final String READY_TO_RELOCATE = "Готовность к переезду";
  public static final String LEVEL_ENGLISH_LANGUAGE = "Уровень английского языка";


  public ResumePage(String URL) {
    Selenide.open(URL);
  }

  public String getGender() {
    return genderElement.getText().equals("Мужчина") ? "М" : "Ж";
  }

  public int getAge() {
    return Integer.parseInt(ageElement.getText().replaceAll("[^0-9]", ""));
  }

  public String getCity() {
    return cityElement.getText();
  }

  public String[] getLiveData() {
    return liveData.getText().split(", ");
  }

  public boolean getReadyToRelocate() {
    return !getLiveData()[1].equals("не готов к переезду");
  }

  public String getLevelEnglishLanguage() {
    return languageData.get(1).getText().split(" — ")[1];
  }

  public Map<String, Object> mapWithData() {
    return new HashMap<>() {
      {
        put(GENDER, getGender());
        put(AGE, getAge());
        put(CITY, getCity());
        put(READY_TO_RELOCATE, getReadyToRelocate());
        put(LEVEL_ENGLISH_LANGUAGE, getLevelEnglishLanguage());
      }
    };
  }

}
