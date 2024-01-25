package otus;

import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebDriverListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class Test1_Test {

    private WebDriver driver;
    private WebDriverListener listener;

    @BeforeAll
    public static void manager(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void init(){
        driver=new WebDriverFactory().create();
        //listener = new WebDriverListener().beforeClickOn();
    }
    @AfterEach
    public void close(){
        if (driver!=null){
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void findCourseTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open("/");
        mainPage.findCourse("Специализация сетевой инженер")
                .click();

    }
}
