package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MainCRMProject {

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

        // переход на страницу создания проекта
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Проекты")));
        WebElement element = driver.findElement(By.xpath("//span[contains(.,'Проекты')]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        driver.findElement(By.xpath(".//span[contains(.,'Мои проекты')]")).click();
        driver.findElement(By.linkText("Создать проект")).click();

        // создание проекта
        // Наименование
        String myRandomNumberStr = Double.toString(Math.random());
        WebElement projectName = driver.findElement(By.name("crm_project[name]"));
        projectName.sendKeys(myRandomNumberStr);

        String valueProjectName = projectName.getAttribute("value");
        System.out.println("Наименование: " + valueProjectName.equals(myRandomNumberStr));

        // Организация
        driver.findElement(By.cssSelector(".select2-default > .select2-chosen")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[5]/div")).click();

        String organizationName = driver.findElement(By.xpath("//div/a/span")).getText();
        System.out.println("Организация: " + organizationName.equals("123test"));

        // Контактное лицо
        driver.findElement(By.xpath("//*[@class='select2-container select2']")).click();
        WebElement contactPersonWeb = driver.findElement(By.cssSelector(".select2-focused"));
        contactPersonWeb.sendKeys("Geekbrains Stud");
        contactPersonWeb.sendKeys(Keys.ENTER);

        String contactPerson = driver.findElement(By.xpath("//div[2]/div/a/span[1]")).getText();
        System.out.println("Контактное лицо: " + contactPerson.equals("Geekbrains Stud"));

        // Подразделение
        Select businessUnitDropDown = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropDown.selectByValue("1");

        String subdivision = driver.findElement(By.xpath("//div[5]/div[2]/div/span")).getText();
        System.out.println("Подразделение: " + subdivision.equals("Research & Development"));

        // Куратор проекта
        Select curatorOfProject  = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorOfProject.selectByVisibleText("Applanatest Applanatest Applanatest");

        String textCuratorOfProject = driver.findElement(By.xpath("//div[6]/div[2]/div/span")).getText();
        System.out.println("Куратор проекта: " + textCuratorOfProject.equals("Applanatest Applanatest Applanatest"));

        // Руководитель проекта
        Select leaderOfProject  = new Select(driver.findElement(By.name("crm_project[rp]")));
        leaderOfProject.selectByVisibleText("Студентов Студент");

        String textLeaderOfProject = driver.findElement(By.xpath("//div[7]/div[2]/div/span")).getText();
        System.out.println("Руководитель проекта: " + textLeaderOfProject.equals("Студентов Студент"));

        // Администратор проекта
        Select administratorOfProject  = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorOfProject.selectByVisibleText("Гикбрейнс Студент");

        String textAdministratorOfProject = driver.findElement(By.xpath("//div[8]/div[2]/div/span")).getText();
        System.out.println("Администратор проекта: " + textAdministratorOfProject.equals("Гикбрейнс Студент"));

        // Менеджер проекта
        Select managerOfProject  = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerOfProject.selectByVisibleText("Applanatest Applanatest Applanatest");

        String textManagerOfProject = driver.findElement(By.xpath("//div[9]/div[2]/div/span")).getText();
        System.out.println("Менеджер проекта: " + textManagerOfProject.equals("Applanatest Applanatest Applanatest"));

        // Сохранение проекта
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();

        // проверка, что проект сохранился
        WebElement linkButton = driver.findElement(By.xpath("//div[2]/a/i"));
        WebDriverWait wait3 = new WebDriverWait(driver, 5);
        wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[4]/button")));
        WebDriverWait wait4 = new WebDriverWait(driver, 5);
        wait4.until(ExpectedConditions.elementToBeClickable(linkButton));
        linkButton.click();

        WebElement button2 = driver.findElement(By.xpath("//div[2]/button"));
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.visibilityOf(button2));

        driver.findElement(By.name("search")).sendKeys(myRandomNumberStr);

        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(ExpectedConditions.visibilityOf(button2));

        driver.findElement(By.cssSelector(".btn-search")).click();
        WebDriverWait wait5 = new WebDriverWait(driver, 5);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".selected > a")));

        Thread.sleep(5000);
        String projectName2;
        String str1 = driver.findElement(By.cssSelector(".user-name > a")).getText();
        if (str1.equals(myRandomNumberStr)) {
            projectName2 = str1;
        }
        else {
            projectName2 = driver.findElement(By.cssSelector(".grid-row:nth-child(3) .clearfix a")).getText();
        }
        System.out.println("\nПроект создан: " + projectName2.equals(myRandomNumberStr));

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
