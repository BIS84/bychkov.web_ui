package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class MainCRMPerson {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // неявное ожидание 15 секунд.
    }

    public static void main(String[] args) throws InterruptedException {

        // log in
        login();

        // переход на страницу создания контактного лица
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Контрагенты")));
        WebElement element = driver.findElement(xpath("//span[contains(.,'Контрагенты')]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        driver.findElement(xpath(".//span[contains(.,'Контактные лица')]")).click();
        driver.findElement(By.linkText("Создать контактное лицо")).click();

        // создание контактного лица
        // Фамилия
        WebElement lastName = driver.findElement(By.name("crm_contact[lastName]"));
        lastName.sendKeys("Geekbrains");

        String valueContactPersonLastName = lastName.getAttribute("value");
        System.out.println("Фамилия: " + valueContactPersonLastName.equals("Geekbrains"));

        // Имя
        WebElement firstName = driver.findElement(By.name("crm_contact[firstName]"));
        firstName.sendKeys("Stud");

        String valueContactPersonFirstName = firstName.getAttribute("value");
        System.out.println("Имя: " + valueContactPersonFirstName.equals("Stud"));

        // Организация
        driver.findElement(By.cssSelector(".select2-chosen")).click();
        driver.findElement(xpath("//*[@id='select2-drop']/ul[2]/li[5]/div")).click();

        String organizationName = driver.findElement(xpath("//div[@class='controls']/div/div[1]/a/span[1]")).getText();
        System.out.println("Организация: " + organizationName.equals("123test"));

        // Должность
        WebElement jobTitle = driver.findElement(By.name("crm_contact[jobTitle]"));
        jobTitle.sendKeys("Student");

        String valuePosition = jobTitle.getAttribute("value");
        System.out.println("Должность: " + valuePosition.equals("Student"));

        // Сохранение
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();

        // Проверка, что контактное лицо создано

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".btn-group:nth-child(4) > .btn")));

        driver.findElement(By.cssSelector(".filter-item:nth-child(1) .filter-criteria-hint")).click();
        driver.findElement(By.name("value")).sendKeys("Geekbrains Stud");
        driver.findElement(By.cssSelector(".filter-update")).click();
        Thread.sleep(5000);

        String contactPerson = driver.findElement(xpath("//td")).getText();
        System.out.println("\nКонтактное лицо сохранено: " + contactPerson.equals("Geekbrains Stud"));

        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement prependedInput = driver.findElement(By.id("prependedInput"));
        prependedInput.click();
        prependedInput.sendKeys(STUDENT_LOGIN);

        WebElement prependedInput2 = driver.findElement(By.id("prependedInput2"));
        prependedInput2.click();
        prependedInput2.sendKeys(STUDENT_PASSWORD);

        driver.findElement(By.id("_submit")).click();
    }
}
