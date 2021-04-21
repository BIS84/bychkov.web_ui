package CRM.features.contactPerson;

import CRM.base.BaseTestCRM;
import CRM.model.pages.pages.LoginPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Contact person")
public class ContactPersonTest  extends BaseTestCRM {

    @Test
    @DisplayName("Проверка создания контактного лица")
    void createContactPersonTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .login()
                .clickCounterParties()
                .goToAllContactPersonsPage()
                .clickOnCreateNewContactPersonButton()
                .lastName1()
                .firstName()
                .organization()
                .jobTitle()
                .saveNewContactPerson()
                .checkNewContactPersonPopUp();
    }
}