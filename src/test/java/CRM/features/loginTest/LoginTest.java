package CRM.features.loginTest;

import CRM.base.BaseTestCRM;
import CRM.model.pages.pages.LoginPage;
import CRM.model.pages.common.Values;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class LoginTest extends BaseTestCRM {

    @Test
    @DisplayName("Проверка авторизации")
    void loginTest() {
        driver.get(Values.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterLogin(Values.STUDENT_LOGIN)
                .enterPassword(Values.STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl();
    }
}