package nio2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mercop on 2017/6/28.
 */
public class MappedByteBufferDemo2 {

    private  static  int SIZE =16*1024 * 1024;
    public static void main(String[] args) throws IOException {
        File file = new File("/home/mercop/data/1.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile fileOp = new RandomAccessFile(file,"r");

        FileChannel channel = fileOp.getChannel();

        long start = System.currentTimeMillis();
        MappedByteBuffer buffOp = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        long end = System.currentTimeMillis();
        System.out.println("MappedByteBuff map need "+ (end-start)+" ms!");

        byte[] buf = new byte[SIZE];
        int len = (int)channel.size();
        start = System.currentTimeMillis();
        int pos = 0;
        while(true){
            buffOp.position(pos);
            if(pos + SIZE < len){

                buffOp.get(buf);
                pos += SIZE;
            }else{
                buffOp.get(buf,0,len - pos -1);
                break;
            }

        }

        end = System.currentTimeMillis();
        System.out.println("MappedByteBuff read File1 use " +(end-start)+"ms!");

        buffOp.force();
    }

}
