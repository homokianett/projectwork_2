package pages;

import org.openqa.selenium.WebDriver;

public class BannerPage extends BasePage {

    public BannerPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://eng.digitalbank.masterfield.hu/bank/login");
    }

    public void acceptCookies() {
        // Ha nincs cookie banner, ezt hagyd üresen
    }
}