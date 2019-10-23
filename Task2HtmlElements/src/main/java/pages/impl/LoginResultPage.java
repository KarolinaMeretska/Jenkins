package pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class LoginResultPage extends BasePage {
    @FindBy(className = "form-inner-wrap")
    private Form formLogin;
  //  @FindBy(css = "a[href='/user/']")
   // private HtmlElement cabinet;

    public LoginResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getLoadableElement() {
        //return cabinet;
        return formLogin;
    }
}
