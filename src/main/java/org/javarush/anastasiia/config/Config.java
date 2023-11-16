package org.javarush.anastasiia.config;

import lombok.Getter;
import org.javarush.anastasiia.attack.Attack;
import org.javarush.anastasiia.attack.BruteForceAttack;
import org.javarush.anastasiia.config.language.EnglishLanguageFactory;
import org.javarush.anastasiia.config.language.UkrainianLanguageFactory;
import org.javarush.anastasiia.language.BasicLanguageProcessor;
import org.javarush.anastasiia.language.Language;
import org.javarush.anastasiia.language.LanguageProcessor;
import org.javarush.anastasiia.runner.Runner;
import org.javarush.anastasiia.cipher.CaesarCipher;
import org.javarush.anastasiia.cipher.Cipher;
import org.javarush.anastasiia.io.FileService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Config {

    private Cipher cipher;
    private FileService fileService;
    private Attack attack;
    private Runner runner;
    private LanguageProcessor languageProcessor;
    private final List<Language> languages = new ArrayList<>();

    public Config(String[] args) {
        init(args);
    }

    private void init(String[] args) {
        languages.add(EnglishLanguageFactory.getInstance().getLanguage());
        languages.add(UkrainianLanguageFactory.getInstance().getLanguage());

        languageProcessor = new BasicLanguageProcessor(languages);
        cipher = createCipher(languageProcessor);

        fileService = createFileService();
        attack = createAttack();
        runner = createRunner(cipher, fileService, attack);
    }


    public Attack createAttack() {
        return new BruteForceAttack(cipher);
    }





    public Cipher createCipher(LanguageProcessor processor) {
        return new CaesarCipher(processor);
    }

    public Runner createRunner(Cipher cipher, FileService fileService, Attack attack) {
        return new Runner(cipher, fileService, attack, languageProcessor);
    }

    public FileService createFileService() {
        return new FileService();
    }
}
