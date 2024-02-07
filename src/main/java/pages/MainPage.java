package pages;

import exeptions.NoFoundCourseExeption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Objects;

public class MainPage extends AbsBasePage{

  protected WebDriver driver;
  public MainPage(WebDriver driver){
    super(driver);
  }




  public CoursePage findCourse(String courseName){
    String courseLocator=String.format("//div[a/div/div/div/div/h5[text()='%s']]",courseName);
    WebElement element = driver.findElement(By.xpath(courseLocator));

    if  (element  !=null) {
      new Actions(driver).moveToElement(element)
              .click()
              .build()
              .perform();
      return new CoursePage(driver);
    }throw new NoFoundCourseExeption(courseName);
  }
  public List<WebElement> readCourses(){
    List<WebElement> listLinksElements = driver.findElements(By.xpath("//a[div/div/div/div/h5]"));
    return listLinksElements;

  }

}
