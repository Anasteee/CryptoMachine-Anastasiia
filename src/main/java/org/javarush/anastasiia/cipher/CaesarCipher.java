package org.javarush.anastasiia.cipher;

import org.javarush.anastasiia.Action;
import org.javarush.anastasiia.FileService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class CaesarCipher implements Cipher {

    public static void encryption(String filePath, int key) throws IOException {
        BufferedReader reader = FileService.createFileReader(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.ready()) {
            for (char c :
                    reader.readLine().toCharArray()) {
                stringBuilder.append(encryptACharacter(c, key));
            }
            stringBuilder.append("\n");
        }
        reader.close();
        BufferedWriter writer = FileService.createFileWriter(filePath, Action.ENCRYPTED);
        writer.write(String.valueOf(stringBuilder));
        writer.close();
    }

    public static void decryption(String filePath, int key) throws IOException {
        BufferedReader reader = FileService.createFileReader(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.ready()) {
            for (char c :
                    reader.readLine().toCharArray()) {
                stringBuilder.append(decryptACharacter(c, key));
            }
            stringBuilder.append("\n");
        }
        reader.close();
        BufferedWriter writer = FileService.createFileWriter(filePath, Action.DECRYPTED);
        writer.write(String.valueOf(stringBuilder));
        writer.close();
    }

    private static char encryptACharacter(char c, int key) {
        char newCharacter = c;
        if (Character.isLetter(c)) {
            newCharacter += (char) key;
            if (!isSmallLetter(newCharacter) && !isBigLetter(newCharacter)) {
                if (isBigLetter(c)) {
                    newCharacter = (char) (newCharacter - 90 + 64);
                } else {
                    newCharacter = (char) (newCharacter - 122 + 96);
                }
            }
        }
        return newCharacter;
    }

    private static char decryptACharacter(char c, int key) {
        char newCharacter = c;
        if (Character.isLetter(c)) {
            newCharacter -= (char) key;
            if (!isSmallLetter(newCharacter) && !isBigLetter(newCharacter)) {
                if (isBigLetter(c)) {
                    newCharacter = (char) (91 - (65 - newCharacter));
                } else {
                    newCharacter = (char) (123 - (97 - newCharacter));
                }
            }
        }
        return newCharacter;
    }

    private static boolean isSmallLetter(char c) {
        return c >= 97 && c <= 122;
    }

    private static boolean isBigLetter(char c) {
        return c >= 65 && c <= 90;
    }
}
