package net.nio.un4.socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MapCompare {

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        FileChannel ch1 = new RandomAccessFile("sample.txt","r").getChannel();
        FileChannel ch2 = new RandomAccessFile("sample-copy.txt","r").getChannel();

        if (ch1.size() != ch2.size()){
            System.out.println("File have different len");
        }

        long size = ch1.size();
        ByteBuffer m1 = ch1.map(FileChannel.MapMode.READ_ONLY,0L,size);
        ByteBuffer m2 = ch1.map(FileChannel.MapMode.READ_ONLY,0L,size);

        for (int pos =0;pos<size;pos++){
            if (m1.get(pos)!=m2.get(pos)){
                System.out.println("File differ at position:" + pos);
                return;
            }
        }

        System.out.println("File are identical, you can delete one of them.");

        long end = System.nanoTime();
        System.out.println("Execution Time: " + (end-start)/1000000 + " ms");
    }

}
