package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static WebDriver driver;

    public static FileInputStream fis1;

    public static Properties configProp;

    @BeforeTest
    public void fileSetUp() throws IOException {

        fis1 = new FileInputStream("selenium\\config.properties");

        configProp.load(fis1);

    }

}
