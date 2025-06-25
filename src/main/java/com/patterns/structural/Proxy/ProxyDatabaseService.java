package com.patterns.structural.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Прокси сервис, который добавляет сквозную логику к DatabaseService
 */
public class ProxyDatabaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyDatabaseService.class);
    private final DatabaseService databaseService;

    public ProxyDatabaseService() {
        databaseService = new DatabaseService();
    }

    public void saveToDatabase(String data) throws InterruptedException {

        LOGGER.info("Тут может быть дополнительная логика перед сохранением");

        try {
            databaseService.saveToDatabase(data);
        } catch (InterruptedException | RuntimeException e) {
            LOGGER.warn("Ошибка сохранения:{}", e.getMessage());
        }
    }

}
