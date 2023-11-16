package org.javarush.anastasiia;

import org.javarush.anastasiia.cipher.CaesarCipher;
import org.javarush.anastasiia.cipher.Cipher;
import org.javarush.anastasiia.config.Config;

import java.io.IOException;



public class Main {
    public static void main(String[] args) {


        Config config = new Config(args);

        config.getRunner().run(args);

    }
}