package pages;

import config.FormTestConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс в котором происходит взаимодействие со странницей
 */
public class FormPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Экземпляр конфигурации с параметрами для тестов на странице
     */
    private final FormTestConfig config = ConfigFactory.create(FormTestConfig.class, System.getenv());

    @FindBy(xpath = "//*[@id=\"bx_search\"]/div[2]/div/div/label/div/div/div/input")
    private WebElement avitoSearch;

    @FindBy(css = "button[data-marker='search-form/submit-button']")
    private WebElement avitoButton;


    /**
     * Конструктор создания FormPage
     *
     * @param driver драйвер для управления браузером
     */
    public FormPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод ввода текста в поле First Name
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода First Name")
    public FormPage inputAvitoSearch(String input) {
        waitUntilVisible(driver, avitoSearch);
        avitoSearch.sendKeys(input);
        //makeScreenShot(driver);
        return this;
    }

    /**
     * Метод клика по кнопке Submit
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке Submit")
    public FormPage clickToAvitoButton() {
        avitoButton.click();
        //makeScreenShot(driver);
        return this;
    }
}