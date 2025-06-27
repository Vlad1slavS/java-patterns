package com.patterns.behavioral;

import com.patterns.behavioral.Observer.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Slf4j
public class ObserverTest {

    /**
     * Демонстрация работы паттерна наблюдатель (с добавлением и удаление наблюдателей)
     */
    @Test
    public void observerTest() {

        WeatherStation weatherStation = new WeatherStation();
        MobileApp weatherApp = new MobileApp();
        TVService tvService = new TVService();

        log.info("Добавление наблюдателя");
        weatherStation.addObserver(weatherApp);
        weatherStation.addObserver(tvService);

        log.info("Уведомление наблюдателей");
        weatherStation.setWeatherData(Map.of("Moscow", 25.0));

        log.info("Удаление наблюдателя");
        weatherStation.removeObserver(weatherApp);

        weatherStation.setWeatherData(Map.of("Moscow", 45.0));
    }

}

