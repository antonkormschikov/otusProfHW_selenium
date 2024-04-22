package factories.imp;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxConfigure implements IBrowserSettings{
  private String browserVersion= System.getProperty("browser.version","124");
  @Override
    public WebDriver configure() {
    WebDriverManager.firefoxdriver().driverVersion(browserVersion).setup();
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.addArguments("--start-maximized");
    firefoxOptions.addArguments("--homepage-about:blank");
    //firefoxOptions.addArguments("--remote-allow-origins=*");


    return new FirefoxDriver(firefoxOptions);
  }
}
