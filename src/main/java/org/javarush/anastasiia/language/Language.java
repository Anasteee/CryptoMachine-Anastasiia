package org.javarush.anastasiia.language;

import org.javarush.anastasiia.alphabet.Alphabet;

import java.util.List;

public interface Language {

    Alphabet getAlphabet();
    List<String> getCommonUsedWords();
}
