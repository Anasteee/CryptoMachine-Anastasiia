package org.javarush.anastasiia.command;

public enum CommandType {

    ENCRYPT("[ENCRYPTED]"),
    DECRYPT("[DECRYPTED]"),
    BRUTE_FORCE("[HACKED]");

    final String fileSuffix;

    CommandType(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }
}
