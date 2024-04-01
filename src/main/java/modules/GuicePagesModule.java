package modules;

import annotations.Driver;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class GuicePagesModule extends AbstractModule{

    @Driver
    private WebDriver driver;

    @Provides
    @Singleton
    public MainPage getMainPage(){
        return new MainPage(driver);

    }
}
