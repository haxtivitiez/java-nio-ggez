package net.nio.un4.socket;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class SampleMaker {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024 * 1024 * 10];
        try(FileOutputStream fos = new FileOutputStream("temp.txt")){
            Random random = new Random();
            for (int i=0;i<16;i++){
                random.nextBytes(buffer);
                fos.write(buffer);
            }
        }
    }
}
