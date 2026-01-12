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
import java.util.List;

public class Checkboxes {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {

        driver=new ChromeDriver();
        driver.get("https://echoecho.com/htmlforms09.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void checkBoxesTest() throws InterruptedException {
            List<WebElement> ele=driver.findElements(By.xpath("//td[@class='table5']/child::input"));
             JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement checkbox : ele) {
            if (checkbox.isSelected()) {
                js.executeScript("arguments[0].click();", checkbox);
            }
        }

        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());

    }

    @Test
    public void checkBoxesTest1() throws InterruptedException {
        List<WebElement> ele=driver.findElements(By.xpath("//td[@class='table5']/child::input"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        for(WebElement checkbox:ele){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }

        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());

    }
    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
