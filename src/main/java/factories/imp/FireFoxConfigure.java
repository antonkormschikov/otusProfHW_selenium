package factories.imp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxConfigure implements IBrowserSettings{
    private String browserVersion= System.getProperty("browser.version");
    @Override
    public WebDriver configure() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--homepage-about:blank");
        WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();
        return new ChromeDriver(firefoxOptions);
    }
}
