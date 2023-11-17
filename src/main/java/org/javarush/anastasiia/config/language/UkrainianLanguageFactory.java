package org.javarush.anastasiia.config.language;

import org.javarush.anastasiia.alphabet.Alphabet;
import org.javarush.anastasiia.alphabet.BasicAlphabet;
import org.javarush.anastasiia.language.BasicLanguage;
import org.javarush.anastasiia.language.Language;

import java.util.List;

public class UkrainianLanguageFactory extends LanguageFactory {

    private static UkrainianLanguageFactory instance;

    public static UkrainianLanguageFactory getInstance() {
        if (instance == null){
            instance = new UkrainianLanguageFactory();
        }
        return instance;
    }

    public Language getLanguage(){
        return new BasicLanguage(getAlphabet(), getCommonUsedWords());
    }

    private Alphabet getAlphabet() {
        return new BasicAlphabet(List.of('а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з',
                'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ь', 'ю', 'я'));
    }

    private List<String> getCommonUsedWords(){
        return List.of("та", "що", "мій", "твій", "свій", "наш", "ваш", "його", "її", "їх",
                "їхній", "бо", "чи", "щоб", "як", "хоч", "але", "не", "від", "до", "над");
    }




}
