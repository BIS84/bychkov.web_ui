package CRM.model.pages.pages;

import CRM.model.pages.base.BasePage;
import CRM.model.pages.common.Values;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    @FindBy(linkText = "Контрагенты")
    public WebElement counterParties;

    @FindBy(linkText = "Контактные лица")
    public WebElement contactPersons;

    @FindBy(linkText = "Проекты")
    public WebElement projects;

    @FindBy(linkText = "Мои проекты")
    public WebElement myProjects;

    public HomePage (WebDriver driver) {
        super(driver);
    }

    @Step(value = "Check authorization")
    public void checkUrl() {
        assertEquals(driver.getCurrentUrl(), Values.MENU_PAGE_URL);
    }

    @Step(value = "Click counter parties in menu")
    public HomePage clickCounterParties() {
        counterParties.click();
        return this;
    }

    @Step(value = "Click contact person in menu")
    public AllContactPersonsPage goToAllContactPersonsPage() {
        contactPersons.click();
        return new AllContactPersonsPage(driver);
    }

    @Step(value = "Click projects in menu")
    public HomePage clickProjects() {
        projects.click();
        return this;
    }

    @Step(value = "Click my projects in menu")
    public AllMyProjectsPage goToAllMyProjectsPage(){
        myProjects.click();
        return new AllMyProjectsPage(driver);
    }
}