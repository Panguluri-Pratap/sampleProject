package topics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class AlertsHandling {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void AlertsHandlingTest() {

          driver.findElement(By.name("proceed")).click();

          Alert al=driver.switchTo().alert();
        String txt=al.getText();
        Assert.assertEquals(txt,"Please enter a valid user name");
        al.accept();

    }
    @AfterMethod
    public void end(){
        //driver.quit();
        System.out.println("Script Ran Successfully");
    }
}
