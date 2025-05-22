package pages;

import config.AvitoTestConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс в котором происходит взаимодействие со странницей
 */
public class AvitoPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Экземпляр конфигурации с параметрами для тестов на странице
     */
    private final AvitoTestConfig config = ConfigFactory.create(AvitoTestConfig.class, System.getenv());

    /**
     * Элемент с полем поиска на главной странице
     */
    @FindBy(xpath = "//*[@id=\"bx_search\"]/div[2]/div/div/label/div/div/div/input1")
    private WebElement avitoSearch;


    /**
     * Конструктор создания FormPage
     *
     * @param driver драйвер для управления браузером
     */
    public AvitoPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод ввода текста в поле поиска
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода")
    public AvitoPage inputAvitoSearch(String input) {
        waitUntilVisible(driver, avitoSearch);
        avitoSearch.sendKeys(input);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод печати первых n ссылок элементов
     *
     * @param count количество ссылок
     */
    @Step("Печать в консоль ссылки первых результатов запроса")
    public void printFirstUrlSpecifiedNumber(int count){
        for (int i = 1; i <= count; i++){
            System.out.println(getSearchResultElementByNumber(i).getAttribute(config.linkAttribute()));
        }
    }

    /**
     * Метод получения элемента по номеру
     *
     * @param elementNumber номер элемента
     * @return элемент результата поиска
     */
    private WebElement getSearchResultElementByNumber(int elementNumber){
        return driver.findElement(By.xpath("//div[@id='bx_serp-item-list']//div[" + elementNumber + "]//div//div//div//a"));
    }
}
