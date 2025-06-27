package com.patterns.behavioral.Observer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Метеостанция – издатель (тот кто уведомляет об изменениях в погоде)
 * @author Владислав Степанов
 */
@Slf4j
public class WeatherStation implements Subject {

    private List<Observer> observers;
    @Getter
    private Map<String, Double> weatherData;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        log.info("Добавлен наблюдатель: {}", observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        log.info("Удален наблюдатель: {}", observer);
    }

    @Override
    public void notifyObservers(Map<String, Double> weatherData) {
        log.info("Уведомление наблюдателей данными: {}", weatherData.toString());
        for (Observer observer : observers) {
            observer.update(weatherData);
        }
    }

    public void setWeatherData(Map<String, Double> weatherData) {
        this.weatherData = weatherData;
        notifyObservers(weatherData);
    }

}

