package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Elements {



     WebDriver driver;


    // Constructor
    public Elements(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }




    // Locators for TextBox Page
    private static final By fullName = By.id("fullname");
    private static final By email = By.id("email");
    private static final By currentAddress = By.id("address");
    private static final By password = By.name("password");
    private static final By submitBtn = By.xpath("//input[@type='submit']");


    // Locators for CheckBox Page
    private static final By checkboxOne= By.id("c_bs_1");
    private static final By clickboxonePlus =By.xpath("(//span[@class='plus'])[1]");
    private static final By checkboxTwo=By.id("c_bs_2");
    private static final By clickboxtwoPlus=By.xpath("(//li[@id='bs_2']/span)");


    // Locators for Radio buttons
    private static final By YesRadioButton = By.xpath("//input[@value='igottwo']");
    private static final By YesRadiobtntxt = By.xpath("//div[contains(text(),'You have checked')][1]");
    private static final By ImpressiveRadioButton = By.xpath("//input[@value='igotthree']");
    private static final By ImpressiveRadiobtntxt = By.xpath("//div[contains(text(), 'You have checked')][2]");
    private static final By NoRadiobtndisbaled = By.xpath("//input[@value='option3']");


    // TextBox Actions
    public void enterFullName(String name) {
        driver.findElement(fullName).sendKeys(name);

    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(currentAddress).sendKeys(address);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSubmit() throws InterruptedException {
        driver.findElement(submitBtn).click();
        Thread.sleep(5000);
    }
    public void verifyDetails() {
        driver.quit();
    }


    // CheckBox Actions

    public void clickonCheckBoxOne() {
        driver.findElement(checkboxOne).click();
    }

    public void clickonCheckBoxOnePlus() throws InterruptedException {
        driver.findElement(clickboxonePlus).click();
        Thread.sleep(4000);

    }

    public void clickonCheckBoxTwo() {
        driver.findElement(checkboxTwo).click();
    }

    public void clickonCheckBoxTwoPlus() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(clickboxtwoPlus)).click();
    }


    // Radio button Actions


    public void clickedonYESradiobtn() {
        driver.findElement(YesRadioButton).click();
    }


    public void validateYESradiobtnmessage(String string1) {
        String ActualMessage=driver.findElement(YesRadiobtntxt).getText();
        Assert.assertEquals(ActualMessage,string1);
        System.out.println(ActualMessage);
    }

    public void clickedonImpressiveradiobtn() {
        driver.findElement(ImpressiveRadioButton).click();
    }


    public void validateImpressiveradiobtnmessage(String string2) {
        String ActualMessage=driver.findElement(ImpressiveRadiobtntxt).getText();
        Assert.assertEquals(ActualMessage,string2);
        System.out.println(ActualMessage);
    }

    public void NoRadiobtndisabled(){
       WebElement element= driver.findElement(NoRadiobtndisbaled);
        if (!element.isEnabled()) {
            System.out.println("Yes, No radio button is disabled!");
        } else {
            System.out.println("No radio button validation failed!");
        }
    }


}
