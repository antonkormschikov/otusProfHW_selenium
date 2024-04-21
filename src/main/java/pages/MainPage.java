package pages;

import annotations.Driver;
import annotations.Page;
import com.google.common.util.concurrent.ClosingFuture;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import exeptions.NoFoundCourseExeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.LinkAndDate;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class MainPage extends AbsBasePage{

    public MainPage(WebDriver driver) {
     super(driver);
    }

  @Page
  private CoursePage coursePage;

  private Logger logger = (Logger) LogManager.getLogger(MainPage.class);
  private final String dateLocatorTemplate="//a[@href='%s']/div/div/div/div/span[1]";



  public CoursePage findCourse(String courseName){
    String courseLocator=String.format("//div[a/div/div/div/div/h5[text()='%s']]", courseName);
    WebElement element = driver.findElement(By.xpath(courseLocator));

    if  (element  !=null) {
      new Actions(driver).moveToElement(element)
              .click()
              .build()
              .perform();

      return coursePage;
    }throw new NoFoundCourseExeption(courseName);
  }
  public CoursePage readCoursesAndFindLastStarted(){
    String link="";
    String dateElement="";
    LocalDate localDate;
    List<LinkAndDate> ldList = new ArrayList<>();
    List<WebElement> elements = driver.findElements(By.xpath("//a[div/div/div/div/h5]"));

    for (WebElement element: elements){
      try {
        link = element.getAttribute("href");
        dateElement = driver.findElement(By.xpath(String.format(dateLocatorTemplate, link))).getText();
        localDate = convertDate(dateElement.split(" ")[1] + " " + dateElement.split(" ")[2]);
        ldList.add(new LinkAndDate(link, localDate));
      } catch (RuntimeException e){
        logger.info(e.toString());
      }
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
    return coursePage;

  }





}
