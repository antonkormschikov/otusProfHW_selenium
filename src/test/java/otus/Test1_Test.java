package otus;

import annotations.Driver;
import annotations.Page;
import extensions.UIExtensions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CoursePage;
import pages.MainPage;

import java.util.List;

@ExtendWith(UIExtensions.class)
public class Test1_Test {
private Logger logger = (Logger) LogManager.getLogger(Test1_Test.class);
@Driver
private WebDriver driver;

@Page
private MainPage mainPage;
@Page
private CoursePage coursePage;

/*  Необходимо создать проект в Maven'e и реализовать:
  Фабрику (WebDriverFactory), которая будет получать значение из окружения и запускать соответствующий браузер
  Браузеры: Chrome, Firefox, Opera
  Реализовать подсветку элементов перед нажатием, после нажатия вернуть данные в исходное состояние
  На главно странице Otus'a снизу найти список курсов(популярные курсы, специализации, рекомендации) и реализовать:
  Метод фильтр по названию курса
  Метод выбора курса, стартующего раньше всех/позже всех (при совпадении дат - выбрать любой) при помощи reduce
  Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions*/

  @Test
  public void findCourseTest() {
    ((MainPage) mainPage.open("/"))
            .findCourse("Apache Kafka")
            .checkTitle("Apache Kafka");
  }
  @Test
  public void checkLastStartedCourseTest(){
      ((MainPage)mainPage.open("/"))
              .readCoursesAndFindLastStarted()
              .assertCourseLastStartDate();


    }








  }
}
