package extensions;
import annotations.Driver;
import factories.WebDriverFactory;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UIExtensions implements BeforeEachCallback, AfterEachCallback {
 WebDriver driver=null;

  @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
    driver = new WebDriverFactory().create();
    Set<Field> fildsToInject = getAnnotatedFields(Driver.class, extensionContext);
    for (Field field: fildsToInject) {
      if (field.getType().getName().equals(WebDriver.class)){
        field.setAccessible(true);
        field.set(extensionContext.getTestInstance().get(),driver);
      }
    }
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
      driver.close();
      driver.quit();
    }
  }
}
