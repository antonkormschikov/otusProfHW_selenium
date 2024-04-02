package pages;

import annotations.Driver;
import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import utils.AbsBaseUtils;
import java.time.LocalDate;

public abstract class AbsBasePage<T> {

 //public AbsBasePage(WebDriver driver) {    super(driver);  }
 @Driver
 private WebDriver driver;
  private Logger logger = (Logger) LogManager.getLogger(AbsBasePage.class);
  private final String baseUrl=System.getProperty("base.url","https://otus.ru");
  public void open(String path) {
    String a=baseUrl+path;
    driver.get(a);

  }

  public LocalDate convertDate(String srcDate){
    String[] monthNames = { "января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря" };
    int month=0;
    int day=Integer.parseInt(srcDate.split(" ")[0]);
    int i=0;
    while (i< monthNames.length){
      if (srcDate.split(" ")[1].equals(monthNames[i])){
        break;
      } else {i++;}
    }
    month=i+1;
    LocalDate localDate;
    if ((month==1||month==2||month==3)
            &&(LocalDate.now().getMonthValue()==12||LocalDate.now().getMonthValue()==11||LocalDate.now().getMonthValue()==10))
    {
      localDate=LocalDate.of(LocalDate.now().getYear()+1,month,day);

    } else {localDate=LocalDate.of(LocalDate.now().getYear(),month,day);}

    return localDate;
  }
}


