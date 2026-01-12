package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ValidateLogin {
    WebDriver driver;
    FileInputStream fis;
    Properties configProp;

    @BeforeMethod
    public void setup() throws IOException {
       fis=new FileInputStream("config.properties");
       configProp=new Properties();
        configProp.load(fis);



        // Launch browser based on browser value in Config Properties
        String browserName=configProp.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }
        else if(browserName.equalsIgnoreCase("safari")){    // reyaz123
            driver=new SafariDriver();
        }
        driver.get(configProp.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
    }

    @Test(dataProvider = "getData")
    public void validateLoginTest(String username, String password, String expTitle){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login")).click();


        Assert.assertEquals(driver.getTitle(),expTitle);

    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data=new Object[4][3];

   // Adactin.com - Hotel Reservation System

        data[0][0] = "reyaz0806";
        data[0][1] = "reyaz123";
        data[0][2] = "Adactin.com - Search Hotel";

        data[1][0] = "reyaz08";
        data[1][1] = "reyaz123";
        data[1][2] = "Adactin.com - Hotel Reservation System";

        data[2][0] = "reyaz0806";
        data[2][1] = "reyaz12";
        data[2][2] = "Adactin.com - Hotel Reservation System";

        data[3][0] = "reyaz08";
        data[3][1] = "reyaz1";
        data[3][2] = "Adactin.com - Hotel Reservation System";

        return data;

    }

    @AfterMethod
    public void end(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}
