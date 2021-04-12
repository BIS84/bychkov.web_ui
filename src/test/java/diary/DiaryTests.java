package diary;


import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static diary.ConfigurationDiary.*;
import static org.hamcrest.CoreMatchers.is;

public  class DiaryTests extends BaseTestDiary {

    @Test
    public void logInTrue() {
        MatcherAssert.assertThat(driver.findElement(By.id(ID_AUTHOR)).getText(), is(LOGIN));
    }

    @Test
    public void TestText() {
        driver.findElement(By.id(ID_TEXT)).click();
        driver.findElement(By.id(ID_TEXT)).sendKeys(TEST_TEXT);
        driver.findElement(By.id(ID_BTN_SAVE)).click();
        MatcherAssert.assertThat(driver.findElement(By.xpath(XPATH_TEST_TEXT)).getText(), is(TEST_TEXT));
    }

    @Test
    public void testNewPalette() {

        Actions actions = new Actions(driver);
        WebElement customization = driver.findElement(By.linkText(LINK_TEXT_CUSTOMIZATION));

        actions
                .moveToElement(customization)
                .click()
                .build()
                .perform();

        driver.findElement(By.linkText(LINK_TEXT_CHOOSE_ANOTHER)).click();

        WebElement element = driver.findElement(By.linkText(LINK_TEXT_CHOOSE_ANOTHER));
        driver.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.executeScript("arguments[0].click();", element);

        Actions theme = new Actions(driver);
        WebElement themeForTest = driver.findElement(By.linkText(THEME_FOR_TEST));
        WebElement btnSave = driver.findElement(By.cssSelector(BTN_SAVE_CSS_SELECTOR));

        theme
                .moveToElement(themeForTest)
                .click()
                .moveToElement(btnSave)
                .click()
                .build()
                .perform();

        driver.get(PAGE_CUSTOMIZATION_URL);
        Assertions.assertEquals(driver.findElement(By.xpath(XPATH_CURRENT_PALETTE)).getText(), THEME_FOR_TEST);
    }

    @Test
    public void testSearchByKeyWord() {

        Actions testSearch = new Actions(driver);
        WebElement search = driver.findElement(By.id(FIELD_SEARCH));
        WebElement btnSearch = driver.findElement(By.id(BTN_SEARCH));

        testSearch
                .moveToElement(search)
                .click()
                .sendKeys(KEY_WORD)
                .moveToElement(btnSearch)
                .click()
                .build()
                .perform();

        Assertions.assertTrue(driver.findElement(By.xpath(XPATH_FOUND_TEXT)).getText().contains(KEY_WORD));
    }

    @AfterEach
    void exit() {
        driver.findElement(By.linkText(LINK_TEXT_EXIT_BTN)).click();

        driver.close();
    }

    @AfterAll
    static void quit() {
        driver.quit();
    }
}