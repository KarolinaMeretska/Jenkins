package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedirectCssPage {
    private WebDriver driver;
    private By newPage = By.xpath("//div[@id='cse-body']");

    public RedirectCssPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean displayed() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(newPage));
        driver.findElement(newPage).isDisplayed();
        return true;
    }

}
