package org.javarush.anastasiia.attack;

import org.javarush.anastasiia.cipher.Cipher;
import org.javarush.anastasiia.language.Text;

import java.util.*;

public class BruteForceAttack implements Attack{

    private final Cipher cipher;

    public BruteForceAttack(Cipher cipher) {
        this.cipher = cipher;
    }

    @Override
    public String execute(Text source){
        int key = findKey(source);
        return cipher.decrypt(source, key);
    }

    private int findKey(Text source){
        int maxMatches = 0;
        int matches;
        int foundKey = -1;
        List<String> words;

        for (int key = 1; key < source.getLanguage().getAlphabet().size(); key++) {
            matches = 0;
            String s = cipher.decrypt(source, key);

            words = List.of(s.toLowerCase().split("\\P{L}+"));
            for (String mostUsedWord : source.getLanguage().getCommonUsedWords()) {
                if (words.contains(mostUsedWord)) {
                    matches++;
                }
            }
            if(matches > maxMatches){
                maxMatches = matches;
                foundKey = key;
            }
        }
        return foundKey;
    }

}

