package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayPalPage {
    private WebDriver driver;
    private By payPal = By.xpath("//a[@id='payWithPP']");
    private By currencyAmount = By.id("currencyAmount");

    public PayPalPage(WebDriver driver) {
        this.driver = driver;
    }

    public PayPalPage checkDisplayedPaypal() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(payPal));
        driver.findElement(payPal).isDisplayed();
        return this;
    }

    public PayPalPage inputData(String amount) {
        driver.findElement(currencyAmount).sendKeys(amount);
        return this;
    }

    public PayPalEmail clickDonateWithPayPal () {
        driver.findElement(payPal).click();
        return new PayPalEmail(driver);
    }

}
