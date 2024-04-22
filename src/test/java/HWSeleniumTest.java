import annotations.Driver;
import annotations.Page;
import extensions.UIExtensions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CoursePage;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class HWSeleniumTest {

  private Logger logger = (Logger) LogManager.getLogger(HWSeleniumTest.class);
  @Driver
  private WebDriver driver;
  @Page
  private MainPage mainPage;

  @Page
  private CoursePage coursePage;

  /*Необходимо создать проект в Maven'e и реализовать:
  Фабрику (WebDriverFactory), которая будет получать значение из окружения и запускать соответствующий браузер
  Браузеры: Chrome, Firefox, Opera
  Реализовать подсветку элементов перед нажатием, после нажатия вернуть данные в исходное состояние
  На главно странице Otus'a снизу найти список курсов(популярные курсы, специализации, рекомендации) и реализовать:
  Метод фильтр по названию курса
  Метод выбора курса, стартующего раньше всех/позже всех (при совпадении дат - выбрать любой) при помощи reduce
  Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions*/

  @DisplayName("Тест - фильтр по названию курса")
  @Test
  public void findCourseTest() {

    mainPage.open("/");
    mainPage.findCourse("Machine Learning")
      .checkTitle("Machine Learning");
  }
  @DisplayName("Тест - выбор курса стартующего позже всех")
  @Test
  public void checkLastStartedCourseTest(){
    mainPage.open("/");
    mainPage.readCoursesAndFindLastStarted()
      .assertCourseLastStartDate();
  }
}

