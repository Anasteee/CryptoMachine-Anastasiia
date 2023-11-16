package org.javarush.anastasiia.cipher;

import org.javarush.anastasiia.LanguageNotFoundException;
import org.javarush.anastasiia.alphabet.Alphabet;
import org.javarush.anastasiia.language.Language;
import org.javarush.anastasiia.language.LanguageProcessor;
import org.javarush.anastasiia.language.Text;

import java.util.List;


public class CaesarCipher implements Cipher {


    private LanguageProcessor languageProcessor;

    private Alphabet rotatedAlphabet;


    public CaesarCipher(LanguageProcessor processor) {
        this.languageProcessor = processor;
    }

    public String encrypt(Text source, int key) {
        Language language = source.getLanguage();

        rotatedAlphabet = language.getAlphabet().getRotated(key);

        StringBuilder result = new StringBuilder();

        for (char character : source.getText().toCharArray()) {

            if (language.getAlphabet().containsIgnoreCase(character)) {
                result.append(processChar(character, language));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public String decrypt(Text source, int key) {
        return encrypt(source, key * -1);
    }

    private Character processChar(Character character, Language language){
        Character processedChar = rotatedAlphabet.get(language.getAlphabet().indexOfIgnoreCase(character));
        if(Character.isUpperCase(character)){
            processedChar = Character.toUpperCase(processedChar);
        }
        return processedChar;
    }



}


