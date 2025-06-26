package com.patterns.structural.Facade;

import lombok.extern.slf4j.Slf4j;

/**
 * Реализация паттерна Фасад для упрощенной работы с запуском и остановкой автомобиля
 * @author Владислав Степанов
 */
@Slf4j
public class CarFacade {

    private final Engine engine;
    private final FuelSystem fuelSystem;
    private final Starter starter;
    private final ClimateSystem climateSystem;

    public CarFacade() {
        engine = new Engine();
        fuelSystem = new FuelSystem();
        starter = new Starter();
        climateSystem = new ClimateSystem();
    }

    public void startCar() {
        log.info("Запуск автомобиля");
        starter.startRelay();
        fuelSystem.checkFuelLevel();
        fuelSystem.pumpFuel();
        engine.windCrankshaft();
        engine.movePistons();
        climateSystem.turnOnAirConditioning();
        engine.engineReady();
        log.info("Автомобиль запущен");
    }

    public void stopCar() {
        log.info("Остановка автомобиля");
        climateSystem.turnOffAirConditioning();
        engine.stopEngine();
    }

}
