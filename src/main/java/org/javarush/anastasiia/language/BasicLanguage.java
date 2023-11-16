package org.javarush.anastasiia.language;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.javarush.anastasiia.alphabet.Alphabet;

import java.util.List;

@AllArgsConstructor
@Getter
public class BasicLanguage implements Language {

    private Alphabet alphabet;
    private List<String> commonUsedWords;
}
