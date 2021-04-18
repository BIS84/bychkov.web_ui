package CRM.model.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static CRM.model.pages.common.Values.*;

public class CreateNewProjectPage extends BasePage {

    public static final String MY_RANDOM_NUMBER_STR = Double.toString(Math.random());

    @FindBy(name = "crm_project[name]")
    private WebElement projectName;

    @FindBy(css = ".select2-default > .select2-chosen")
    private WebElement organizationElement;

    @FindBy(xpath = "//*[@id='select2-drop']/ul[2]/li[5]/div")
    private WebElement organizationSelect;

    @FindBy(name = "crm_project[name]")
    private WebElement projectName2;

    @FindBy(css = ".select2-default > .select2-chosen")
    private WebElement selectOrganization;

    @FindBy(xpath = "//*[@id='select2-drop']/ul[2]/li[5]/div")
    private WebElement setOrganizationName;

    @FindBy(xpath = "//*[@class='select2-container select2']")
    private WebElement setContactPerson;

    @FindBy(css = ".select2-focused")
    private WebElement selectContactPerson;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnit;

    @FindBy(name = "crm_project[curator]")
    private WebElement curator;

    @FindBy(name = "crm_project[rp]")
    private WebElement TeamLeader;

    @FindBy(name = "crm_project[administrator]")
    private WebElement administrator;

    @FindBy(name = "crm_project[manager]")
    private WebElement manager;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement btnSaveProject;



    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }


    // Название проекта
    public CreateNewProjectPage setProjectName() {
        projectName2.sendKeys(MY_RANDOM_NUMBER_STR);
        return this;
    }

    // Организация
    public CreateNewProjectPage setOrganizationName() {
        selectOrganization.click();
        setOrganizationName.click();
        return this;
    }

    // Контактное лицо
    public CreateNewProjectPage setContactPerson() {
        setContactPerson.click();
        selectContactPerson.sendKeys(CONTACT_PERSON_NAME);
        selectContactPerson.sendKeys(Keys.ENTER);
        return this;
    }

    // Подразделение
    public CreateNewProjectPage setBusinessUnit() {
        Select setBusinessUnit = new Select(businessUnit);
        setBusinessUnit.selectByValue(SUBDIVISION_SELECT_BY_VALUE);
        return this;
    }

    // Куратор проекта
    public CreateNewProjectPage setCurator() {
        Select curatorOfProject = new Select(curator);
        curatorOfProject.selectByVisibleText(CURATOR_NAME);
        return this;
    }

    // Руководитель проекта
    public CreateNewProjectPage setLeaderOfProject() {
        Select leaderOfProject = new Select(TeamLeader);
        leaderOfProject.selectByVisibleText(PROJECT_LEAD_NAME);
        return this;
    }

    // Администратор проекта
    public CreateNewProjectPage setAdministrator() {
        Select administratorOfProject = new Select(administrator);
        administratorOfProject.selectByVisibleText(ADMINISTRATOR_NAME);
        return  this;
    }

    // Менеджер проекта
    public CreateNewProjectPage setManager() {
        Select managerOfProject = new Select(manager);
        managerOfProject.selectByVisibleText(MANAGER_NAME);
        return  this;
    }

    // Сохранение проекта
    public AllMyProjectsPage saveProject() {
        btnSaveProject.click();
        return new AllMyProjectsPage(driver);
    }
}
