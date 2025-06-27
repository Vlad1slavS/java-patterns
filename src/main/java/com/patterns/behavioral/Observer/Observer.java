package com.patterns.behavioral.Observer;

import java.util.Map;

/**
 * Интерфейс наблюдателя
 */
public interface Observer {

    void update(Map<String, Double> weatherData);

}
