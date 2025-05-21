import config.FormTestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.SuccessfulPage;

/**
 * Основной класс с тестами FormPage
 */
@Epic("Form Test")
public class FormTest extends BaseTest {

    /**
     * Экземпляр конфигурации с параметрами для Form тестов
     */
    private final FormTestConfig config = ConfigFactory.create(FormTestConfig.class, System.getenv());


    @Test(description = "Проверки отправки данных с заполненными полями формы")
    @Feature("Ввод данных в форму и отправка")
    public void testFormTest() {
        new FormPage(driver)
                .inputFirstName(config.firstName())
                .inputLastName(config.lastName())
                .inputUserEmail(config.userEmail())
                .clickToGender()
                .inputUserNumber(config.userNumber())
                .selectDateOfBirth()
                .inputSubjectsInput(config.subjectsInput())
                .clickToHobbiesWrapper()
                .uploadPicture()
                .inputCurrentAddress(config.currentAddress())
                .clickToSelectState()
                .clickToSelectCity()
                .clickToSubmit();


        new SuccessfulPage(driver)
                .checkHead()
                .checkTableElement();
    }
}

