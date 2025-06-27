package com.patterns.behavioral.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Главный класс предложения состоящий из подлежащего, сказуемого и доп частей
 * @author Владислав Степанов
 */
public class Sentence implements Iterable<String> {

    private Subject subject;
    private Predicate predicate;
    private List<Attribute> attributes;

    public Sentence() {
        this.attributes = new ArrayList<>();
    }

    public Sentence(Subject subject, Predicate predicate) {
        this();
        this.subject = subject;
        this.predicate = predicate;
    }

    public void addAttribute(String word) {
        attributes.add(new Attribute(word));
    }

    public Subject getSubject() {
        return subject;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Iterator<String> iterator() {
        return new SentenceIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String word : this) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(word);
        }

        return sb.toString();
    }

}
