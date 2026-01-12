package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String scenarioName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String screenshotPath =
                "target/screenshots/" + scenarioName + "_" + timestamp + ".png";

        try {
            Files.createDirectories(new File("target/screenshots").toPath());
            Files.copy(source.toPath(), new File(screenshotPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
