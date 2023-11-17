package org.javarush.anastasiia.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public boolean FileExists(Path filePath) {
        return Files.exists(filePath);
    }

    public String read(Path filePath) throws IOException {
        return new String(Files.readAllBytes(filePath));
    }

    public void write(Path path, String text) throws IOException {
        Files.writeString(path, text);
    }

    public Path addFileNameAnnotation(Path filePath, String annotation) {
        StringBuilder fileName = new StringBuilder(filePath.getFileName().toString());
        Path dir = filePath.getParent();

        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            fileName.insert(fileName.lastIndexOf("."), annotation);

            return dir.resolve(Path.of(fileName.toString()));
        }

        return null;
    }
}
