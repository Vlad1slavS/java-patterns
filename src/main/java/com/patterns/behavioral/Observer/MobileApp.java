package com.patterns.behavioral.Observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Конкретный наблюдатель - мобильное приложение
 */
@Slf4j
public class MobileApp implements Observer {

    /**
     * Сохранение полученных данных для дальнейшего использования (например, отправка нотификации)
     */
    private Map<String, Double> weatherData;

    @Override
    public void update(Map<String, Double> weatherData) {
        this.weatherData = weatherData;
        log.info("Мобильное приложение получило обновление погоды: {}", weatherData.toString());
    }

}

