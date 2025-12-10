package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.BannerPage;
import pages.LoginPage;

public class Steps {

    private BannerPage bannerPage;
    private LoginPage loginPage;

    @Given("User opens the Digital Bank site")
    public void openDigitalBankSite() {
        bannerPage = new BannerPage(Hooks.driver);
        loginPage = new LoginPage(Hooks.driver);

        bannerPage.open();
    }

    @And("User accept cookies")
    public void acceptCookies() {
        bannerPage.acceptCookies();
    }

    @When("the user logs in with {string} and {string}")
    public void theUserLogsInWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the dashboard should be displayed")
    public void theDashboardShouldBeDisplayed() {
        Assertions.assertTrue(
                loginPage.isDashboardVisible(),
                "Dashboard should be visible after successful login"
        );
    }

    @Then("an error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        Assertions.assertTrue(
                loginPage.isErrorVisible(),
                "Error message should be visible after invalid login"
        );
    }
}