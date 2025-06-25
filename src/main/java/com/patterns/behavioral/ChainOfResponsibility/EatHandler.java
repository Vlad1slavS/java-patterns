package com.patterns.behavioral.ChainOfResponsibility;

/**
 * Абстрактный обработчик для цепочки хищников
 * @author Владсилав Степанов
 */
public abstract class EatHandler {

    /**
     * Следующий обработчик в цепочке
     */
    protected EatHandler nextEatHandler;

    /**
     * Устанавливает следующий обработчик в цепочке
     * @param eatHandler следующий обработчик
     */
    public void setNextHandler(EatHandler eatHandler) {
        this.nextEatHandler = eatHandler;
    }

    /**
     * Обработка возможности съесть животное
     * @param animal класс животного
     */
    public abstract void canEat(String animal);

}
