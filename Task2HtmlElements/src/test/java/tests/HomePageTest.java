package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.impl.HealthCarePage;
import pages.impl.HomePage;
import pages.impl.LoginResultPage;
import pages.impl.SearchResultPage;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private LoginResultPage loginResultPage;
    private HealthCarePage healthCarePage;

    @BeforeClass
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        loginResultPage = new LoginResultPage(driver);
        healthCarePage = new HealthCarePage(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

//    /**
//     *This test checks the opening of the search page after the search query
//     */
//    @Test
//    public void checkSearchPageOpeningAfterSearchQuery() {
//        homePage.openPage();
//        homePage.search("Brelil");
//        searchResultPage.isPageLoaded();
//        assertThat(searchResultPage.isPageLoaded())
//                .as("Search results Page wasn't loaded")
//                .isTrue();
//    }
//
//    /**
//     * This test checks that after the search in the "Новинки" section, all items contains "Brelil"
//     */
//    @Test
//    public void checkSearchOnHomePage() {
//        homePage.openPage();
//        homePage.search("Brelil");
//        searchResultPage.isPageLoaded();
//        searchResultPage.getSearchResultItemsNames()
//                .forEach(itemName ->
//                        assertThat(itemName.contains("Brelil"))
//                                .as("Found item, that shouldn't be is search results: %s", itemName)
//                                .isTrue());
//    }

    /**
     * Checks user login in with valid data
     */
    @Test
    public void checksUserLoginIn() {
        homePage.openPage();
        homePage.loginIn("kilyakilya24@gmail.com","aA543210");
        loginResultPage.isPageLoaded();
        assertThat(loginResultPage.isPageLoaded())
                .as("Search results Page wasn't loaded")
                .isTrue();

    }

    @Test
    public void verifySubscriptionFromHaelthAndCarePage() {
        homePage.openPage();
        homePage.redirect();
        healthCarePage.isPageLoaded();
        healthCarePage.verifyingSubscription();
        assertThat(healthCarePage.verifyingSubscription())
                .as("Not subscribed")
                .isTrue();

    }

    @AfterClass
    public void stopDriver() {
        driver.quit();
    }

}
