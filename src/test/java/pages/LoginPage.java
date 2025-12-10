package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.DriverFactory;

public class LoginPage {

    private WebDriver driver;

    // Constructor
    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By cookieAcceptButton = By.id("acceptCookies");
    private By dashboardHeader = By.xpath("//h1[contains(text(), 'Dashboard')]");
    private By errorMessage = By.cssSelector(".alert-danger");

    // Methods used in Steps.java
    public void open() {
        driver.get("https://eng.digitalbank.masterfield.hu/bank/login");
    }

    public void acceptCookies() {
        try {
            WebElement accept = driver.findElement(cookieAcceptButton);
            accept.click();
        } catch (Exception ignored) {
            // cookie banner may not always appear
        }
    }

    public void fillUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isDashboardVisible() {
        try {
            return driver.findElement(dashboardHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorVisible() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Optional combined login method (if ever needed)
    public void login(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
    }
}