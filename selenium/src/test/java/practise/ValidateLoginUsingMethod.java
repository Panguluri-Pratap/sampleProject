package practise;
import org.example.UtilKit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class ValidateLoginUsingMethod {

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
    public void validateLoginTest(HashMap<String,String> dataMap){
        driver.findElement(By.id("username")).sendKeys(dataMap.get("username"));
        driver.findElement(By.id("password")).sendKeys(dataMap.get("password"));

        driver.findElement(By.id("login")).click();


        Assert.assertEquals(driver.getTitle(),dataMap.get("expTitle"));

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        Object[][] data=new Object[1][1];
      data[0][0]=UtilKit.getTestDataFromExcel("TC-101");

        return data;

    }

    @AfterMethod
    public void end() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
