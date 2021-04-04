package diary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LogOn {

    private static final String LOGIN_PAGE_URL = "https://diary.anek.ws/";
    private static final String LOGIN = "Igor84";
    private static final String PASSWORD = "88888888";
    private static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // неявное ожидание 15 секунд.
    }

    public static void main(String[] args) {

        login();

        String text = driver.findElement(By.id("author")).getText();
        System.out.println("Авторизация прошла успешно: " + text.equals("Igor84"));

        driver.findElement(By.linkText("Выйти")).click();

        driver.close();

        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement nik = driver.findElement(By.id("Nik"));
        nik.click();
        nik.sendKeys(LOGIN);

        WebElement password = driver.findElement(By.id("Password"));
        password.click();
        password.sendKeys(PASSWORD);

        driver.findElement(By.id("login_subm")).click();
    }
}