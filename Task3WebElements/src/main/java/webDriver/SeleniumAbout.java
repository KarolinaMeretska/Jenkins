package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumAbout {
    private WebDriver driver;
    private By aboutPageTitle = By.xpath("//*[@id='mainContent']/h2");
    private By searchNewsBlog = By.xpath("//*[@id='nav']/li/ul/li[1]/a");
    private By seleniumEvents = By.xpath("//div[@id='mainContent']/h3[2]/a");

    public SeleniumAbout(WebDriver driver) {
        this.driver = driver;
    }

    public String getAboutPageTitle() {
        return driver.findElement(aboutPageTitle).getText();
    }

    public SeleniumAbout clickNewsBlog() {
        driver.findElement(searchNewsBlog).click();
        return this;
    }

    public SeleniumEvents clickSeleniumEvents() {
        driver.findElement(seleniumEvents).click();
        return new SeleniumEvents(driver);
    }

}
