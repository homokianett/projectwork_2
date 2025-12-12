package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BannerPage extends BasePage {

    public BannerPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://eng.digitalbank.masterfield.hu/bank/login");
    }

    public void acceptCookies() {
        try {


            WebElement okButton = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
            waitForVisibility(okButton);
            okButton.click();


            try {
                WebElement overlay = driver.findElement(By.cssSelector(".freeprivacypolicy-com---nb-interstitial-overlay"));
                waitForInvisibility(overlay);
            } catch (Exception ignored) {}

        } catch (Exception e) {
            System.out.println("No cookie popup was displayed.");
        }
    }
}