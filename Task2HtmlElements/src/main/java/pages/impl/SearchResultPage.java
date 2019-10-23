package pages.impl;

import fragments.search_result.SearchResultItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(className = "site-wrap")
    private HtmlElement catalogSection;

    private List<SearchResultItem> searchResultItemList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        super.PAGE_URL += "search/";
    }

    public List<String> getSearchResultItemsNames() {
        ArrayList<String> names = new ArrayList();
        searchResultItemList.forEach(item -> names.add(item.getItemName()));
        return names;
    }

    @Override
    public WebElement getLoadableElement() {
        return catalogSection;
    }
}
