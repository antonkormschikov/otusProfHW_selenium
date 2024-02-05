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

  public void checkTitle(String courseName){
    WebElement element = driver.findElement(By.xpath("//h1"));
    Assertions.assertEquals(courseName,element.getText());
  }
  public void findCourse(List<WebElement> list,String courseName){
    boolean findCourceIsTrue=false;
    for (WebElement element:list) {
      if (element.getText().equals(courseName)){
        new Actions(driver).moveToElement(element)
                .click()
                .perform();
        checkTitle(courseName);
      }
      throw new NoFoundCourseExeption(courseName);
    }


  }
  public List<WebElement> readCourses(){
    List<WebElement> listElements = driver.findElements("");
    return listElements;

  }

}
