package modules;

import annotations.Driver;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import pages.CoursePage;
import pages.MainPage;

public class GuicePagesModule extends AbstractModule{

    @Provides
    @Singleton
    public MainPage getMainPage(){
        return new MainPage();
    }
    @Provides
    @Singleton
    public CoursePage getCourcePage(){
        return new CoursePage();
    }
}
