package net.nio.un4.socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SampleCompare {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream("sample.txt"));
        BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream("sample-copy.txt"));

        int b1=0,b2=0,pos=1;
        while (b1 != -1 && b2 != -1){
            if(b1!=b2){
                System.out.println("File differ at position:" + pos);
            }
            pos++;
            b1 = fis1.read();
            b2 = fis2.read();
        }
        if(b1!=b2){
            System.out.println("File have different len");
        }
        fis1.close();
        fis2.close();
        long end = System.nanoTime();
        System.out.println("Execution Time: " + (end-start)/1000000 + " ms");
    }
}
