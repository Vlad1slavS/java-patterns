package com.patterns.behavioral.ChainOfResponsibility;

import java.util.Arrays;
import java.util.List;

/**
 * Обработчик для медведя
 */
public class Bear extends EatHandler {


    private final List<String> foodPreferences = Arrays.asList("мышь", "рыба", "олень");

    /**
     * Может съесть животное если оно входит в его рацион от природы
     * @param animal класс животного
     */
    @Override
    public void canEat(String animal) {
        if (foodPreferences.contains(animal)) {
            System.out.print("Медведь съел " + animal);
        } else if (nextEatHandler != null) {
            nextEatHandler.canEat(animal);
        } else {
            System.out.print("Никто не смог съесть " + animal);
        }
    }

}
