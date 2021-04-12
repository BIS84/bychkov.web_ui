package CRM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static CRM.ConfigurationCRM.*;
import static org.openqa.selenium.By.xpath;

public class CRMTests extends BaseTestCRM {

    // создание проекта
    // Наименование
    @Test
    public void createProjectTest() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LINK_TEXT_PROJECTS)));
        WebElement element = driver.findElement(By.xpath(XPATH_PROJECTS_ELEMENT));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        driver.findElement(By.xpath(XPATH_MY_PROJECTS)).click();
        driver.findElement(By.linkText(LINK_TEXT_CREATE_PROJECT)).click();

        WebElement projectName = driver.findElement(By.name(BY_NAME_PROJECT_NAME));
        projectName.sendKeys(MY_RANDOM_NUMBER_STR);

        // Организация
        driver.findElement(By.cssSelector(ORGANIZATION_CSS_SELECTOR)).click();
        driver.findElement(By.xpath(XPATH_ORGANIZATION)).click();

        // Контактное лицо
        driver.findElement(By.xpath(XPATH_CONTACT_PERSON_IN_PROJECT)).click();

        WebElement contactPersonWeb = driver.findElement(By.cssSelector(CONTACT_PERSON_CSS_SELECTOR));
        contactPersonWeb.sendKeys(CONTACT_PERSON_NAME);
        contactPersonWeb.sendKeys(Keys.ENTER);

        // Подразделение
        Select businessUnitDropDown = new Select(driver.findElement(By.name(BUSINESS_UNIT_NAME)));
        businessUnitDropDown.selectByValue(SUBDIVISION_SELECT_BY_VALUE);

        // Куратор проекта
        Select curatorOfProject = new Select(driver.findElement(By.name(CURATOR_BY_NAME)));
        curatorOfProject.selectByVisibleText(CURATOR_NAME);

        // Руководитель проекта
        Select leaderOfProject = new Select(driver.findElement(By.name(PROJECT_LEAD_BY_NAME)));
        leaderOfProject.selectByVisibleText(PROJECT_LEAD_NAME);

        // Администратор проекта
        Select administratorOfProject = new Select(driver.findElement(By.name(ADMINISTRATOR_BY_NAME)));
        administratorOfProject.selectByVisibleText(ADMINISTRATOR_NAME);

        // Менеджер проекта
        Select managerOfProject = new Select(driver.findElement(By.name(MANAGER_BY_NAME)));
        managerOfProject.selectByVisibleText(MANAGER_NAME);

        // Сохранение проекта
        driver.findElement(By.cssSelector(BTN_PROJECT_SAVE)).click();

        // проверка, что проект сохранился
        WebElement linkButton = driver.findElement(By.xpath("//div[2]/a/i"));
        wait15second.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[4]/button")));
        wait15second.until(ExpectedConditions.elementToBeClickable(linkButton));
        linkButton.click();

        WebElement button2 = driver.findElement(By.xpath("//div[2]/button"));
        wait15second.until(ExpectedConditions.visibilityOf(button2));
        driver.findElement(By.name("search")).sendKeys(MY_RANDOM_NUMBER_STR);
        wait15second.until(ExpectedConditions.visibilityOf(button2));
        driver.findElement(By.cssSelector(".btn-search")).click();
        wait15second.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".selected > a")));

        String projectName2;
        String str1 = driver.findElement(By.cssSelector(".user-name > a")).getText();
        if (str1.equals(MY_RANDOM_NUMBER_STR)) {
            projectName2 = str1;
        } else {
            projectName2 = driver.findElement(By.cssSelector(".grid-row:nth-child(3) .clearfix a")).getText();
        }
        Assertions.assertEquals(projectName2, MY_RANDOM_NUMBER_STR);
    }

    @Test
    public void createContactPersonTest() throws InterruptedException {

        // переход на страницу создания контактного лица

        wait15second.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LINK_TEXT_COUNTERPARTIES)));
        WebElement element = driver.findElement(xpath(XPATH_COUNTERPARTIES_ELEMENT));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        driver.findElement(xpath(XPATH_CONTACT_PERSON)).click();
        driver.findElement(By.linkText(LINK_TEXT_CREATE_CONTACT_PERSON)).click();

        // создание контактного лица
        // Фамилия
        WebElement lastName = driver.findElement(By.name(BY_NAME_LAST_NAME));
        lastName.sendKeys(CONTACT_PERSON_LAST_NAME);

        // Имя
        WebElement firstName = driver.findElement(By.name(BY_NAME_FIRST_NAME));
        firstName.sendKeys(CONTACT_PERSON_FIRST_NAME);

        // Организация
        driver.findElement(By.cssSelector(ORGANIZATION_NAME_CSS_SELECTOR)).click();
        driver.findElement(xpath(ORGANIZATION_NAME_XPATH)).click();

        // Должность
        WebElement jobTitle = driver.findElement(By.name(BY_NAME_JOB_TITLE));
        jobTitle.sendKeys(JOB_TITLE);

        // Сохранение
        driver.findElement(By.cssSelector(SAVE_BUTTON_CSS_SELECTOR)).click();

        // Проверка, что контактное лицо создано
        wait15second.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(SAVE_BUTTON_CSS_SELECTOR)));

        driver.findElement(By.cssSelector(FILTER_CSS_SELECTOR)).click();
        driver.findElement(By.name("value")).sendKeys(CONTACT_PERSON_LAST_NAME + " " + CONTACT_PERSON_FIRST_NAME);
        driver.findElement(By.cssSelector(FILTER_UPDATE_CSS_SELECTOR)).click();
        Thread.sleep(5000);
        Assertions.assertEquals(driver.findElement(xpath(XPATH_CONTACT_PERSON_CREATED)).getText(), CONTACT_PERSON_LAST_NAME + " " + CONTACT_PERSON_FIRST_NAME);
    }
}