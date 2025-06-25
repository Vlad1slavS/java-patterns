package com.patterns.structural.ProxyTest;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.patterns.structural.Proxy.DatabaseService;
import com.patterns.structural.Proxy.ProxyDatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для демонстрации логики паттерна прокси
 */
public class ProxyDatabaseServiceTest {

    private ProxyDatabaseService proxyDatabaseService;
    private ListAppender<ILoggingEvent> listAppender;

    @BeforeEach
    void setUp(){
        proxyDatabaseService = new ProxyDatabaseService();

        Logger proxyLogger = (Logger) LoggerFactory.getLogger(ProxyDatabaseService.class);
        Logger dbLogger = (Logger) LoggerFactory.getLogger(DatabaseService.class);

        listAppender = new ListAppender<>();
        listAppender.start();

        proxyLogger.addAppender(listAppender);
        dbLogger.addAppender(listAppender);
    }

    /**
     * Базовый тест логики прокси
     * @throws InterruptedException
     */
    @Test
    public void testBasicProxyFunctionality() throws InterruptedException {
        String data = "Hello World!";
        listAppender.list.clear();

        proxyDatabaseService.saveToDatabase(data);

        List<ILoggingEvent> logEvents = listAppender.list;

        assertEquals("Тут может быть дополнительная логика перед сохранением", logEvents.get(0).getFormattedMessage());

        assertEquals("Сохранение в БД данных: " + data, logEvents.get(1).getFormattedMessage());

        assertTrue(logEvents.size() >= 2);
    }

    /**
     * Тест сохранения null данных
     */
    @Test
    public void testNullData() throws InterruptedException {
        listAppender.list.clear();

        proxyDatabaseService.saveToDatabase(null);

        List<ILoggingEvent> logEvents = listAppender.list;

        assertEquals("Не удалось сохранить null данные в БД", logEvents.get(1).getFormattedMessage());
    }

}
