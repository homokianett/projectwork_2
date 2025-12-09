package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class Steps {

    private LoginPage loginPage;

    @Given("User opens the Digital Bank site")
    public void openDigitalBankSite() {
        loginPage = new LoginPage();
        loginPage.open();
    }

    @And("User accept cookies")
    public void acceptCookies() {
        loginPage.acceptCookies();
    }

    @When("the user enters {string} as username")
    public void enterUsername(String username) {
        loginPage.fillUsername(username);
    }

    @And("the user enters {string} as password")
    public void enterPassword(String password) {
        loginPage.fillPassword(password);
    }

    @And("the user clicks the Login button")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Then("the dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        assertTrue(loginPage.isDashboardVisible());
    }

    @Then("an error message should be displayed")
    public void errorDisplayed() {
        assertTrue(loginPage.isErrorVisible());
    }

    @When("the user enters a {string} and {string}")
    public void loginWithCredentials(String username, String password) {
        loginPage.login(username, password);
    }
}