package factories;

import annotations.Driver;
import annotations.Page;
import org.openqa.selenium.WebDriver;
import pages.CoursePage;
import pages.MainPage;

import java.lang.annotation.Annotation;

public class PageFactory{
    public PageFactory(){

    }


    public <T> Object newPage(WebDriver driver, String clazz) {
        switch (clazz){
            case "MainPage":{
                return new MainPage();
            }
            case "CourcePage":{
                return new CoursePage();
            }
            default:{
                return null;
            }
        }



    }
}





