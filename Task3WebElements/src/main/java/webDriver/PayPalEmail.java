package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayPalEmail {
    private WebDriver driver;
    private By  email = By.id("email");
    private By nextButton = By.id("btnNext");
    private By emailErrorMessage = By.id("emailErrorMessage");

    public PayPalEmail(WebDriver driver) {
        this.driver = driver;
    }

    public PayPalEmail inputEmail(String emailData) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(email));
        driver.findElement(email).click();
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailData);
        return this;
    }
    public PayPalEmail clickOnNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public PayPalEmail checkEmailErrorMessage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(emailErrorMessage));
        driver.findElement(emailErrorMessage).isDisplayed();
        return this;
    }
}
