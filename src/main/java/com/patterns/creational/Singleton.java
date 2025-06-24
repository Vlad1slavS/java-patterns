package com.patterns.creational;

/**
 * Реализация паттерна Singleton
 * Класс может иметь только один экземпляр
 * @author Владислав Степанов
 */
public final class Singleton {

    /**
     * Единый экземпляр класса
     */
    private static Singleton instance;

    /**
     * Закрытый конструктор для предотвращения создания экземпляра
     */
    private Singleton() {}

    /**
     * Метод для получения экземпляра Singleton
     * @return Singleton
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
