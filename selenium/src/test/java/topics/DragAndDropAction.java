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

public class DragAndDropAction {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
        driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void dragAndDropTest() throws InterruptedException{
        Actions action = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
        action.dragAndDrop(source, target)
                .pause(Duration.ofSeconds(3))
                .build()
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("droppable"), "Dropped!"));

        driver.switchTo().defaultContent();

    }
    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
