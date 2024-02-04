package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbsBasePage{

  protected WebDriver driver;
  public MainPage(WebDriver driver){
    super(driver);
  }

  public void checkTitle(String courseName){
    WebElement element = driver.findElement(By.xpath("//h1"));
    Assertions.assertEquals(courseName,element.getText());
  }
  public MainPage findCourse(String courseName){
    WebElement element = driver.findElement(By.xpath(String.format("//div[div/h5[text()='%s']]",courseName)));
    element.click();
    return this;
  }
}
