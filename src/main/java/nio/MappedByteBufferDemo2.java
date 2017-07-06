package nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mercop on 2017/6/28.
 */
public class MappedByteBufferDemo2 {

    private  static  int SIZE =4*1024*1024;

    private static int MAXSIZE = 1024 * 1024 * 1024 * 5;
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("D:\\1.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile fileOp = new RandomAccessFile(file,"rw");

        FileChannel channel = fileOp.getChannel();

        long start = System.currentTimeMillis();
        MappedByteBuffer buffOp = channel.map(FileChannel.MapMode.READ_WRITE, 0, MAXSIZE);
        long end = System.currentTimeMillis();
        System.out.println("MappedByteBuff map need "+ (end-start)+" ms!");
       /* byte[] buf = new byte[SIZE];
        int len = SIZE;
        start = System.currentTimeMillis();
        int pos = 0;
        while(pos < len - 1){
            buffOp.position(pos);
            buffOp.get(buf,0,SIZE);
            pos += SIZE;
        }

        end = System.currentTimeMillis();
        System.out.println("MappedByteBuff read 128M use " +(end-start)+"ms!");

        buffOp.force();*/
    }

}
