package com.patterns.structural.Facade;

import lombok.extern.slf4j.Slf4j;

/**
 * Класс представляющий работу топливной системы
 */
@Slf4j
public class FuelSystem {

    public void checkFuelLevel() {
        log.info("FuelSystem: Проверка уровня топлива");
    }

    public void pumpFuel() {
        log.info("FuelSystem: Подача топлива в двигатель");
    }

}
