package com.patterns.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса Singleton
 * @author Владислав Степанов
 */
public class SingletonTest {

    /**
     * Проверка на null экземпляр
     */
    @Test
    public void testGetInstance_ShouldReturnNotNull() {
        Singleton instance = Singleton.getInstance();
        assertNotNull(instance);
    }

    /**
     * Проверка равенства ссылок двух экземпляров
     */
    @Test
    public void testGetInstance_ShouldReturnSameInstance(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        assertTrue(instance1 == instance2);
    }

    /**
     * Проверка равенства hashCode двух экземпляров
     */
    @Test
    public void testGetInstance_HashCodeEquality() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Проверка равенства экземпляров по equals
     */
    @Test
    void testGetInstance_EqualsInstance() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        assertEquals(instance1, instance2);
    }

}
