package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbsBasePage{

    public MainPage(WebDriver driver){
        super(driver);
    }
    public MainPage checkTitle(){
        return this;
    }
    public MainPage clickTitle(){
        return this;
    }
    public MainPage check(){
        clickTitle();
        return checkTitle();

    }
}
