package fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(className = "header-top ")
public class UserAccount extends HtmlElement {

    @FindBy(xpath = "//div[@class='header-top']//div//div//div")
    private HtmlElement entranceToTheCabinet;
    @FindBy(css = "input[name='user_login']")
    private HtmlElement userLogin;
    @FindBy (css = "input[name='user_pw']")
    private HtmlElement userPassword;
    @FindBy(xpath = "//form[@id='form-auth']//button")
    private Button submit;

    public void inputTextToUserAccount(String login, String password) {
        entranceToTheCabinet.click();
        userLogin.clear();
        userLogin.sendKeys(login);
        userPassword.click();
        userPassword.clear();
        userPassword.sendKeys(password);
    }
    public void clickSubmit() {
        submit.click();
    }
}
