package hooks;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {

    @After
    public void closeBrowser(){
        WebDriver driver = DriverFactory.getDriver();
        driver.quit();
    }
}
