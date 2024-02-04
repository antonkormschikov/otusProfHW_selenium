package factories;

import exeptions.BrowserNotSupportedException;
import factories.imp.ChromeConfigure;
import factories.imp.FireFoxConfigure;
import listeners.OnClickOnListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;


public class WebDriverFactory implements IFactory {
  private String browserName = System.getProperty("browser","chrome").toLowerCase();

  @Override
    public WebDriver create() {
    switch (browserName){
      case "chrome":{
        return new EventFiringDecorator(new OnClickOnListener()).decorate(new ChromeConfigure().configure());

      }
      case "firefox":{
        return new EventFiringDecorator(new OnClickOnListener()).decorate(new FireFoxConfigure().configure());

      }
      default:{
        throw new BrowserNotSupportedException(browserName);
      }

    }

  }
}
