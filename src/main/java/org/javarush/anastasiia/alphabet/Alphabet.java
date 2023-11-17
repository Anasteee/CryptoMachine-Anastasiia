package org.javarush.anastasiia.alphabet;

import java.util.List;

public interface Alphabet {

    List<Character> getAlphabet();

    Alphabet getRotated(int key);

    Character get(int index);

    int indexOfIgnoreCase(Character character);

    boolean containsIgnoreCase(Character character);

    int size();
}
