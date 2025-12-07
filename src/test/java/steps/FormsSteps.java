package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Elements;
import pages.Forms;

import java.time.Duration;

public class FormsSteps {

    WebDriver driver;
    Forms forms;

    // Forms Section

    // Student Form Page

    @Given("I launch the Student Registration Form Application")
    public void i_launch_the_student_registration_form_application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        forms=new Forms(driver);
    }

    @When("I enter student name {string}")
    public void i_enter_student_name(String name) {
        forms.enterStudentName(name);
    }

    @When("I enter student email {string}")
    public void i_enter_student_email(String email) {
        forms.enterStudentEmail(email);
    }

    @When("I select student gender")
    public void i_select_student_gender() {
        forms.selectStudentGender();
    }

    @When("I enter student mobile number {string}")
    public void i_enter_student_mobile_number(String mobile) {
        forms.enterStudentMobile(mobile);
    }

    @When("I enter student subject {string}")
    public void i_enter_student_subject(String subject) {
        forms.enterStudentSubject(subject);
    }

    @When("I select student hobbies")
    public void i_select_student_hobbies() {
        forms.selectStudentHobbie();
    }

    @When("I upload student picture")
    public void i_upload_student_picture() {
        forms.uploadStudentPicture();
    }

    @When("I enter student address {string}")
    public void i_enter_student_address(String address) {
        forms.enterStudentAddress(address);
    }

    @When("I select state and city")
    public void i_select_state() {
        forms.selectStudentState();
        forms.selectStudentCity();
    }

    @Then("I click on Submit button")
    public void i_click_on_submit_button() {
        forms.clickLoginbtn();
    }


    // Student Register

    @Given("I launch the student register application")
    public void i_launch_the_student_register_application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        forms = new Forms(driver);
    }

    @When("I enter the First Name {string}")
    public void i_enter_the_first_name(String FName) {
        forms.enterFirstName(FName);
    }

    @When("I enter the Last Name {string}")
    public void i_enter_the_last_name(String LName) {
        forms.enterLastName(LName);
    }

    @When("I enter the User Name {string}")
    public void i_enter_the_user_name(String UName) {
        forms.enterUserName(UName);
    }

    @When("I enter the Password {string}")
    public void i_enter_the_password(String Pswd) {
        forms.enterPassword(Pswd);
    }

    @When("click on Register button")
    public void click_on_register_button() {
        forms.clickRegisterbutton();
    }

    @Then("click on back to login button")
    public void click_on_back_to_login_button() {
        forms.clickBackToLoginButton();
    }


    // Student Login

    @Given("I launch the student login page")
    public void i_launch_the_student_login_page() {
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         forms=new Forms(driver);
    }

    @When("I enter emaail {string}")
    public void i_enter_emaail(String semail) {
      forms.enterEmail(semail);
    }

    @When("I enter passwod {string}")
    public void i_enter_passwod(String spswd) {
      forms.enterPassword(spswd);
    }

    @When("click on login button")
    public void click_on_login_button() {
      forms.clickLogin();
    }

    @Then("click on new user button")
    public void click_on_new_user_button() {
      forms.clickNewUser();
    }

}