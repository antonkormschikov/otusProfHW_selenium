package pages;

import org.openqa.selenium.WebDriver;
import utils.AbsBaseUtils;

public abstract class AbsBasePage<T> extends AbsBaseUtils {
    protected WebDriver driver;
    public AbsBasePage(WebDriver driver){
        super(driver);
    }
    private final String BASE_URL=System.getProperty("base.url","https://otus.ru");
//private String getPath(){    return BASE_URL.toString().endsWith("/")?"":"/";}
  public T open(String path){
        driver.get(BASE_URL+path);
        return (T)this.driver;
  }
  }


