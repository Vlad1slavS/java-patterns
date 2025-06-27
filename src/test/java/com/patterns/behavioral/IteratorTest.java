package com.patterns.behavioral;

import com.patterns.behavioral.Iterator.Predicate;
import com.patterns.behavioral.Iterator.Sentence;
import com.patterns.behavioral.Iterator.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IteratorTest {

    private Sentence sentence1;
    private Sentence sentence2;

    @BeforeEach
    void setUp() {
        Subject subject1 = new Subject("Кот");
        Predicate predicate1 = new Predicate("спит");
        sentence1 = new Sentence(subject1, predicate1);
        sentence1.addAttribute("дома");

        Subject subject2 = new Subject("Собака");
        Predicate predicate2 = new Predicate("играет", "с мячом");
        sentence2 = new Sentence(subject2, predicate2);
    }

    /**
     * Проверка на null предложения после создания
     */
    @Test
    void testSentenceCreation() {
        assertNotNull(sentence1);
        assertNotNull(sentence2);
    }

    /**
     * Тест на соответствие предложений
     */
    @Test
    void testSentenceToString() {
        String expected1 = "Кот спит дома";
        String expected2 = "Собака играет с мячом";

        assertEquals(expected1, sentence1.toString());
        assertEquals(expected2, sentence2.toString());
    }

    /**
     * Проверка итератора через for each цикл
     */
    @Test
    void testIteratorFunctionality() {
        List<String> words1 = new ArrayList<>();
        for (String word : sentence1) {
            words1.add(word);
        }

        assertEquals(3, words1.size());
        assertEquals("Кот", words1.get(0));
        assertEquals("спит", words1.get(1));
        assertEquals("дома", words1.get(2));

        List<String> words2 = new ArrayList<>();
        for (String s : sentence2) {
            words2.add(s);
        }

        assertEquals(3, words2.size());
        assertTrue(words2.contains("Собака"));
        assertTrue(words2.contains("играет"));
        assertTrue(words2.contains("с мячом"));
    }

    /**
     * Проверка итератора напрямую
     */
    @Test
    void testIteratorDirectUsage() {
        Iterator<String> iter1 = sentence1.iterator();
        assertTrue(iter1.hasNext());

        String firstWord = iter1.next();
        assertNotNull(firstWord);

        int count = 1;
        while (iter1.hasNext()) {
            String word = iter1.next();
            assertNotNull(word);
            count++;
        }
        assertEquals(3, count);

        assertFalse(iter1.hasNext());
    }

}
