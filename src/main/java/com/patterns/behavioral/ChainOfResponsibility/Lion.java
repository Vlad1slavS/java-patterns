package com.patterns.behavioral.ChainOfResponsibility;

import java.util.Arrays;
import java.util.List;

/**
 * Обработчик для льва
 */
public class Lion extends EatHandler {

    private final List<String> foodPreferences = Arrays.asList("антилопа", "зебра", "буйвол");

    @Override
    public void canEat(String animal) {
        if (foodPreferences.contains(animal)) {
            System.out.print("Лев съел " + animal);
        } else {
            if (nextEatHandler != null) {
                nextEatHandler.canEat(animal);
            } else {
                System.out.print("Никто не смог съесть " + animal);
            }
        }
    }

}
