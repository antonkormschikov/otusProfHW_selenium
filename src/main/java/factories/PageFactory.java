package factories;

import annotations.Driver;
import annotations.Page;
import org.openqa.selenium.WebDriver;
import pages.CoursePage;
import pages.MainPage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class PageFactory{
  public PageFactory(){

  }


  public <T> Object newPage(WebDriver driver, Type type) {
    String i = type.getTypeName().toString();
    switch (i){
      case "pages.MainPage":{
        return new MainPage(driver);
      }
      case "pages.CourcePage":{
        return new CoursePage(driver);
      }
      default:{
        return null;
      }
    }
  }
}





