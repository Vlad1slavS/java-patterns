package com.patterns.behavioral.Observer;

import java.util.Map;

/**
 * Интерфейс субъекта (издателя)
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Map<String, Double> weatherData);

}
