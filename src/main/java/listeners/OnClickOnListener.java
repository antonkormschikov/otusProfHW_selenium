package listeners;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class OnClickOnListener implements WebDriverListener {

  private WebDriver driver;


 /* @Override
  public void beforeClick(WebElement element) {
    ((JavascriptExecutor)driver).executeScript(String.format("%s.style.border='3px solid red';",element));
    //WebDriverListener.super.beforeClick(element);
  }*/
}
