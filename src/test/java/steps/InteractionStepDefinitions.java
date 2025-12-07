package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Interaction;

import java.time.Duration;

public class InteractionStepDefinitions {
    WebDriver driver;
    Interaction itc;


      // Selectable Page
    @Given("I launch selectable items page")
    public void i_launch_selectable_items_page() {
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.tutorialspoint.com/selenium/practice/selectable.php");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         itc=new Interaction(driver);
    }

    @Then("I select the all items")
    public void i_select_the_all_items() throws InterruptedException {
         itc.clickOnAllItems();

    }

      // Draggable Page

    @Given("I launch draggable items page")
    public void i_launch_draggable_items_page() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        itc=new Interaction(driver);
    }

    @Then("I dragged item one place to another place")
    public void i_dragged_item_one_place_to_another_place() {
             itc.elementdragAndDrop();
    }


    // Draggable Page 2

    @Given("I launch the application")
    public void i_launch_the_application() {
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         itc=new Interaction(driver);
    }

    @Then("I moved required item")
    public void i_moved_required_item() {
        itc.elementDragged();
    }

    @Then("I click on Container Restricted tab")
    public void i_click_on_container_restricted_tab() {
        System.out.println("Moved to container section");
    }


    @Then("i dragged element within the limit")
    public void i_dragged_element_within_the_limit() {
        itc.containerRestrictedSection();
    }


}
