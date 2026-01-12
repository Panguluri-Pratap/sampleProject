package assignments;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Assignment2 {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

     @Test
    public void windowHandlesAndFramesTest() throws InterruptedException{
           driver.switchTo().frame("a077aa5e");
           driver.findElement(By.xpath("//img[contains(@src,\"Jmeter720.png\")]/parent::a")).click();
           Thread.sleep(3000);
           String parentwindow=driver.getWindowHandle();
           Set<String> allWindows=driver.getWindowHandles();
           for(String window: allWindows){
               if(!window.equals(parentwindow)){
                   driver.switchTo().window(window);
                   break;
               }
           }
          List<WebElement> texts=driver.findElements(By.xpath("(//p[text()='Top Tutorials']/ancestor::div[contains(@class, 'wp-block-kadence-column')])[1]/descendant::span[@class='kt-blocks-info-box-title']"));
          for(WebElement title:texts){
             System.out.println(title.getText());
          }
    }

    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
