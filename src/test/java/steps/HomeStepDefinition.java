package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeStepDefinition {




        public static WebDriver driver;

        @Given("I navigate to the home page")
        public void i_navigate_to_the_home_page () {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }

        @When("Navigate to forgot password link")
        public void navigate_to_forgot_password_link () {
            driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=12895396724219586847&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9147349&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");

        }

        @Then("I should see forgot password page")
        public void i_should_see_forgot_password_page () {
            driver.quit();
            System.out.println("Run was successfully completed");
        }
    }



