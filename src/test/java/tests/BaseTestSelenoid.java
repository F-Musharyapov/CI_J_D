package tests;

import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
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
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "127.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", false);

            put("enableVNC", true);

        }});


        //selenoidOptions.put("name", "Test badge...");
        //selenoidOptions.put("sessionTimeout", "15m");
        //selenoidOptions.put("env", List.of("TZ=UTC"));
        //selenoidOptions.put("labels", Map.of("manual", "true"));
        //selenoidOptions.put("enableVideo", false);
        //selenoidOptions.put("enableVNC", true);  // Добавьте это для отладки

        //options.setCapability("selenoid:options", selenoidOptions);

        //RemoteWebDriver driver = new RemoteWebDriver(
        this.driver = new RemoteWebDriver(
                new URL("http://172.17.0.2:4444/wd/hub"),
                options
        );
        driver.get(config.url());
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