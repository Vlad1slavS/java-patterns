package com.patterns.behavioral.ChainOfResponsibility;

import java.util.Arrays;
import java.util.List;

/**
 * Обработчик для волка
 */
public class Wolf extends EatHandler {

    private final List<String> foodPreferences = Arrays.asList("заяц", "дикая коза", "лисица");

    @Override
    public void canEat(String animal) {
        if (foodPreferences.contains(animal)) {
            System.out.print("Волк съел " + animal);
        } else if (nextEatHandler != null) {
            nextEatHandler.canEat(animal);
        } else {
            System.out.print("Никто не смог съесть " + animal);
        }
    }

}
