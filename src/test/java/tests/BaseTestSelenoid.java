package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTestSelenoid {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "116.0");

        // Улучшенная конфигурация для Selenoid
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("name", "Test badge...");
        selenoidOptions.put("sessionTimeout", "15m");
        selenoidOptions.put("env", new String[]{"TZ=UTC"});
        selenoidOptions.put("labels", Map.of("manual", "true"));
        selenoidOptions.put("enableVNC", true);  // Включение VNC для отладки
        selenoidOptions.put("enableVideo", false); // Видео можно включить при необходимости
        selenoidOptions.put("enableLog", true); // Логирование

        options.setCapability("selenoid:options", selenoidOptions);

        // Используем имя сервиса вместо localhost
        this.driver = new RemoteWebDriver(
                new URL("http://localhost:4445/wd/hub"), // Внутри Docker-сети
                options
        );

        // Настройка таймаутов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}