package otus;

import annotations.Driver;
import annotations.Page;
import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.util.List;

@ExtendWith(UIExtensions.class)
public class Test1_Test {
@Driver
private WebDriver driver;
/*@Page  private MainPage mainPage;*/


  @Test
    public void findCourseTest(){
    MainPage mainPage = new MainPage(driver);
    mainPage.open("/");
    mainPage.readCourses();
    mainPage.findCourse("Java QA Engineer. Professional");







  }
}
