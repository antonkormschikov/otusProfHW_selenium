package extensions;
import annotations.Driver;
import annotations.Page;
import factories.PageFactory;
import factories.WebDriverFactory;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class UIExtensions implements BeforeEachCallback, AfterEachCallback{
  private WebDriver driver;
   @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {

    driver = new WebDriverFactory().create();
    Set<Field> fildsToInject = getAnnotatedFields(Driver.class, extensionContext);
    for (Field field: fildsToInject) {
      if (field.getType().getName().equals(WebDriver.class.getName())){
        field.setAccessible(true);
        field.set(extensionContext.getTestInstance().get(),driver);
      }
    }

/*String clname = extensionContext.getTestClass();
    Set<Field> fildsToInjectPage = getAnnotatedFields(Page.class, extensionContext);
     var object = new PageFactory().newPage(driver,extensionContext.getParent().toString());
    for (Field field: fildsToInjectPage) {
    if (field.getType().getName().equals(object.getClass().getName())){
        field.setAccessible(true);
        field.set(extensionContext.getTestInstance().get(),object);
      }
    }*/

  }

  private Set<Field> getAnnotatedFields(Class<? extends Annotation> annotation,ExtensionContext extensionContext){
    Set<Field> fields = new HashSet<>();
    Class<?> testClass = extensionContext.getTestClass().get();
    for (Field field: testClass.getDeclaredFields()){
      if (field.isAnnotationPresent(annotation)){
        fields.add(field);
      }
    }
    return fields;
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    if(driver !=null){
      //driver.close();
      driver.quit();
    }
  }


}
