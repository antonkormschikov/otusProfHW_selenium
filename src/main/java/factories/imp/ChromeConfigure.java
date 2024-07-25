package factories.imp;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ChromeConfigure implements IBrowserSettings{
  private String browserVersion= System.getProperty("browser.version","123.0");


  @Override
    public WebDriver configure() throws MalformedURLException {
    if (System.getProperty("mode","local").toString().equals("remote")) {
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setCapability("browserVersion", "123.0");
      chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
        /* How to add test badge */
        put("name", "Test badge...");
        /* How to set session timeout */
        put("sessionTimeout", "15m");
System.out.println("remote mode");
        /* How to set timezone */
        put("env", new ArrayList<String>() {{
          add("TZ=UTC");
        }});

        /* How to add "trash" button */
        put("labels", new HashMap<String, Object>() {{
          put("manual", "true");
        }});

        /* How to enable video recording */
        put("enableVideo", true);
      }});
      return  new RemoteWebDriver(new URL("http://127.0.0.1/wd/hub"), chromeOptions);
    } else {

      System.out.println("local  mode");
      WebDriverManager.chromedriver().driverVersion(browserVersion).setup();
      ChromeOptions chromeOptions = new ChromeOptions();
      //chromeOptions.addArguments("--ignore-certificate-errors");
      chromeOptions.addArguments("--start-maximized");
      chromeOptions.addArguments("--homepage-about:blank");
      //chromeOptions.addArguments("--remote-allow-origins=*");
      return new ChromeDriver(chromeOptions);
}




  }
}
