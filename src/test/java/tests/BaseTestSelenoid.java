package tests;

import config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.aeonbits.owner.ConfigFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.Duration;

public class BaseTestSelenoid {

    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;

    // экземпляр файла конфигурации с общими параметрами
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Общие настройки для всех тестов, перед выполнением каждого
     */
    @BeforeMethod
    public void setUp() throws Exception {
        // Установка настроек для Chrome
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "116.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", true);
        }});

        // создание экземпляра драйвера с использованием RemoteWebDriver
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        // открытие страницы по url
        driver.get(config.url());  // открывает и переходит по ссылке

        // разворот страницы на полное окно
        driver.manage().window().maximize(); // максимальный размер окна для удобства

        // Неявное ожидание по умолчанию 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Stating the Javascript Executor driver
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    /**
     * Общие настройки для всех тестов, после выполнения каждого
     */
    @AfterMethod
    public void tearDown() {
        // остановка работы драйвера
        driver.quit();
    }
}