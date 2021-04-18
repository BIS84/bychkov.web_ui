package CRM.features.loginTest;

import CRM.base.BaseTestCRM;
import CRM.model.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTestCRM {

    @Test
    @DisplayName("Проверка авторизации")
    void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .login()
                .checkUrl();
    }
}
