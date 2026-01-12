package topics;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadioButtons {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {

        driver=new ChromeDriver();
        driver.get("https://echoecho.com/htmlforms10.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void radioButtonsTest() throws InterruptedException {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
    }

    @Test
    public void radioButtonsTest2() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement ele=driver.findElement(By.xpath("//input[@value='Cheese']"));
        js.executeScript("arguments[0].click()",ele);
        Thread.sleep(8000);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
    }
    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
