package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Widgets {

    WebDriver driver;

   public Widgets(WebDriver driver){
       this.driver=driver;
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }

   // Locators for Select Menu

    private static final By mutliSelectDropdown = By.xpath("//span[contains(@class,'mbsc-textfield-tags-placeholder')]");
    private static final By printAllSelectValues= By.xpath("//span[contains(@class,'mbsc-tag-text')]");
    private static final By pickTitle = By.xpath("//select[@id='inputGroupSelect03']");


   public void pickTitleOption(){

       Select select = new Select(driver.findElement(pickTitle));
       select.selectByIndex(1);

   }




}
