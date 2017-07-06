package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mercop on 2017/6/28.
 */
public class FileChannelDemo {
    private  static  int SIZE =8*1024*1024;

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\usr\\data\\1.txt");
        FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();
        byte[] buf = new byte[SIZE];
        int len = SIZE * 16;
        ByteBuffer byteBuffer = ByteBuffer.allocate(SIZE);
        long start = System.currentTimeMillis();
        int pos = 0;
        while(pos < len - 1){
//            /byteBuffer.position(0);
            byteBuffer = ByteBuffer.allocate(SIZE);
            fileChannel.position(pos);
            fileChannel.read(byteBuffer);
            pos += SIZE;

        }


        long end = System.currentTimeMillis();
        System.out.println("MappedByteBuff read 128M use " +(end-start)+"ms!");
    }
}
