package factories.imp;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfigure implements IBrowserSettings{
  private String browserVersion= System.getProperty("browser.version");


  @Override
    public WebDriver configure() {
    Config config=WebDriverManager.getInstance(DriverManagerType.CHROME)
          .config().setChromeVersion(browserVersion);
    WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--homepage-about:blank");
    chromeOptions.addArguments("--remote-allow-origins=*");

    return new ChromeDriver(chromeOptions);
  }
}
