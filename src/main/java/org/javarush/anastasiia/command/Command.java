package org.javarush.anastasiia.command;

import java.nio.file.Path;

public class Command {

    private final CommandType type;
    private final Path filePath;
    private final int key;

    public Command(CommandType type, Path filePath, int key) {
        this.type = type;
        this.filePath = filePath;
        this.key = key;
    }

    public CommandType getType() {
        return type;
    }

    public Path getFilePath() {
        return filePath;
    }

    public int getKey() {
        return key;
    }
}
