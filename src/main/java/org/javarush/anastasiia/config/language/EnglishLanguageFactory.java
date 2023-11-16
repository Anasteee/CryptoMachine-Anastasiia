package org.javarush.anastasiia.config.language;

import org.javarush.anastasiia.alphabet.Alphabet;
import org.javarush.anastasiia.alphabet.BasicAlphabet;
import org.javarush.anastasiia.language.BasicLanguage;
import org.javarush.anastasiia.language.Language;

import java.util.List;

public class EnglishLanguageFactory extends LanguageFactory {

    private static EnglishLanguageFactory instance;

    public static EnglishLanguageFactory getInstance() {
        if (instance == null){
            instance = new EnglishLanguageFactory();
        }
        return instance;
    }

    public Language getLanguage(){
        return new BasicLanguage(getAlphabet(), getCommonUsedWords());
    }

    private Alphabet getAlphabet() {
        return new BasicAlphabet(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    }

    private List<String> getCommonUsedWords(){
        return List.of("the", "be", "and", "of", "in", "to", "have");
    }




}
