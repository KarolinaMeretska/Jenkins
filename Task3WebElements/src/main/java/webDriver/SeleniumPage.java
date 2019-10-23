package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumPage {
    private WebDriver driver;
    private By pageTitle = By.xpath("//div[@id='mainContent']/h2");
    private By searchAbout = By.xpath("//li[@id='menu_about']");
    private By searchField = By.xpath("//form//input[@type='text']");
    private By submit = By.xpath("//form//input[@type='submit']");
    private By support = By.xpath("//a[@href='/support/']");

    public SeleniumPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public SeleniumPage clickAbout() {
        driver.findElement(searchAbout).click();
        return this;
    }

    public SeleniumPage search(String text) {
        driver.findElement(searchField).click();
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(text);
        driver.findElement(submit).click();
        return this;
    }

    public SupportPage clickSupport(){
        driver.findElement(support).click();
        return new SupportPage(driver);
    }



}
