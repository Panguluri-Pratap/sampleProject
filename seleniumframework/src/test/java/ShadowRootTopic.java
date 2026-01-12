import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ShadowRootTopic {
    WebDriver driver;

    @Test
    public void shadowtest() throws InterruptedException, AWTException {
        driver=new ChromeDriver();
        driver.get("https://imgur.com/upload");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//label[@for='file-input']/child::img")).click();
        Thread.sleep(4000);
        String fileName="C:\\Users\\prata\\Downloads\\nature.jpg";
        StringSelection stringSelection = new StringSelection(fileName);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
       Clipboard clipboard= toolkit.getSystemClipboard();
       clipboard.setContents(stringSelection,null);

       Robot rb=new Robot();
       rb.keyPress(KeyEvent.VK_CONTROL);
       rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Uploaded Successfully");

    }
}
