package topics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class JavaScriptExecutor {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        driver.get("https://www.pepperfry.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

    }
    @Test
    public void AlertsHandlingTest() throws InterruptedException {

      JavascriptExecutor js=(JavascriptExecutor) driver;
      //js.executeScript("window.scrollBy(0,1000)");
      WebElement element=driver.findElement(By.xpath("//div[text()='Sell on Pepperfry']"));
     // js.executeScript("arguments[0].scrollIntoView();",element);
        js.executeScript("arguments[0].click();",element);
        js.executeScript("window.scrollBy(0,1000)");
      Thread.sleep(3000);
      try{
          driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'notification-frame')]")));
          driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
          driver.switchTo().defaultContent();
      }catch(Exception e){

      }


    }
    @AfterMethod
    public void end(){
        //driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
