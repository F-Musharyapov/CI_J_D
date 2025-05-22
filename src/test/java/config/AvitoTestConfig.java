package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов AvitoPage
 */
@Config.Sources({"classpath:avito_test_config.properties"})
public interface AvitoTestConfig extends Config {

    /**
     * Методы для возврата параметра из avito_test_config.properties
     *
     * @return параметр поля ввода First Name
     */
    String avitoInput();
    String linkAttribute();

}
