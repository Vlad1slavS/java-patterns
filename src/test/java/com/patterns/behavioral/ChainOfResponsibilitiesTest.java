package com.patterns.behavioral;

import com.patterns.behavioral.ChainOfResponsibility.Bear;
import com.patterns.behavioral.ChainOfResponsibility.EatHandler;
import com.patterns.behavioral.ChainOfResponsibility.Lion;
import com.patterns.behavioral.ChainOfResponsibility.Wolf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ChainOfResponsibilitiesTest {

    private EatHandler wolf;
    private ByteArrayOutputStream outputStream;

    /**
     * Создаем и связываем обработчики в цепочку
     * А также перенаправляем вывод в ByteArrayOutputStream (для тестирования вывода в консоль)
     */
    @BeforeEach
    void setUp() {
        wolf = new Wolf();
        EatHandler bear = new Bear();
        EatHandler lion = new Lion();

        wolf.setNextHandler(bear);
        bear.setNextHandler(lion);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void wolfEatsRabbitTest() {
        wolf.canEat("заяц");
        String output = outputStream.toString();
        assertEquals("Волк съел заяц", output);
    }

    @Test
    public void bearEatsDeerTest() {
        wolf.canEat("олень");
        String output = outputStream.toString();
        assertEquals("Медведь съел олень", output);
    }

    @Test
    public void lionEatsAntelopeTest() {
        wolf.canEat("антилопа");
        String output = outputStream.toString();
        assertEquals("Лев съел антилопа", output);
    }

    @Test
    public void nobodyEatsButterflyTest() {
        wolf.canEat("бабочка");
        String output = outputStream.toString();
        assertEquals("Никто не смог съесть бабочка", output);
    }

    @Test
    public void nullAnimalTest(){
        wolf.canEat(null);
        String output = outputStream.toString();
        assertEquals("Никто не смог съесть null", output);
    }

    @Test
    public void arraysAnimalsTest(){
        String[] testingAnimals = {"заяц", "рыба", "антилопа", "мышь", "гусеница"};

        for (String animal : testingAnimals) {
            wolf.canEat(animal);
        }
        String output = outputStream.toString();
        assertTrue(output.contains("Волк съел заяц"));
        assertTrue(output.contains("Медведь съел рыба"));
        assertTrue(output.contains("Лев съел антилопа"));
        assertTrue(output.contains("Медведь съел мышь"));
        assertTrue(output.contains("Никто не смог съесть гусеница"));
    }

}
