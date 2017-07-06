package nio2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mercop on 2017/6/28.
 */
public class MappedByteBufferDemo {

    private  static  int SIZE =1*1024*1024 * 1024;
    public static void main(String[] args) throws IOException {
        File file = new File("/home/mercop/1.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile fileOp = new RandomAccessFile(file,"rw");

        FileChannel channel = fileOp.getChannel();

        long start = System.currentTimeMillis();
        MappedByteBuffer buffOp = channel.map(FileChannel.MapMode.READ_ONLY, 0, SIZE);
        long end = System.currentTimeMillis();
        System.out.println("MappedByteBuff map need "+ (end-start)+" ms!");

        byte[] buf = new byte[SIZE];
        int len = SIZE;
        start = System.currentTimeMillis();
        int pos = 0;
        while(pos < len - 1){
            buffOp.position(pos);
            buffOp.get(buf);
            pos += SIZE;
        }

        end = System.currentTimeMillis();
        System.out.println("MappedByteBuff read 128M use " +(end-start)+"ms!");

        buffOp.force();
    }

}
