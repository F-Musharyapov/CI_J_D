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
 * Класс в котором происходит взаимодействие со странницей с формой
 */
public class FormPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Экземпляр конфигурации с параметрами для тестов формы на странице
     */
    private final FormTestConfig config = ConfigFactory.create(FormTestConfig.class, System.getenv());

    /**
     * Элемент с полем ввода First Name
     */
    @FindBy(css = "input[id='firstName']")
    private WebElement firstName;

    /**
     * Элемент с полем ввода Last Name
     */
    @FindBy(css = "input[id='lastName']")
    private WebElement lastName;

    /**
     * Элемент с полем ввода User Name
     */
    @FindBy(css = "input[id='userEmail']")
    private WebElement userEmail;

    /**
     * Элемент чекбокс с одиночным выбором Gender
     */
    @FindBy(css = "label[for='gender-radio-3']")
    private WebElement gender;

    /**
     * Элемент с полем ввода User Number
     */
    @FindBy(css = "input[id='userNumber']")
    private WebElement userNumber;

    /**
     * Элемент вызова календаря для выбора даты
     */
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;

    /**
     * Элемент вызова списка месяцев в календаре
     */
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")
    private WebElement month;

    /**
     * Выбор месяца из списка месяцев
     */
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[10]")
    private WebElement monthOctober;

    /**
     * Элемент вызова списка годов в календаре
     */
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
    private WebElement year;

    /**
     * Выбор года из списка годов
     */
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[92]")
    private WebElement year1991;

    /**
     * Выбора числа месяца в календаре
     */
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]")
    private WebElement day13;

    /**
     * Элемент с полем ввода Subjects
     */
    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    /**
     * Выбор из выподающего списка в полем Subjects
     */
    @FindBy(id = "react-select-2-option-0")
    private WebElement subjectsSelect;

    /**
     * Элемент чекбокс с множественным выбором Hobbies Wrapper
     */
    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    private WebElement hobbiesWrapper;

    /**
     * Элемент с кнопкой загрузки изображения Picture
     */
    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    /**
     * Элемент с полем ввода Current Address
     */
    @FindBy(css = "textarea[id='currentAddress']")
    private WebElement currentAddress;

    /**
     * Элемент с выпадающим списком State
     */
    @FindBy(id = "state")
    private WebElement selectState;

    /**
     * Выбор пункта из выпадающего списка State
     */
    @FindBy(id = "react-select-3-option-0")
    private WebElement selectStateNCR;

    /**
     * Элемент с выпадающим списком City
     */
    @FindBy(id = "city")
    private WebElement selectCity;

    /**
     * Выбор пункта из выпадающего списка City
     */
    @FindBy(id = "react-select-4-option-0")
    private WebElement selectCityDelhi;

    /**
     * Элемент кнопка отправки заявки Submit
     */
    @FindBy(id = "submit")
    private WebElement submitButton;

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
    public FormPage inputFirstName(String input) {
        firstName.sendKeys(input);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле Last Name
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Last Name")
    public FormPage inputLastName(String input) {
        lastName.sendKeys(input);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле User Email
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода User Email")
    public FormPage inputUserEmail(String input) {
        userEmail.sendKeys(input);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбора элемента в чекбоксе Gender
     *
     * @return текущая страница
     */
    @Step("Выбор элемента в чекбоксе Gender")
    public FormPage clickToGender() {
        gender.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле User Number
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода User Number")
    public FormPage inputUserNumber(String input) {
        userNumber.sendKeys(input);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбора даты в календаре
     *
     * @return текущая страница
     */
    @Step("Выбор даты в календаре")
    public FormPage selectDateOfBirth() {
        dateOfBirth.click();
        month.click();
        monthOctober.click();
        year.click();
        year1991.click();
        day13.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле Subjects и выбора пункта из выпадающего списка
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод текста в поле Subjects и выбора пункта из выпадающего списка")
    public FormPage inputSubjectsInput(String input) {
        subjectsInput.sendKeys(input);
        subjectsSelect.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбора в чекбоксе Hobbies
     *
     * @return текущая страница
     */
    @Step("Выбор в чекбоксе Hobbies")
    public FormPage clickToHobbiesWrapper() {
        hobbiesWrapper.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод загрузки изображения в поле Picture
     *
     * @return текущая страница
     */
    @Step("Загрузка изображения в поле Picture")
    public FormPage uploadPicture() {
        uploadPicture.sendKeys(new File(config.testPicture()).getAbsolutePath());
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле Current Address
     *
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода Current Address")
    public FormPage inputCurrentAddress(String input) {
        currentAddress.sendKeys(input);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод клика в поле State и выбора пункта из выпадающего списка
     *
     * @return текущая страница
     */
    @Step("Клик в поле State и выбора пункта из выпадающего списка")
    public FormPage clickToSelectState() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectState);
        selectState.click();
        waitUntilVisible(driver, selectStateNCR);
        selectStateNCR.click();
        makeScreenShot(driver);
        return this;

    }

    /**
     * Метод клика в поле City и выбора пункта из выпадающего списка
     *
     * @return текущая страница
     */
    @Step("Клик в поле City и выбора пункта из выпадающего списка")
    public FormPage clickToSelectCity() {
        selectCity.click();
        waitUntilVisible(driver, selectCityDelhi);
        selectCityDelhi.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод клика по кнопке Submit
     *
     * @return текущая страница
     */
   @Step("Клик по кнопке Submit")
    public FormPage clickToSubmit() {
        submitButton.click();
        makeScreenShot(driver);
        return this;
    }
}