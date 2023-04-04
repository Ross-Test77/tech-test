package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtil {

    private static WebDriver webDriver;

    public static synchronized WebDriver getWebDriver(){
        if (webDriver == null) {
            initialize();
        }
        return webDriver;
    }

    private static void initialize(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        webDriver = new ChromeDriver();
    }

    public static void shutDown(){
        webDriver.close();
        webDriver.quit();
    }
}
