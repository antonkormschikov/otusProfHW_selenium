package otus;

import annotations.Driver;

import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(UIExtensions.class)
public class TestGoogle_Test {
    @Driver
    WebDriver driver;

    private final String url ="https://otus.ru/"; // System.getProperty("base.url",) ;


    @Test
    public void gg (){
        driver.get(url);

    }

}
