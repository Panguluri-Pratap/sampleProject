package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        // 📸 Take screenshot for EVERY scenario
        ScreenshotUtil.takeScreenshot(driver, scenario.getName());
        DriverFactory.quitDriver();
    }
}

