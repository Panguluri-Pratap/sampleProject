package topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hello {

     WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void end(){
        driver.quit();
        System.out.println("Successfully Completed Script");
    }

    @Test(priority = 2)
    public void ValidUsernameValidPassword() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("reyaz0806");
        driver.findElement(By.id("password")).sendKeys("reyaz123");
        Thread.sleep(3000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
        System.out.println("Home PAGE");
    }

    @Test(priority = 1)
    public void ValidUsernameEmptyPassword() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("reyaz0806");
        driver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(4000);
        WebElement txt=driver.findElement(By.cssSelector("span[id='password_span']"));
        String name=txt.getText();
        System.out.println(name);
    }

    @Test(priority = 0)
    public void EmptyUsernameValidPassword() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("reyaz123");
        Thread.sleep(3000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(4000);
        WebElement txt=driver.findElement(By.cssSelector("span[id='username_span']"));
        String name=txt.getText();
        System.out.println(name);

    }
}
