package assignments;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment1 {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver();
        driver.get("https://emicalculator.net/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void dragAndDropTest() throws InterruptedException{
        Actions action = new Actions(driver);
        WebElement Source1= driver.findElement(By.xpath("(//span[@tabindex='0'])[1]"));
        WebElement Source2= driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        WebElement Source3= driver.findElement(By.xpath("(//span[@tabindex='0'])[3]"));
        action.dragAndDropBy(Source1,100,0)
                .pause(Duration.ofSeconds(3))
                .dragAndDropBy(Source2,100,0)
                .pause(Duration.ofSeconds(3))
                .dragAndDropBy(Source3,-200,0)
                .build()
                .perform();


    }

   // @Test
    public void doubleClickTest() throws InterruptedException{
        Actions action = new Actions(driver);
        WebElement Source1= driver.findElement(By.xpath("(//span[@tabindex='0'])[1]"));
        WebElement Source2= driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        WebElement Source3= driver.findElement(By.xpath("(//span[@tabindex='0'])[3]"));
        action.dragAndDropBy(Source1,80,0)
                .pause(Duration.ofSeconds(3))
                .dragAndDropBy(Source2,150,0)
                .pause(Duration.ofSeconds(3))
                .dragAndDropBy(Source3,-110,0)
                .build()
                .perform();
       String name= driver.findElement(By.xpath("//span[text()='84,990']")).getText();
        Assertions.assertEquals("name","84,990");


    }

    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }

}
