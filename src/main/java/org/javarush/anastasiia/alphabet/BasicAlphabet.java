package org.javarush.anastasiia.alphabet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicAlphabet implements Alphabet {
    private final List<Character> alphabet;

    public BasicAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public List<Character> getAlphabet() {
        return alphabet;
    }
    @Override
    public Alphabet getRotated(int key){
        List<Character> rotatedAlphabet = new ArrayList<>(alphabet);
        Collections.rotate(rotatedAlphabet, key * -1);

        return new BasicAlphabet(rotatedAlphabet);
    }

    @Override
    public Character get(int index) {
        return alphabet.get(index);
    }

    @Override
    public int indexOfIgnoreCase(Character character) {
        return alphabet.indexOf(toLowerCase(character));
    }

    @Override
    public boolean containsIgnoreCase(Character character) {
        return alphabet.contains(toLowerCase(character));
    }

    @Override
    public int size() {
        return alphabet.size();
    }

    private Character toLowerCase(Character character){
        return Character.toLowerCase(character);
    }



}
