package com.patterns.structural.Facade;

import lombok.extern.slf4j.Slf4j;

/**
 * Класс представляющий работу двигателя
 */
@Slf4j
public class Engine {

    public void windCrankshaft() {
        log.info("Engine: Раскручивание коленчатого вала на 200-300 об/мин");
    }

    public void movePistons() {
        log.info("Engine: Старт движения поршней");
    }

    public void engineReady() {
        log.info("Engine: Двигатель готов");
    }

    public void stopEngine() {
        log.info("Engine: Процесс остановки двигателя");
    }

}
