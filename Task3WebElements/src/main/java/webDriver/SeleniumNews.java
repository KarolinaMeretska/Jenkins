package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumNews {
    private WebDriver driver;
    private By pageTitleNews = By.xpath("//*[@id='mainContent']/h2");

    public SeleniumNews(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitleNews() {
        return driver.findElement(pageTitleNews).getText();
    }

}
