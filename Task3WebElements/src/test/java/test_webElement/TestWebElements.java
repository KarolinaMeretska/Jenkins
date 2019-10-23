package test_webElement;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import webDriver.*;
import static org.junit.Assert.assertEquals;

public class TestWebElements extends BaseTestWE {

    @Test()
    public void verifySeleniumWebDriverPage() {
        googlePage.enterValueToSearchField(searchString)
                .selectSearchResult();
        String actualSeleniumPage = seleniumPage.getPageTitle();
        assertEquals(expected, actualSeleniumPage);
        System.out.println("Actual result: " + actualSeleniumPage + "\n" + "Expected result: " + expected);
    }

    @Test(dependsOnMethods = {"verifySeleniumWebDriverPage"})
    public void verifyNewsBlogPage() {
        seleniumPage.clickAbout();
        String actualAboutPageTitle = seleniumAbout.getAboutPageTitle();
        assertEquals(actualAboutPageTitle, expectedAboutPageTitle);
        System.out.println("Actual result: " + actualAboutPageTitle + "\n" + "Expected result: " + expectedAboutPageTitle);
        seleniumAbout.clickNewsBlog();
        String actualNewsBlogTitle = seleniumNews.getPageTitleNews();
        assertEquals(actualNewsBlogTitle, expectedNewsPageTitle);
        System.out.println("Actual result: " + actualNewsBlogTitle + "\n" + "Expected result: " + expectedNewsPageTitle);
    }

    @Test(dependsOnMethods = {"verifySeleniumWebDriverPage"})
    public void checksRedirectingToNewPage() {
        seleniumPage.search("css");
        redirectCssPage.displayed();
    }

    @Test(dependsOnMethods = {"verifySeleniumWebDriverPage"})
    public void listContainsValidText() {
        seleniumAbout = new SeleniumAbout(super.driver);
        seleniumPage.clickAbout();
        seleniumAbout.clickSeleniumEvents().getTextConferences().
                forEach(itemName -> assertThat(itemName.getText().contains("talk recordings"))
                        .as("Found item, that shouldn't be is search results: %s", itemName)
                        .isTrue());
    }

    @Test(dependsOnMethods = {"verifySeleniumWebDriverPage"})
    public void containsText() {
        seleniumPage.clickSupport()
                    .verifyDisplayedSupportPage()
                    .clickDonate()
                    .checkDisplayedPaypal();
    }

    @Test(dependsOnMethods = {"verifySeleniumWebDriverPage"})
    public void invalidEmail() {
        seleniumPage.clickSupport()
                    .verifyDisplayedSupportPage()
                    .clickDonate()
                    .checkDisplayedPaypal()
                    .inputData("1005")
                    .clickDonateWithPayPal()
                    .inputEmail("ats15ts@")
                    .clickOnNextButton()
                    .checkEmailErrorMessage();
    }
}
