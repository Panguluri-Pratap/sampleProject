package topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
        driver=new ChromeDriver();
        driver.get("https://www.angelfire.com/super/badwebs/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void framesTest() throws InterruptedException{
        driver.switchTo().frame("contents");
        driver.findElement(By.xpath("(//font[contains(text(),\"I Hate Frames\")])[1]")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
       driver.switchTo().frame("main");
       driver.findElement(By.xpath("//b[text()= ' example ']/ancestor::a")).click();
       Thread.sleep(3000);

    }
    @AfterMethod
    public void end(){
        //driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
