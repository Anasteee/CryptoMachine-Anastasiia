package org.javarush.anastasiia.language;

import org.javarush.anastasiia.LanguageNotFoundException;

public interface LanguageProcessor {
    public Language determinateLanguage(String text) throws LanguageNotFoundException;
}
