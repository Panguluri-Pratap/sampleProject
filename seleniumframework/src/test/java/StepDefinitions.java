import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.junit.Assert;


public class StepDefinitions {

    public static WebDriver driver;

    @Given("user starts {string} browser")
    public void user_starts_browser(String browserName) {

        if(browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
              }

        if(browserName.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }

        if(browserName.equalsIgnoreCase("safari")){
            driver=new SafariDriver();
        }

    }

    @And("user launch app using url {string}")
    public void user_launch_app_using_url(String url) {
             driver.get(url);
             driver.manage().window().maximize();
    }

    @When("user enters username {string} in textbox using xpath {string}")
    public void user_enters_username_in_textbox_using_xpath(String username, String xpath) {

             driver.findElement(By.xpath(xpath)).sendKeys(username);
    }

    @And("user enters password {string} in textbox using xpath {string}")
    public void user_enters_password_in_textbox_using_xpath(String password, String xpath) {

        driver.findElement(By.xpath(xpath)).sendKeys(password);
    }


    @And("user clicks login or submit button using xpath {string}")
    public void user_clicks_login_or_submit_button_using_xpath(String xpath) {

        driver.findElement(By.xpath(xpath)).click();
    }

    @Then("user validates title to be {string}")
    public void user_validates_title_to_be(String expTitle) {
            Assert.assertEquals(expTitle,"Adactin.com - Search Hotel");


    }

    //hooks are same as @BeforeMethod and @AfterMethod in TestNG
    @After
    public void teardown(){
        driver.quit();
    }




}
