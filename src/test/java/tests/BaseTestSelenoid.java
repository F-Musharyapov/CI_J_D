package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTestSelenoid {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "116.0");

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("name", "Test badge...");
        selenoidOptions.put("sessionTimeout", "15m");
        selenoidOptions.put("env", List.of("TZ=UTC"));
        selenoidOptions.put("labels", Map.of("manual", "true"));
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("enableVNC", true);  // Добавьте это для отладки

        options.setCapability("selenoid:options", selenoidOptions);

        this.driver = new RemoteWebDriver(
                new URL("http://selenoid:4444/wd/hub"),
                options
        );

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