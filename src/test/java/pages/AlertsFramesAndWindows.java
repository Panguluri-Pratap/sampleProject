package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class AlertsFramesAndWindows {
    WebDriver driver;


    public AlertsFramesAndWindows(WebDriver driver){
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    // Locators for Browser Windows

    private static final By newTab = By.xpath("//button[text()='New Tab']");
    private static final By newWindow = By.xpath("//button[text()='New Window']");
    private static final By newWindowMessage = By.xpath("//button[text()='New Window Message']");

    // Locators for Alerts

    private static final By firstAlert = By.xpath("//button[text()='Alert']");
    private static final By secondAlert = By.xpath("(//button[text()='Click Me'])[1]");
    private static final By thirdAlert = By.xpath("(//button[text()='Click Me'])[2]");
    private static final By fourthAlert = By.xpath("(//button[text()='Click Me'])[3]");

    // Locators for Frames

    private static final By Iframe1Element = By.xpath("//a[contains(@href,'selenium/index.htm')]");
    private static final By Iframe2Element = By.xpath("//a[contains(@title,'back to Selenium Tutorial')]");

    // Actions for Browse Windows

    public void clickOnNewTab() throws InterruptedException {

        String mainWindow=driver.getWindowHandle();

        driver.findElement(newTab).click();

        Set<String> allwindows=driver.getWindowHandles();

        for(String window:allwindows){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
           driver.close();
        driver.switchTo().window(mainWindow);
        Thread.sleep(4000);

    }

    public void clickOnNewWindow() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();

        driver.findElement(newWindow).click();

        Set<String> allwindows = driver.getWindowHandles();

        for (String window : allwindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        driver.close();

        driver.switchTo().window(mainWindow);
        Thread.sleep(4000);
    }

    public void clickOnNewWindowMessage(){

            String mainWindow = driver.getWindowHandle();

            // Click new window button
            driver.findElement(newWindowMessage).click();

            // Wait until a new window is available
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(driver -> driver.getWindowHandles().size() > 1);

            // Switch to new window
            ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(1));

            // Perform your actions in new window
            System.out.println("New Window Title: " + driver.getTitle());

            // Close the new window
            driver.close();

            // Switch back to main window
            driver.switchTo().window(mainWindow);
        }


        // Actions for Alerts

     public void clickOnFirstAlert() {

        driver.findElement(firstAlert).click();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.alertIsPresent());

         Alert alert = driver.switchTo().alert();
         System.out.println(alert.getText());
         alert.accept();
     }

     public void clickOnSecondAlert(){
         driver.findElement(secondAlert).click();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.alertIsPresent());
         Alert alert =driver.switchTo().alert();
         System.out.println(alert.getText());
         alert.accept();
     }

     public void clickOnThirdAlert(){
        driver.findElement(thirdAlert).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
         Alert alert =driver.switchTo().alert();
        alert.accept();

     }

     public void clickOnFourthAlert(){
        driver.findElement(fourthAlert).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Pratap");
        alert.accept();
     }

     // Actions for Iframes

    public void clickOnIframe1(){

        driver.switchTo().frame(0);


        driver.findElement(Iframe1Element).click();

        String mainWindow = driver.getWindowHandle();

        Set<String> allwindows=driver.getWindowHandles();

        for(String window:allwindows){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(mainWindow);
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/frames.php");


        driver.switchTo().defaultContent();

    }

    public void clickOnIframe2(){

        driver.switchTo().frame(1);

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(Iframe2Element));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        String mainWindow = driver.getWindowHandle();

        Set<String> allwindows = driver.getWindowHandles();

        for(String window: allwindows){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(mainWindow);

        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/frames.php");


           driver.switchTo().defaultContent();


    }

}
