package com.patterns.structural;

import com.patterns.structural.Facade.*;
import org.junit.jupiter.api.Test;

public class FacadeTest {

    /**
     * Пример работы паттерна Фасад (запуск и остановка автомобиля)
     */
    @Test
    public void CarFacadeTest() {
        CarFacade carFacade = new CarFacade();
        carFacade.startCar();
        carFacade.stopCar();
    }

    /**
     * Пример работы паттерна Фасад (запуск и остановка автомобиля)
     */
    @Test
    public void TestWithoutFacade() {
        Engine engine = new Engine();
        Starter starter = new Starter();
        FuelSystem fuelSystem = new FuelSystem();
        ClimateSystem climateSystem = new ClimateSystem();

        // Приходилось бы делать так
        starter.startRelay();
        fuelSystem.checkFuelLevel();
        fuelSystem.pumpFuel();
        engine.windCrankshaft();
        engine.movePistons();
        climateSystem.turnOnAirConditioning();
        engine.engineReady();
    }

}
