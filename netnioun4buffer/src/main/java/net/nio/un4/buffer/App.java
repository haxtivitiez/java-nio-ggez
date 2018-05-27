package net.nio.un4.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        final RandomAccessFile sampleFile = new RandomAccessFile("C:\\Users\\un4ckn0wl3z-level99\\IdeaProjects\\netnioun4buffer\\src\\main\\java\\net\\nio\\un4\\buffer\\sample.txt","rw");
        final FileChannel channel = sampleFile.getChannel();
        final ByteBuffer buffer = ByteBuffer.allocate(4098);
        int nrBytes = channel.read(buffer);
        while (nrBytes != -1){
            System.out.println("Read: " + nrBytes);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            nrBytes = channel.read(buffer);
        }
        sampleFile.close();
    }
}
