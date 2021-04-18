package CRM.model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    public static final String MENU_PAGE_URL = "https://crm.geekbrains.space/";

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

    public void checkUrl() {
        assertEquals(driver.getCurrentUrl(), MENU_PAGE_URL);
    }

    public HomePage clickCounterParties() {
        counterParties.click();
        return this;
    }

    public AllContactPersonsPage goToAllContactPersonsPage() {
        contactPersons.click();
        return new AllContactPersonsPage(driver);
    }

    public HomePage clickProjects() {
        projects.click();
        return this;
    }

    public AllMyProjectsPage goToAllMyProjectsPage(){
        myProjects.click();
        return new AllMyProjectsPage(driver);
    }
}

