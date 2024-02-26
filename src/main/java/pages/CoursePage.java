package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class CoursePage extends AbsBasePage{
    protected WebDriver driver;

    public CoursePage(WebDriver driver) {
        super(driver);
    }
    public void checkTitle(String courseName){
        WebElement element = driver.findElement(By.xpath("//h1"));
        Assertions.assertEquals(courseName,element.getText());
    }


    public void assertCourseLastStartDate(){
        WebElement element = driver.findElement(By.xpath("какая-то дата"));
        Assertions.assertTrue(convertDate(element.getText()).isAfter(LocalDate.now()));


    }
}
