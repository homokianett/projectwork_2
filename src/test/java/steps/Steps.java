package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.BannerPage;
import pages.LoginPage;
import pages.DashboardPage;
import pages.WithdrawPage;

public class Steps {

    private WebDriver driver;
    private BannerPage bannerPage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WithdrawPage withdrawPage;

    // ---------------- LOGIN ----------------

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

    // LOGIN ERROR
    @Then("an error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        loginPage.assertErrorMessage();
    }


    // ---------------- WITHDRAW ----------------

    @When("the user withdraws {int} from account {string}")
    public void withdraw(int amount, String account) {
        withdrawPage = new WithdrawPage(Hooks.driver);
        withdrawPage.open();
        withdrawPage.withdraw(account, String.valueOf(amount));
    }

    @Then("a success message should be displayed")
    public void successMessage() {
        withdrawPage.verifySuccessMessage();
    }

    @When("the user tries to withdraw with empty amount from {string}")
    public void withdrawEmptyAmount(String account) {
        withdrawPage = new WithdrawPage(Hooks.driver);
        withdrawPage.open();
        withdrawPage.withdrawWithoutAmount(account);
    }

    @When("the user tries to withdraw {int} with no account selected")
    public void withdrawNoAccount(int amount) {
        withdrawPage = new WithdrawPage(Hooks.driver);
        withdrawPage.open();
        withdrawPage.withdrawWithoutAccount(String.valueOf(amount));
    }


    @Then("a withdraw error message should be displayed")
    public void withdrawErrorMessage() {
        withdrawPage.verifyErrorMessage();
    }
}