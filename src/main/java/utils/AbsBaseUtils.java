package utils;

import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

public abstract class  AbsBaseUtils {
  protected WebDriver driver;


  public AbsBaseUtils(WebDriver driver){
    this.driver=driver;
  }

}


