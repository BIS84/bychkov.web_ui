package CRM.features.projects;

import CRM.base.BaseTestCRM;
import CRM.model.pages.pages.LoginPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Project")
public class NewProjectsTests extends BaseTestCRM {

    @Test
    @DisplayName("Проверка создания проекта")
    void createProjectTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .login()
                .clickProjects()
                .goToAllMyProjectsPage()
                .clickOnCreateNewProjectButton()
                .setProjectName()
                .setOrganizationName()
                .setContactPerson()
                .setBusinessUnit()
                .setCurator()
                .setLeaderOfProject()
                .setAdministrator()
                .setManager()
                .saveProject()
                .checkNewProjectPopUp();
    }
}