package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".alert.alert-danger")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://eng.digitalbank.masterfield.hu/bank/login");
    }

    public void login(String username, String password) {

        waitForVisibility(usernameField);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void assertErrorMessage() {
        waitForVisibility(errorMessage);

        if (!errorMessage.isDisplayed()) {
            throw new AssertionError("Error message is NOT visible, but it should be!");
        }
    }
}