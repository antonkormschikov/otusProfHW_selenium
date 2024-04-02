import annotations.Driver;
import annotations.Page;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.google.inject.Inject;
import extensions.UIExtensions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CoursePage;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class HWSeleniumTest {

  private Logger logger = (Logger) LogManager.getLogger(HWSeleniumTest.class);
  @Driver
  private WebDriver driver;


  @Inject
  private MainPage mainPage;
  @Inject
  private CoursePage coursePage;

  /*Необходимо создать проект в Maven'e и реализовать:
  Фабрику (WebDriverFactory), которая будет получать значение из окружения и запускать соответствующий браузер
  Браузеры: Chrome, Firefox, Opera
  Реализовать подсветку элементов перед нажатием, после нажатия вернуть данные в исходное состояние
  На главно странице Otus'a снизу найти список курсов(популярные курсы, специализации, рекомендации) и реализовать:
  Метод фильтр по названию курса
  Метод выбора курса, стартующего раньше всех/позже всех (при совпадении дат - выбрать любой) при помощи reduce
  Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions*/

  @Test
  public void findCourseTest() {
//    MainPage mainPage = new MainPage(driver);

  mainPage.open("/");
  //  mainPage.findCourse("Apache Kafka")
         //   .checkTitle("Apache Kafka");
  }

 // @Test
 // public void checkLastStartedCourseTest(){
    //mainPage.open("/");
    //mainPage.readCoursesAndFindLastStarted()
       //       .assertCourseLastStartDate();
  //}

  /*@Test
  public void check() throws InterruptedException {
    MainPage mainPage = new MainPage(driver);
    mainPage.open("/");
    WebElement element = driver.findElement(By.xpath("//a[div/div/div/div/h5]/div/div"));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].style.border='3px solid red'",element);
    Thread.sleep(5000);
  }*/


}

