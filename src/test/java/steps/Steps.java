package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.BannerPage;
import pages.LoginPage;
import pages.DashboardPage;

public class Steps {

    private WebDriver driver;
    private BannerPage bannerPage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("User opens the Digital Bank site")
    public void openDigitalBankSite() {

        driver = Hooks.driver;

        bannerPage = new BannerPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        bannerPage.open();
    }

    @Given("User accept cookies")
    public void user_accept_cookies() {
        bannerPage.acceptCookies();
    }

    @When("the user logs in with {string} and {string}")
    public void theUserLogsInWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        dashboardPage.waitForDashboard();
    }

    @Then("an error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        loginPage.assertErrorMessage();
    }
}