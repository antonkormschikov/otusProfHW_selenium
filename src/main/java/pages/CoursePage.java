package pages;

import annotations.Driver;
import annotations.Page;
import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class CoursePage extends AbsBasePage{
  private Logger logger = (Logger) LogManager.getLogger(CoursePage.class);

  public CoursePage(WebDriver driver) {
    super(driver);
  }
  @Page
  private MainPage mainPage;


  public void checkTitle(String courseName){
    WebElement element = driver.findElement(By.xpath("//h1"));
    Assertions.assertEquals(courseName,element.getText());
  }

  public void assertCourseLastStartDate(){
    WebElement element = driver.findElement(By.xpath("//main/div/section/div/div/div[1]/p"));
    Assertions.assertTrue(convertDate(element.getText()).isAfter(LocalDate.now()));

  }
}
