package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.AbsBaseUtils;

public abstract class AbsBasePage<T> extends AbsBaseUtils {
  private WebDriver driver;
  public AbsBasePage(WebDriver driver){
    super(driver);
   // PageFactory.initElements(driver,this);
      }
  private final String baseUrl=System.getProperty("base.url","https://otus.ru");
  public T open(String path) {
    String a=baseUrl+path;
    driver.get(a);
    return (T)this;
  }
}


