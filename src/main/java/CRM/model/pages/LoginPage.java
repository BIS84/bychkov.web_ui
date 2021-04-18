package CRM.model.pages;

import CRM.model.pages.common.Values;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

    @FindBy(css = "input[id='prependedInput']")
    private WebElement loginInput;

    @FindBy(css = "input[id='prependedInput2']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[@name='_submit']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login() {

        driver.get(LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterLogin(Values.STUDENT_LOGIN)
                .enterPassword(Values.STUDENT_PASSWORD)
                .clickLoginButton();

        return new HomePage(driver);
    }

    public LoginPage enterLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        buttonSignIn.click();
        return new HomePage(driver);
    }
}