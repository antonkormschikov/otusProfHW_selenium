package otus;

import annotations.Driver;
import annotations.Page;
import extensions.UIExtensions;
import listeners.WebDriverListener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class Test1_Test {
    @Driver
    private WebDriver driver;

    //private WebDriverListener listener;
    @Page
    private MainPage mainPage;



    @Test
    public void findCourseTest(){
      mainPage
          .open("/");
          mainPage.findCourse("Специализация сетевой инженер");



    }
}
