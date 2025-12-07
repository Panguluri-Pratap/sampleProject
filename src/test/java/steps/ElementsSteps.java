package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Elements;
import pages.Forms;

import java.time.Duration;

public class ElementsSteps {

    WebDriver driver;
    Elements elements;


    // Elements Section

    //TextBox
    @Given("I launch the Text Box application")
    public void launchApplication() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        elements= new Elements(driver);

    }

    @When("I enter full name {string}")
    public void enterFullname(String name) {
        elements.enterFullName(name);
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        elements.enterEmail(email);
    }

    @When("I enter current address {string}")
    public void enterCurrentAddress(String address) {
        elements.enterCurrentAddress(address);
    }

    @When("I enter password {string}")
    public void enterPassword(String password) {
        elements.enterPassword(password);
    }

    @When("I click on submit button")
    public void clickonSubmitButton() throws InterruptedException {
        elements.clickSubmit();
    }

    @Then("I should see the submitted details displayed correctly")
    public void verifyDetails() {
        driver.quit();
    }


    //Check Box Page

    @Given("I launch the Check box application")
    public void launchCheckBoxApplication() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        elements= new Elements(driver);
    }

    @Then("Clicked on Checkbox one")
    public void clickedOnCheckboxONE() {
        elements.clickonCheckBoxOne();
    }

    @Then("Clicked on plus symbol for one")
    public void clickedonPlusSymbolforOne() throws InterruptedException {
        elements.clickonCheckBoxOnePlus();
    }

    @Then("Clicked on Checkbox two")
    public void clickedOnCheckboxTWO() {
        elements.clickonCheckBoxTwo();
    }
    @Then("Clicked on plus symbol for two")
    public void clickedonPlusSymbolforTWO() {
        elements.clickonCheckBoxTwoPlus();
    }



        // Radio button Actions

    @Given("I launch the Radio button application")
    public void laucnhRadioButtonApplication() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        elements= new Elements(driver);
    }

    @When("Clicked on Yes Radio button")
    public void clickedonYesradio_button() {
        elements.clickedonYESradiobtn();
    }

    @Then("I should see the Yes Radio btn message {string}")
    public void I_should_see_the_Yes_Radio_btn_message(String string1) {
        elements.validateYESradiobtnmessage(string1);
    }

    @When("I clicked on Impressive Radio button")
    public void i_clicked_on_impressive_radio_button() {
       elements.clickedonImpressiveradiobtn();
    }

    @Then("I should see the Impressive Radio btn message {string}")
    public void I_should_see_the_Impressive_Radio_btn_message(String string2) {
        elements.validateImpressiveradiobtnmessage(string2);
    }

    @Then("Validated No radio button is disabled")
    public void validate_no_radio_button_is_disabled() {
        elements.NoRadiobtndisabled();

    }



}
