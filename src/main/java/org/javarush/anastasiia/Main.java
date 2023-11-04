package org.javarush.anastasiia;

import org.javarush.anastasiia.cipher.CaesarCipher;

import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException, WrongCommandException {
        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        issueCommand(command, filePath, key);

    }

    public static void issueCommand(String command, String filePath, int key) throws IOException, WrongCommandException {
        switch (command) {
            case "ENCRYPT" -> CaesarCipher.encryption(filePath, key);
            case "DECRYPT" -> CaesarCipher.decryption(filePath, key);
            case "BRUTE_FORCE" -> CaesarCipher.decryption("src/textSoure.txt", 2);
            default -> throw new WrongCommandException("Unidentified command has been issued");
        }
    }
}