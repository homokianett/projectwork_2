package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(css = ".container")
    private WebElement dashboardContainer;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void waitForDashboard() {
        waitForVisibility(dashboardContainer);
    }
}