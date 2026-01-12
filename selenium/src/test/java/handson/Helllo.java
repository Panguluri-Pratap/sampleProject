package handson;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Helllo {
    @Test
            public void hello() throws InterruptedException, AWTException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/");
        WebElement input=driver.findElement(By.xpath("//input[@id='username']"));
        Actions a=new Actions(driver);
        a.click(input)
                .keyDown(Keys.SHIFT)
                .sendKeys("Hello")
                .keyUp(Keys.SHIFT)
                .perform();
        driver.close();

        Robot robot=new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);

        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        File des=new File("XXXX");
        FileUtils.copyFile(src,des);


        //Explicit Wait
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a"))).isDisplayed();

        //Fluent Wait

        FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

    }
}
