package com.patterns.behavioral.Observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Конкретный наблюдатель - телевидение (например, для изменений погоды на экране в режиме реального времени)
 */
@Slf4j
public class TVService implements Observer {

    private Map<String, Double> weatherData;

    @Override
    public void update(Map<String, Double> weatherData) {
        this.weatherData = weatherData;
        log.info("Телевидение получило обновление погоды: {}", weatherData.toString());
    }

}

