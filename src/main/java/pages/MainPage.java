package pages;

import com.google.common.util.concurrent.ClosingFuture;
import exeptions.NoFoundCourseExeption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.LinkAndDate;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class MainPage extends AbsBasePage{

  protected WebDriver driver;
  public MainPage(WebDriver driver){
    super(driver);
  }
  /////////!!!!!!!!!!!!!!!!!!!!!!!проверить локатор
    private final String dateLocatorTemplate="//a[href=@href='%s']/div/div/div/div/span[1]";

  public CoursePage findCourse(String courseName){
    String courseLocator=String.format("//div[a/div/div/div/div/h5[text()='%s']]", courseName);
    WebElement element = driver.findElement(By.xpath(courseLocator));

    if  (element  !=null) {
      new Actions(driver).moveToElement(element)
              .click()
              .build()
              .perform();
      return new CoursePage(driver);
    }throw new NoFoundCourseExeption(courseName);
  }
  public CoursePage readCoursesAndFindLastStarted(){
    String link="";
    String dateElement="";
    LocalDate localDate;
    List<LinkAndDate> ldList = null;
    
    List<WebElement> elements = driver.findElements(By.xpath("//a[div/div/div/div/h5]"));

    for (WebElement element: elements){
      link=element.getAttribute("href");
      dateElement=driver.findElement(By.xpath(String.format(dateLocatorTemplate,link))).getText();
      localDate=convertDate(dateElement.split(" ")[1]+" "+dateElement.split(" ")[2]);
      ldList= Arrays.asList(new LinkAndDate(link,localDate));
    }
    if (ldList.size()>0){
      LinkAndDate ldLatestDate = ldList.stream()
              .reduce(LinkAndDate::max)
              .get();

     WebElement element = driver.findElement(By.xpath(String.format(dateLocatorTemplate,ldLatestDate.getLink())));
        new Actions(driver).moveToElement(element)
                .click()
                .build()
                .perform();

    }
  return new CoursePage(driver);

  }





}
