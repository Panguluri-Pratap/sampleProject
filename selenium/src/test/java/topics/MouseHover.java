package topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        driver.get("https://www.kvb.co.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void mouseHover(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[text()='Personal']")))
                .pause(3000)
                .moveToElement(driver.findElement(By.xpath("//a[text()='Loans ']")))
                .pause(3000)
                .build()
                .perform();
    }
    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
