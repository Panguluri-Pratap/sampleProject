package topics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class StaticWebTable {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {

        driver=new ChromeDriver();
        driver.get("https://www.timeanddate.com/worldclock/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test //(Using Static Method)
    public void staticWebTableTest() throws InterruptedException {
        String part1="//table/tbody/tr[";
        String part2="]/td[";
        String part3="]";
        for(int i=1;i<=36;i++){
            for(int j=1;j<=8;j++){
                System.out.print(driver.findElement(By.xpath(part1+i+part2+j+part3)).getText()+ "  ");
            }
            System.out.println();
        }

    }

    @Test   //(Using Dynamic Method)
    public void dynamicWebTableTest1() throws InterruptedException {
        WebElement table=driver.findElement(By.xpath("//table[@class='zebra fw tb-theme']/child::tbody"));

        List<WebElement> allRows= table.findElements(By.tagName("tr"));

        for(WebElement cols:allRows){
            List<WebElement> allCols=cols.findElements(By.tagName("td"));
            for(WebElement col:allCols){
                System.out.print(col.getText()+ "  ");
            }
            System.out.println();
        }

    }



    @AfterMethod
    public void end(){

        driver.quit();
        System.out.println("Script Ran Successfully");
        System.out.println("***********************************");
    }
}
