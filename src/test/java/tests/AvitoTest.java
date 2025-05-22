package tests;

import config.AvitoTestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.AvitoPage;

/**
 * Основной класс с тестами FormPage
 */
@Epic("Form Test")
public class AvitoTest extends BaseTest {

    /**
     * Экземпляр конфигурации с параметрами для Form тестов
     */
    private final AvitoTestConfig config = ConfigFactory.create(AvitoTestConfig.class, System.getenv());


    @Test(description = "Проверки отправки данных с заполненными полями формы")
    @Feature("Ввод данных в форму и отправка")
    public void testFormTest() {
        new AvitoPage(driver)
                .inputAvitoSearch(config.avitoInput())
                .printFirstUrlSpecifiedNumber(5);

        ;


        //new SuccessfulPage(driver)
        //        .checkHead()
        //        .checkTableElement();
    }
}
/*
.clickToCategory()    //нажимаем на выпадающий окно с категориями
                .clickToCategoryOrgtehnika()   //выбор категории
                .inputStringInSearchFieldItem(config.inputSearchItem())    //вводим Принтер
        .clickToAreaSearch()           //открытие поля поиска по городу
                .clickToDeepFieldAreaSearch()  //поле поиска по городам
                .inputStringInSearchFieldCity(config.inputSearchCity())   //вводим Владивосток
        .clickBigButtonForFoundedItems()     //нажимаем на кнопку поиска
                .clickCheckBox()     //чек-бокс только с фото
                .clickSelectorByAllPrices()    //Выпадающий список
                .clickExpensive()  //Выбираем Дороже
                .printFirstPriceByNumber(5); //Выводим первые 5 цен в консоль

 */

