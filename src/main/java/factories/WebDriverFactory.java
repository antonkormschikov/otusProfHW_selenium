package factories;

import exeptions.BrowserNotSupportedException;
import factories.imp.ChromeConfigure;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory implements IFactory<EventFiringWebDriver>{
    private String browserName = System.getProperty("browser","chrome");

    @Override
    public EventFiringWebDriver create() {
        switch (browserName){
            case "chrome":{
                return new EventFiringWebDriver(new ChromeConfigure().configure());
            }
            default:{
                throw new BrowserNotSupportedException(browserName);
            }

        }

    }
}
