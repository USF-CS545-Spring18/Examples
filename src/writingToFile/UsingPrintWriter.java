package writingToFile;

import java.io.*;

/** A class that demonstrates how to write to a file
 *  using PrintWriter class.
 */
public class UsingPrintWriter {
    public static void main(String[] args) {
        // Will write each String from the array of strings
        // to a file named "output.txt"
        String[] words = {"I", "know", "how", "to", "write", "to", "a", "file"};
        printToFile(words,"output.txt");
    }

    /**
     * Output given words to the file with the given filename
     * @param words array of Strings
     * @param filename name of the output file
     */
    public static void printToFile(String[] words, String filename) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (String word: words) {
                pw.println(word);
            }
            pw.flush();

        }
        catch (IOException e) {
            System.out.println("Error writing to a file: "  + e);
        }

    }
}
