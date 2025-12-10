package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // --- Lokátorok ---
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "h3.text-primary")   // Dashboard fejléc
    private WebElement dashboardHeader;

    @FindBy(css = ".alert.alert-danger")   // Hibás login üzenet
    private WebElement errorMessage;


    // --- Konstruktor ---
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    // --- Oldal megnyitása ---
    public void open() {
        driver.get("https://eng.digitalbank.masterfield.hu/bank/login");
    }


    // --- Bejelentkezés ---
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }


    // --- Dashboard ellenőrzése ---
    public boolean isDashboardVisible() {
        try {
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    // --- Hibaüzenet ellenőrzése ---
    public boolean isErrorVisible() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}