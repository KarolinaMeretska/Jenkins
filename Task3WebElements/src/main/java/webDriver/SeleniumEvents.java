package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SeleniumEvents {
    private WebDriver driver;
    private By conferences = By.xpath("//div[@id='mainContent']/ul/li");

    public SeleniumEvents(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getTextConferences() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(conferences));
        List<WebElement> conferencesList = driver.findElements(conferences);
        return conferencesList;
    }
}
