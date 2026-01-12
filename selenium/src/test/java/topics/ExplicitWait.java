package topics;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {

        driver=new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void AlertsHandlingTest() throws InterruptedException {




        driver.findElement(By.xpath("//span[text()='2']")).click();

        driver.findElement(By.xpath("//span[text()='+']")).click();

        driver.findElement(By.xpath("//span[text()='3']")).click();

        driver.findElement(By.xpath("//span[text()='=']")).click();

        // fluent wait mechanism

        FluentWait<WebDriver> wait=
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(20))
                        .pollingEvery(Duration.ofMillis(200))
                        .ignoring(NoSuchElementException.class);


        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[@id='spinner']"))));


        String txt =  driver.findElement(By.xpath("//div[@class='screen']")).getText();
        System.out.println(txt);

        Assert.assertEquals("5",txt);
    }
    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
