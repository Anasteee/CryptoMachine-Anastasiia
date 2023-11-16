package org.javarush.anastasiia.runner;

import lombok.RequiredArgsConstructor;
import org.javarush.anastasiia.attack.Attack;
import org.javarush.anastasiia.cipher.Cipher;
import org.javarush.anastasiia.command.Command;
import org.javarush.anastasiia.command.CommandType;
import org.javarush.anastasiia.io.FileService;
import org.javarush.anastasiia.language.LanguageProcessor;
import org.javarush.anastasiia.language.Text;

import java.io.IOException;
import java.nio.file.Path;
@RequiredArgsConstructor
public class Runner {

    private final Cipher cipher;
    private final FileService fileService;
    private final Attack attack;
    private final LanguageProcessor languageProcessor;


    public void run(String[] args) {
        Command command = createCommand(args);

        switch (command.getType()) {
            case ENCRYPT:
                runEncrypt(command);
                break;
            case DECRYPT:
                runDecrypt(command);
                break;
            case BRUTE_FORCE:
                runBruteForce(command);
                break;
        }
    }

    private Command createCommand(String[] args) {
        String commandName = args[0];
        Path filePath = Path.of(args[1]);
        int key = Integer.parseInt(args[2]);
        if(key < 0){
            key = key * -1;
        }

        return new Command(CommandType.valueOf(commandName), filePath, key);
    }

    private String readSource(Path filePath) throws IOException{
        return fileService.read(filePath);
    }

    private void runEncrypt(Command command){
        String stringText = "";
        Text text;
        try {
            stringText = readSource(command.getFilePath());
        } catch (IOException e){
            System.out.println("Can't read file");
        } finally {
            text = new Text(stringText, languageProcessor.determinateLanguage(stringText));
        }

        String encryptedText = cipher.encrypt(text, command.getKey());
        Path newPath = fileService.addFileNameAnnotation(command.getFilePath(),
                CommandType.ENCRYPT.getFileSuffix());

        try {
            fileService.write(newPath, encryptedText);
        } catch (IOException e) {
            System.out.println("Can't write in file");
            e.printStackTrace();
        }
    }

    private void runDecrypt(Command command){
        String stringText = "";
        Text text;
        try {
            stringText = readSource(command.getFilePath());
        } catch (IOException e){
            System.out.println("Can't read file");
        } finally {
            text = new Text(stringText, languageProcessor.determinateLanguage(stringText));
        }

        String decryptedText = cipher.decrypt(text, command.getKey());
        Path newPath = fileService.addFileNameAnnotation(command.getFilePath(),
                CommandType.DECRYPT.getFileSuffix());

        try {
            fileService.write(newPath, decryptedText);
        } catch (IOException e) {
            System.out.println("Can't write in file");
            e.printStackTrace();
        }
    }

    private void runBruteForce(Command command){
        String stringText = "";
        Text text;
        try {
            stringText = readSource(command.getFilePath());
        } catch (IOException e){
            System.out.println("Can't read file");
        } finally {
            text = new Text(stringText, languageProcessor.determinateLanguage(stringText));
        }

        String bruteForcedText = attack.execute(text);
        Path newPath = fileService.addFileNameAnnotation(command.getFilePath(),
                CommandType.BRUTE_FORCE.getFileSuffix());

        try {
            fileService.write(newPath, bruteForcedText);
        } catch (IOException e) {
            System.out.println("Can't write in file");
            e.printStackTrace();
        }
    }

}
