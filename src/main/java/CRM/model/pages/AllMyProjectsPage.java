package CRM.model.pages;

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

    public CreateNewProjectPage clickOnCreateNewProjectButton() {
        createNewProjectButton.click();
        return new CreateNewProjectPage(driver);
    }

    public void checkNewProjectPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Проект сохранен"));
    }
}
