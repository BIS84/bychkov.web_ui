package CRM.model.pages.pages;

import CRM.model.pages.base.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllMyProjectsPage extends BasePage {

    @FindBy(linkText = "Создать проект")
    private WebElement createNewProjectButton;

    public AllMyProjectsPage(WebDriver driver) { super(driver);}

    @Step(value = "Click button 'Create new project'")
    public CreateNewProjectPage clickOnCreateNewProjectButton() {
        createNewProjectButton.click();
        return new CreateNewProjectPage(driver);
    }

    @Step(value = "Check that the pop-up 'Проект сохранен' has appeared")
    public void checkNewProjectPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Проект сохранен"));
    }
}