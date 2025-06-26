package com.patterns.structural.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Базовый класс, реализующие сохранение неких строковых данных в БД
 * @author Владислав Степанов
 */
public class DatabaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseService.class);

    public void saveToDatabase(String data) throws InterruptedException, RuntimeException {
        if (data == null) {
            LOGGER.warn("Не удалось сохранить null данные в БД");
            throw new RuntimeException("Не удалось сохранить null данные в БД");
        }
        LOGGER.info("Сохранение в БД данных: {}", data);
        Thread.sleep(1000);
    }

}
