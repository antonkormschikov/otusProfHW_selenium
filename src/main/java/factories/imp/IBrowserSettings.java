package factories.imp;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IBrowserSettings {
  WebDriver configure() throws MalformedURLException;
}
