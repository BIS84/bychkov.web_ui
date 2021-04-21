package CRM.model.pages.pages;

import CRM.model.pages.base.BasePage;
import CRM.model.pages.common.Values;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContactPersonPage extends BasePage {

    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastName;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstName;

    @FindBy(css = ".select2-chosen")
    private WebElement organizationName;

    @FindBy(xpath = "//*[@id='select2-drop']/ul[2]/li[5]/div")
    private WebElement organizationNameXpath;

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement jobTitle;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement saveContactPersonButton;

    public CreateNewContactPersonPage(WebDriver driver) { super(driver);}

    @Step(value = "Enter last name")
    public CreateNewContactPersonPage lastName1() {
        lastName.sendKeys(Values.CONTACT_PERSON_LAST_NAME);
        return this;
    }

    @Step(value = "Enter first name")
    public CreateNewContactPersonPage firstName() {
        firstName.sendKeys(Values.CONTACT_PERSON_FIRST_NAME);
        return this;
    }

    @Step(value = "Select organization")
    public CreateNewContactPersonPage organization() {
        organizationName.click();
        organizationNameXpath.click();
        return this;
    }

    @Step(value = "Enter job title")
    public CreateNewContactPersonPage jobTitle() {
        jobTitle.sendKeys(Values.JOB_TITLE);
        return this;
    }

    @Step(value = "Click 'save new contact person' button")
    public AllContactPersonsPage saveNewContactPerson() {
        saveContactPersonButton.click();
        return new AllContactPersonsPage(driver);
    }
}