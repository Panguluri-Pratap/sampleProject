package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Widgets;

import java.time.Duration;

public class WidgetsStepDefinition {

    WebDriver driver;
    Widgets wds;

    @Given("I launch the menu application")
    public void i_launch_the_menu_application() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wds=new Widgets(driver);

    }
    @Then("I select the title option in the dropdown")
    public void i_select_the_title_option_in_the_dropdown() {
        wds.pickTitleOption();
    }

}
