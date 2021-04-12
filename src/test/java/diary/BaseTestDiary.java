package diary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static diary.ConfigurationDiary.*;

public abstract class BaseTestDiary {

    public static ChromeDriver driver;
    public WebDriverWait wait15second;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        wait15second = new WebDriverWait(driver, 15);

        login();

        driver.findElement(By.linkText(LINK_TEXT_CUSTOMIZATION)).click();
        driver.findElement(By.linkText(LINK_TEXT_CHOOSE_ANOTHER)).click();
        driver.findElement(By.linkText(THEME)).click();
        driver.findElement(By.cssSelector(BTN_SAVE_CSS_SELECTOR)).click();
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }


    public static void login() {

        driver.get(LOGIN_PAGE_URL);

        WebElement nik = driver.findElement(By.id(ID_LOGIN));
        nik.click();
        nik.sendKeys(LOGIN);

        WebElement password = driver.findElement(By.id(ID_PASSWORD));
        password.click();
        password.sendKeys(PASSWORD);

        driver.findElement(By.id(ID_LOGIN_SUBMIT)).click();
    }
}