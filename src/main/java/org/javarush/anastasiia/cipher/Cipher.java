package org.javarush.anastasiia.cipher;

import org.javarush.anastasiia.alphabet.Alphabet;
import org.javarush.anastasiia.language.Text;

import java.util.List;

public interface Cipher {

    String encrypt(Text source, int key);

    String decrypt(Text source, int key);

}
