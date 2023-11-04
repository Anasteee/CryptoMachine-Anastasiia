package org.javarush.anastasiia.alphabet;

import java.util.List;

public class BasicAlphabet implements Alphabet {
    private final List<Character> alphabet;

    public BasicAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

}
