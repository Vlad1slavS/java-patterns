package com.patterns.behavioral.Iterator;

/**
 * Класс сказуемого (verb - сам глагол, object - объект (может быть null))
 */
public class Predicate {

    private final String verb;
    private final String object;

    public Predicate(String verb) {
        this.verb = verb;
        this.object = null;
    }

    public Predicate(String verb, String object) {
        this.verb = verb;
        this.object = object;
    }

    public String getVerb() {
        return verb;
    }

    public String getObject() {
        return object;
    }

}
