package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawPage extends BasePage {

    @FindBy(id = "account")
    private WebElement accountDropdown;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;

    public WithdrawPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://eng.digitalbank.masterfield.hu/bank/withdraw");
    }

    public void withdraw(String account, String amount) {
        waitForVisibility(accountDropdown);
        selectByVisibleText(accountDropdown, account);

        waitForVisibility(amountField);
        amountField.sendKeys(amount);

        submitButton.click();
    }

    public void withdrawWithoutAmount(String account) {
        waitForVisibility(accountDropdown);
        selectByVisibleText(accountDropdown, account);
        submitButton.click();
    }

    public void withdrawWithoutAccount(String amount) {
        waitForVisibility(amountField);
        amountField.sendKeys(amount);
        submitButton.click();
    }

    public void verifySuccessMessage() {
        waitForVisibility(successMessage);
    }

    public void verifyErrorMessage() {
        waitForVisibility(errorMessage);
    }
}