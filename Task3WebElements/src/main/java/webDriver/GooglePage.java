package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {
    private WebDriver driver;
    private By searchField = By.xpath("//input[@name='q']");
    private By searchButton = By.xpath("//div[@class='VlcLAe']//input[@name='btnK']");
    private By seleniumSearchResult = By.xpath("//div[@id='rso']/div[1]/div/div[2]/div/div/div[1]/a/h3");


    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public GooglePage enterValueToSearchField(String searchValue) {
        driver.findElement(searchField).sendKeys(searchValue);
        driver.findElement(searchButton).click();
        return this;
    }

    public GooglePage selectSearchResult() {
        driver.findElement(seleniumSearchResult).click();
        return this;
    }
}
