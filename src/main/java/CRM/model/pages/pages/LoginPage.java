package CRM.model.pages.pages;

import CRM.model.pages.base.BasePage;
import CRM.model.pages.common.Values;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[id='prependedInput']")
    private WebElement loginInput;

    @FindBy(css = "input[id='prependedInput2']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[@name='_submit']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Authorization ")
    public HomePage login() {

        driver.get(Values.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterLogin(Values.STUDENT_LOGIN)
                .enterPassword(Values.STUDENT_PASSWORD)
                .clickLoginButton();

        return new HomePage(driver);
    }

    @Step(value = "Enter login {login}")
    public LoginPage enterLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Enter password {password}")
    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step(value = "Click login button")
    public HomePage clickLoginButton() {
        buttonSignIn.click();
        return new HomePage(driver);
    }
}