package org.javarush.anastasiia;

public class LanguageNotFoundException extends RuntimeException {

    public LanguageNotFoundException(String message) {
        System.out.println(message);
    }
}
