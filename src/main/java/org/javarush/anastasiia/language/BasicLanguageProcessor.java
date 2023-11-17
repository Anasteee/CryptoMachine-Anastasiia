package org.javarush.anastasiia.language;

import lombok.AllArgsConstructor;
import org.javarush.anastasiia.LanguageNotFoundException;

import java.util.List;

@AllArgsConstructor
public class BasicLanguageProcessor implements LanguageProcessor {
    List<Language> languages;


    @Override
    public Language determinateLanguage(String text) throws LanguageNotFoundException {

        int matches = 0;
        char c;


        if(text.isEmpty()){
            return languages.get(0);
        }

        for (Language language : languages) {
            for (int i = 0; i < Math.random()* text.length(); i++) {
                c = text.charAt((int) (Math.random()*text.length()));
                if(language.getAlphabet().containsIgnoreCase(c)){
                    matches++;
                }
                if(matches >= 5 || matches == text.length()){
                    return language;
                }
            }

        }
        return languages.get(0);
    }
}
