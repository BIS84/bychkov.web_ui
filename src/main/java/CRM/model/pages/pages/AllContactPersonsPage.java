package CRM.model.pages.pages;

import CRM.model.pages.base.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllContactPersonsPage extends BasePage {

    @FindBy(linkText = "Создать контактное лицо")
    public WebElement createNewContactPersonButton;

    public AllContactPersonsPage(WebDriver driver) { super(driver);}

    @Step(value = "Click button 'Create new contact person'")
    public CreateNewContactPersonPage clickOnCreateNewContactPersonButton() {
        createNewContactPersonButton.click();
        return new CreateNewContactPersonPage(driver);
    }

    @Step(value = "Check that the pop-up 'Контактное лицо сохранено' has appeared")
    public void checkNewContactPersonPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Контактное лицо сохранено"));
    }
}