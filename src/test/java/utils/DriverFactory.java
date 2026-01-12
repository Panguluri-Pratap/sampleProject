package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(ChromeOptions options) {
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            System.out.println("QUIT DRIVER: " + Thread.currentThread().getId());
            driver.get().quit();
            driver.remove();
        }
    }
}
