package test_webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import webDriver.*;

import java.util.concurrent.TimeUnit;

public class BaseTestWE {
    WebDriver driver;
    private String google = "https://www.google.com";
    String searchString = "Selenium Web Driver";
    String expected = "Selenium WebDriver";
    String expectedAboutPageTitle = "About Selenium";
    String expectedNewsPageTitle = "Selenium News";
    SeleniumPage seleniumPage;
    RedirectCssPage redirectCssPage;
    SeleniumAbout seleniumAbout;
    GooglePage googlePage;
    SeleniumNews seleniumNews;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        seleniumPage = new SeleniumPage(driver);
        seleniumAbout = new SeleniumAbout(driver);
        seleniumNews = new SeleniumNews(driver);
        redirectCssPage = new RedirectCssPage(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(google);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
