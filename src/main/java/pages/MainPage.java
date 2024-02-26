package pages;

import com.google.common.util.concurrent.ClosingFuture;
import exeptions.NoFoundCourseExeption;
import org.checkerframework.checker.units.qual.C;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.graalvm.compiler.lir.sparc.SPARCMove;
import org.junit.jupiter.api.Assertions;
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
  private final String dateLocatorTemplate="//a[@href='%s' and @class='dod_new-event']/div/div[@class='dod_new-event__bottom']/div/span[1]/span[@class='dod_new-event__date-text']";

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
      localDate=convertDate(dateElement);
      ldList= Arrays.asList(new LinkAndDate(link,localDate));
    }
    if (ldList.size()>0){
      LinkAndDate ldLatestDate = ldList.stream()
              .reduce(LinkAndDate::max)
              .get();

     WebElement element = driver.findElement("?????????"+ldLatestDate.getLink()+"222222222");

        new Actions(driver).moveToElement(element)
                .click()
                .build()
                .perform();


    }


  return new CoursePage(driver);

  }





}
