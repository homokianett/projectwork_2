package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1200, 900));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}