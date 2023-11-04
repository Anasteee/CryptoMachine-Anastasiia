package org.javarush.anastasiia;

import java.io.*;

public class FileService {
    public static BufferedReader createFileReader(String filePath) throws IOException {
        try{
        File file = new File(filePath);
        return new BufferedReader(new FileReader(file));
        } catch (IOException e){
            System.out.println("An error occurred while creating a reader");
        }
        return null;
    }

    public static BufferedWriter createFileWriter(String filePath, Action action) {
        File newFile = createNewFile(filePath, action);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(newFile));
        } catch (IOException e){
            // TODO: FIX this
            System.out.println("Err");
        }

        return writer;
    }

    private static File createNewFile(String filePath, Action action){
        if (filePath.contains("DECRYPTED")){
            filePath = filePath.replace("DECRYPTED", action.toString());
        } else if (filePath.contains("ENCRYPTED")) {
            filePath = filePath.replace("ENCRYPTED", action.toString());
        } else {
            filePath = filePath.split("/")[1].split("\\.")[0] + "[" + action + "]";
        }
        return new File(filePath);
    }
}
