package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbsBasePage{

    public MainPage(WebDriver driver){
        super(driver);
    }
    public MainPage checkTitle(){
      //  WebElement element = driver.findElement(By.xpath())
        return this;
    }
    public MainPage clickTitle(){
        return this;
    }

        public WebElement findCourse(String courseName){
        WebElement element = driver.findElement(By.xpath(String.format("//div[div/h5[text()='%s']]",courseName)));
        return element;
    }
}
