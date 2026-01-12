package topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowHandle {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        driver.get("https://adactinhotelapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void multipleWindowHandleTest() throws InterruptedException {
        String homeWindowId = driver.getWindowHandle();
        driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String windowID: allWindowHandles){
            if(!windowID.equals(homeWindowId)){
                driver.switchTo().window(windowID);
                 break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        allWindowHandles = driver.getWindowHandles();
        for(String window: allWindowHandles){
            if(!window.equals(homeWindowId) && !window.equals(driver.getWindowHandle())){
                driver.switchTo().window(window);
                break;
            }
        }

        driver.findElement(By.xpath("//i[text()='clear']")).click();
        driver.close();
        driver.switchTo().window(homeWindowId);
        driver.findElement(By.id("username")).sendKeys("reyaz0806");
        driver.findElement(By.id("password")).sendKeys("reyaz123");
        Thread.sleep(3000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(4000);

    }
    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
