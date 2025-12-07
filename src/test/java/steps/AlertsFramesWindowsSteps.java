package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AlertsFramesAndWindows;

import java.time.Duration;

public class AlertsFramesWindowsSteps {
    WebDriver driver;
    AlertsFramesAndWindows afw;

    // browse window steps

    @Given("I launch the browser window application")
    public void i_launch_the_browser_window_application() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        afw=new AlertsFramesAndWindows(driver);
    }

    @When("I click on New Tab")
    public void i_click_on_new_tab() throws InterruptedException {
        afw.clickOnNewTab();
    }

    @Then("I click on New Window")
    public void i_click_on_new_window() throws InterruptedException {
        afw.clickOnNewWindow();
    }
    @Then("I click on New Window Message")
    public void i_click_on_new_window_message() {
        afw.clickOnNewWindowMessage();
    }

    //  Different Alerts

    @Given("I launch the alerts page")
    public void i_launch_the_alerts_page() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        afw=new AlertsFramesAndWindows(driver);
    }

   @When("i click on first alert")
    public void i_click_on_first_alert() {

        afw.clickOnFirstAlert();
    }

    @When("i click on second alert")
    public void i_click_on_second_alert() {
       afw.clickOnSecondAlert();
    }

    @When("i click on third alert")
    public void i_click_on_third_alert() {
       afw.clickOnThirdAlert();
    }

    @Then("i click on fourth alert {string}")
    public void i_click_on_fourth_alert(String name) {
       afw.clickOnFourthAlert();
    }


    // Frames Page

    @Given("I launch the frame page")
    public void i_launch_the_frame_page() {
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          afw=new AlertsFramesAndWindows(driver);
    }

    @When("i click on selenium tutorial link iframe1 and close the selenium page1")
    public void i_click_on_selenium_tutorial_link_iframe1_and_close_the_selenium_page1() {
          afw.clickOnIframe1();
    }

    @Then("i click on selenium tutorial link iframe2 and close the selenium page2")
    public void i_click_on_selenium_tutorial_link_iframe2_and_close_the_selenium_page2() {
         afw.clickOnIframe2();
    }

}
