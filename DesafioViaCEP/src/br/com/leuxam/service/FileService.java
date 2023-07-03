package br.com.leuxam.service;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    public static void writeArchiveWithJson(String nameFile, String json) throws IOException {
        FileWriter writer = new FileWriter(nameFile + ".json");
        writer.write(json);
        writer.close();
    }
}
