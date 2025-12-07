package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Interaction {

    WebDriver driver;

    public Interaction(WebDriver driver){
        this.driver=driver;
    }

    // Locators for Selectable Page

    private static final By allItems=By.xpath("//li[@class='list-group-li']");

    // Locators for Draggable topic

    private static final By draggedItem=By.xpath("//div[@id='draggable']");
    private static final By droppedItem=By.xpath("//div[@id='droppable']");


    // Locators for Dragged element from one place to another place

    private static final By sampleTab = By.xpath("//button[@id='nav-home-tab']");
    private static final By dragmeAroundText = By.xpath("//div[@id='draggables']");
    private static final By containerRestrictedTab = By.xpath("//button[text()='Container Restricted']");
    private static final By limitElement = By.xpath("//div[@id='intro']");




          // Actions for Selectable Items
    public void clickOnAllItems() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.xpath("//li[@class='list-group-li']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement item : items) {
            js.executeScript("arguments[0].scrollIntoView(true);", item);

            item.click();
            Thread.sleep(500); // small pause to allow highlighting

            // Verify the item is selected by checking selected CSS class
            boolean isSelected = item.getAttribute("class").contains("active");
            System.out.println(item.getText() + " -> Selected: " + isSelected);
        }

    }

    // Actions for Dragabbale Page

    public void elementdragAndDrop(){
        Actions action=new Actions(driver);
        action.clickAndHold(driver.findElement(draggedItem)).moveToElement(driver.findElement(droppedItem)).release().perform();
    }

    // Actions for Draggable Page

    public void elementDragged(){
        driver.findElement(sampleTab).click();
        Actions action=new Actions(driver);
        action.dragAndDropBy(driver.findElement(dragmeAroundText),200,200).release().perform();

    }
    public void containerRestrictedSection(){
        driver.findElement(containerRestrictedTab).click();
        Actions action=new Actions(driver);
        action.dragAndDropBy(driver.findElement(limitElement),371,71).perform();
    }



}
