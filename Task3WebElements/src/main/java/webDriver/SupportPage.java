package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportPage {
    private WebDriver driver;
    private By pageSupport = By.xpath("//div[@id='container']");
    private By donate = By.xpath("//form[@method='post']//input[@name='submit']");

    public SupportPage(WebDriver driver) {
        this.driver = driver;
    }

    public SupportPage verifyDisplayedSupportPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(pageSupport));
        driver.findElement(pageSupport).isDisplayed();
        return this;
    }

    public PayPalPage clickDonate(){
       driver.findElement(donate).click();
        return new PayPalPage(driver);
    }
}
