package academy.devdojo.maratonajava.javacore.Vio.test;

// File
// FileWriter
// FileReader
// BufferedWriter
// BufferedReader

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file,true)){
            fw.write("O DevDojo é o lindo, é o melho curso do Brasillllllllll.\nContinuando a cantoria na proxima linha.\n");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
