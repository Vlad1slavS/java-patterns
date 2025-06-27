package com.patterns.structural.Facade;

import lombok.extern.slf4j.Slf4j;

/**
 * Класс представляющий работу системы контроля климата
 */
@Slf4j
public class ClimateSystem {

    public void turnOnAirConditioning() {
        log.info("ClimateControl: Включение кондиционера");
    }

    public void turnOffAirConditioning() {
        log.info("ClimateControl: Выключение кондиционера");
    }

}
