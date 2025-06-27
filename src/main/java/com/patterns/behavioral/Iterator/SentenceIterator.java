package com.patterns.behavioral.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Класс итератора для предложения
 */
public class SentenceIterator implements Iterator<String> {

    private List<String> words;
    private int currentIndex;

    public SentenceIterator(Sentence sentence) {
        this.words = new ArrayList<>();
        this.currentIndex = 0;

        collectWords(sentence);
    }

    /**
     * Собирает слова из предложения
     * @param sentence предложение
     */
    private void collectWords(Sentence sentence) {
        if (sentence.getSubject() != null) {
            words.add(sentence.getSubject().getNoun());
        }

        if (sentence.getPredicate() != null) {
            words.add(sentence.getPredicate().getVerb());
            if (sentence.getPredicate().getObject() != null) {
                words.add(sentence.getPredicate().getObject());
            }
        }

        for (Attribute attr : sentence.getAttributes()) {
            words.add(attr.getWord());
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex < words.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Больше нет слов в предложении");
        }
        return words.get(currentIndex++);
    }

}
