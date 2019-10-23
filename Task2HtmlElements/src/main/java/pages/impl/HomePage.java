package pages.impl;

import fragments.FooterSubscriptions;
import fragments.SearchForm;
import fragments.UserAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

public class HomePage extends BasePage {

//    @FindBy(className = "//div[@id='slider-id-1570695516836']/div/ul")
//    private HtmlElement best_sellers;

    private SearchForm searchForm;
    private UserAccount userAccount;

    @FindBy(xpath = "//ul[@class='menu-list']/li/a[@href='/ua/categorys/339969/']")
    private Link linkHealthAndCare;

    public HomePage(WebDriver driver) {
        super(driver);
       // userAccount = new UserAccount();
    }

    public void search(String text) {
        searchForm.inputTextToSearchField(text);
    }

    public void loginIn(String login, String password) {
        userAccount.inputTextToUserAccount(login, password);
        userAccount.clickSubmit();
    }

    public void redirect() {
        linkHealthAndCare.click();
    }

    @Override
    public WebElement getLoadableElement() {
        //return best_sellers;
        return null;
    }


}
