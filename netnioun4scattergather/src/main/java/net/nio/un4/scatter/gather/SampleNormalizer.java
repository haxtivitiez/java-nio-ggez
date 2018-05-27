package net.nio.un4.scatter.gather;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SampleNormalizer {

    public static void main(String[] args) throws IOException {
        final List<String> lines = new LinkedList<>();
        try (final BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            int i = 1;
            while ((line = reader.readLine()) != null) {
                StringBuilder padded = new StringBuilder(line);
                padded.delete(76, padded.length());
                while (padded.length() < 76) {
                    padded.append(" ");
                }
                line = padded.toString();
                if (padded.length() == 76) {
                    padded.append(String.format("%04d", i++));
                }
                lines.add(padded.append("\n").toString());
            }
        }
        try (FileWriter fw = new FileWriter("sample.txt")){
            for (final String line : lines){
                fw.write(line);
            }
        }
    }
}