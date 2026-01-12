package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Demo {
    public static void main(String[] args) {
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://www.amazon.in/b/32702023031?node=32702023031&ld=AZINSOANavDesktop_T3&ref_=nav_cs_sell_T3");
        String name=driver.findElement(By.xpath("//div[text()= 'National shipping rates now, from ₹77']")).getText();
        System.out.println(name);
        driver.quit();
    }
}
