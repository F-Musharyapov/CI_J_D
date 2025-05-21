package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.ScreenHelper.makeScreenShot;

/**
 * Класс в котором происходит проверка отправленных данных в форме
 */
public class SuccessfulPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private WebDriver driver;

    /**
     * Экземпляр списка для хранения ожидаемых значений для проверки
     */
    private Map<String, String> expectedMap;

    /**
     * Элемент заголовка окна успеха
     */
    private By headLocator = By.id("example-modal-sizes-title-lg");

    /**
     * Элемент первой строки в окне успеха
     */
    private By tableRowsLocator = By.xpath("//table/tbody/tr");

    /**
     * Конструктор создания SuccessfulPage
     *
     * @param driver драйвер для управления браузером
     */
    public SuccessfulPage(WebDriver driver) {
        this.driver = driver;
        createExpectedMap();
    }

    /**
     * Метод создания интерфейса с данными ожидаемыми полями и данными
     *
     */
    @Step("Создание интерфейса с данными ожидаемыми полями и данными")
    private void createExpectedMap() {
        expectedMap = new HashMap<>();
        expectedMap.put("Student Name", "FirstTEST LastTEST");
        expectedMap.put("Student Email", "email@test.com");
        expectedMap.put("Gender", "Other");
        expectedMap.put("Mobile", "9020012233");
        expectedMap.put("Date of Birth", "13 October,1991");
        expectedMap.put("Subjects", "English");
        expectedMap.put("Hobbies", "Sports");
        expectedMap.put("Picture", "sample_clouds.jpg");
        expectedMap.put("Address", "55 Lenin Street, Ulyanovsk");
        expectedMap.put("State and City", "NCR Delhi");
    }

    /**
     * Метод проверки заголовка окна успеха
     */
    @Step("Проверка заголовка окна успеха")
    public SuccessfulPage checkHead() {
        WebElement head = driver.findElement(headLocator);
        Assert.assertEquals(head.getText(), "Thanks for submitting the form", "Заголовок не совпадает");
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод проверки элементов таблицы
     */
    @Step("Проверка элементов таблицы")
    public void checkTableElement() {
        List<WebElement> rows = driver.findElements(tableRowsLocator);
        Map<String, String> actualTable = new HashMap<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String label = cells.get(0).getText();
            String value = cells.get(1).getText();
            actualTable.put(label, value);
        }

        for (Map.Entry<String, String> entry : expectedMap.entrySet()) {
            Assert.assertEquals(actualTable.get(entry.getKey()), entry.getValue(), entry.getKey() + " не совпадает");
        }
        makeScreenShot(driver);
    }
}
