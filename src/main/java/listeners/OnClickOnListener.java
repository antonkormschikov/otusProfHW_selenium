package listeners;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class OnClickOnListener implements WebDriverListener {

    public void beforeClick(WebElement element, WebDriver driver) {
      ((JavascriptExecutor)driver).executeScript("argument[0].style.border='3px solid red';",element);
    }
}
