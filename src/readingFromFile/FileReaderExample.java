package readingFromFile;

import java.io.*;
import java.util.*;

/** FileReaderExample. Demonstrates how to read from the file
 *  using a BufferedReader
 */
public class FileReaderExample {

    public static void readFromFile(String filename) {
        try (FileReader f = new FileReader(filename);
             BufferedReader br = new BufferedReader(f)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("No such file");
        }
    }
    public static void main(String[] args) {
        readFromFile("song.txt");
    }

}
