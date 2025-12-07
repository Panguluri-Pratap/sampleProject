package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Forms {
    WebDriver driver;


    public Forms(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


      // Locators for Student Registration Form
  private static final By studentName  = By.xpath("//input[@id='name']");
    private static final By studentEmail = By.xpath("//input[@id='email']");
    private static final By studentGender= By.xpath("//input[@name='gender' and @id='gender']");
    private static final By studentMobile= By.xpath("//input[@id='mobile']");
    private static final By studentSubjects=By.xpath("//input[@id='subjects']");
    private static final By studentHobbies=By.xpath("//label[text()='Sports']/preceding-sibling::input");
    private static final By studentPicture=By.xpath("//input[@id='picture']");
    private static final By studentAddress=By.xpath("//textarea[@id='picture']");
    private static final By studentState=By.xpath("//select[@name='state']");
    private static final By studentCity=By.xpath("//select[@name='city']");
    private static final By studentLogin=By.xpath("//input[@type='submit']");


    // Locators for Student Register
    private static final By firstName = By.xpath("//input[@id='firstname']");
    private static final By lastName = By.xpath("//input[@id='lastname']");
    private static final By userName = By.xpath("//input[@id='username']");
    private static final By password = By.xpath("//input[@id='password']");
    private static final By register = By.xpath("//input[@type='submit']");
    private static final By backToLogin = By.xpath("//a[text()='Back to Login']");


    // Locators for Student Login
    private static final By email = By.xpath("//input[@id='email']");
    private static final By pswd = By.xpath("//input[@id='password']");
    private static final By login = By.xpath("//input[@value='Login']");
    private static final By submit = By.xpath("//a[@type='submit']");


       // Student Registration Form Actions

    public void enterStudentName(String name){
        driver.findElement(studentName).sendKeys(name);
    }

    public void enterStudentEmail(String email){
        driver.findElement(studentEmail).sendKeys(email);
    }

    public void selectStudentGender(){
        driver.findElement(studentGender).click();
    }
    public void enterStudentMobile(String mobile){
        driver.findElement(studentMobile).sendKeys(mobile);
    }
    public void enterStudentSubject(String subject){
        driver.findElement(studentSubjects).sendKeys(subject);
   }
    public void selectStudentHobbie(){
        driver.findElement(studentHobbies).click();
    }
    public void uploadStudentPicture(){
       WebElement file= driver.findElement(studentPicture);
       file.sendKeys("C:\\Users\\prata\\OneDrive\\Documents\\Database- It contains Data.txt");
    }
    public void enterStudentAddress(String address){
       driver.findElement(studentAddress).sendKeys(address);
    }
    public void selectStudentState(){
        driver.findElement(studentState);
        WebElement stateOption = driver.findElement(By.xpath("//option[contains(text(),'Uttar Pradesh')]"));
        stateOption.click();
    }
    public void selectStudentCity(){
        driver.findElement(studentCity);
        WebElement cityOption = driver.findElement(By.xpath("//option[contains(text(),'Lucknow')]"));
        cityOption.click();
    }
    public void clickLoginbtn(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(studentLogin))).click();
    }


    // Actions for Student Register

    public void enterFirstName(String FName){
        driver.findElement(firstName).sendKeys(FName);
    }
    public void enterLastName(String LName){
        driver.findElement(lastName).sendKeys(LName);
    }
    public void enterUserName(String UName){
        driver.findElement(userName).sendKeys(UName);
    }
    public void enterPassword(String Pswd){
        driver.findElement(password).sendKeys(Pswd);
    }
    public void clickRegisterbutton(){
        driver.findElement(register).click();
    }
    public void clickBackToLoginButton(){
        driver.findElement(backToLogin).click();
    }

    // Actions for Student Login

    public void enterEmail(String semail){
        driver.findElement(email).sendKeys(semail);
    }
    public void enterpswd(String spswd){
        driver.findElement(pswd).sendKeys(spswd);
    }
    public void clickLogin(){
        driver.findElement(login).click();
    }
    public void clickNewUser(){
        driver.findElement(submit).click();
    }

}
