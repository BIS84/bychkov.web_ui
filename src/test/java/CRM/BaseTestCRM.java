package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static CRM.ConfigurationCRM.*;
import static CRM.ConfigurationCRM.LOGIN_PAGE_URL;

public abstract class BaseTestCRM {

    public static WebDriver driver;
    public static WebDriverWait wait15second;

    @BeforeAll
    public static void beforeAll() {

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
    }

    @AfterAll
    public static void tearDown() {

        driver.close();
        driver.quit();
    }


    public static void login() {

        driver.get(LOGIN_PAGE_URL);

        WebElement prependedInput = driver.findElement(By.id(ID_STUDENT_LOGIN));
        prependedInput.click();
        prependedInput.sendKeys(STUDENT_LOGIN);

        WebElement prependedInput2 = driver.findElement(By.id(ID_STUDENT_PASSWORD));
        prependedInput2.click();
        prependedInput2.sendKeys(STUDENT_PASSWORD);

        driver.findElement(By.id(BTN_LOGIN_SUBMIT_CRM)).click();
    }
}