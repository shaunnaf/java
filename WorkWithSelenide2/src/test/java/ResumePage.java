import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import java.security.SecureRandom;


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
}
