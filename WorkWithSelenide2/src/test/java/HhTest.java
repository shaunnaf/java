import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HhTest {

  private final static String URL = "https://hh.ru/resume/0d0da45b0008b6bd1f0039ed1f6e4c524b7276";


  @Test
  public void MainTest() {
    ResumePage resumePage = new ResumePage(URL);

    Assertions.assertEquals("М", resumePage.getGender());

    Assertions.assertEquals(28, resumePage.getAge());

    Assertions.assertEquals("Москва", resumePage.getCity());

    Assertions.assertFalse(resumePage.getReadyToRelocate());

    Assertions.assertEquals("B2", resumePage.getLevelEnglishLanguage());
  }
}
