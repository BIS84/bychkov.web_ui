package CRM.base;

import CRM.model.pages.common.Values;
import CRM.model.pages.listener.CustomListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class BaseTestCRM {

    protected EventFiringWebDriver driver;


    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeTest() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

//        driver = new ChromeDriver(options);

        // Конфигурирование логгирования драйвера через интерфейс RemoteWebDriver
        RemoteWebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.setLogLevel(Level.INFO);

        // Обертка драйвера в EventFiringWebDriver, умеющего регистрировать кастомные листнеры
        driver = new EventFiringWebDriver(chromeDriver);
        driver.register(new CustomListener());

        // Остальная часть может быть использована без изменений
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Values.LOGIN_PAGE_URL);

    }

    @AfterEach
    public void tearDown() {
        // Вывод всех ошибок юраузера после каждого теста
        driver
                .manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);

        driver.quit();
    }
}