package otus;

import annotations.Driver;
import annotations.Page;
import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class Test1_Test {
@Driver
  private WebDriver driver;
@Page
  private MainPage mainPage;




  @Test
    public void findCourseTest(){

    mainPage.open("/");
    mainPage.findCourse("Специализация сетевой инженер")
            .checkTitle("Специализация сетевой инженер");





  }
}
