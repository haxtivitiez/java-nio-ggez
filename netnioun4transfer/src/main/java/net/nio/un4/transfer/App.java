package net.nio.un4.transfer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        try (
                RandomAccessFile input = new RandomAccessFile("sample.txt","r");
                FileChannel from = input.getChannel();
                RandomAccessFile output = new RandomAccessFile("sample-copy.txt","rw");
                FileChannel to = output.getChannel();
                ) {
            from.transferTo(0,from.size(),to);
        }


    }
}
