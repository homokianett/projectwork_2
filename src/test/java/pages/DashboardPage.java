package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h3.text-primary")
    private WebElement welcomeHeader;

    public boolean isDashboardDisplayed() {
        try {
            waitForVisibility(welcomeHeader);
            return welcomeHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}