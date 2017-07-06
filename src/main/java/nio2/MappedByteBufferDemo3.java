package nio2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mercop on 2017/6/28.
 */
public class MappedByteBufferDemo3 {

    private  static  int SIZE =16*1024 * 1024;
    private  static String DATA_HOME = "/home/mercop/data";
    private static String[] dataFileArray;

    private static int dataFileIndex;
    private static void setFileNameArray(){
        String filePath = DATA_HOME;
        File directory = new File(filePath);
        if (!directory.isDirectory()){
            return;
        }
        dataFileArray = new String[8];
        for (int i=0; i < dataFileArray.length; i++){
            dataFileArray[i] = filePath + "/" + (i+1) + ".txt";
        }
        dataFileIndex = 0;

    }

    public static void main(String[] args) throws IOException {


        setFileNameArray();
        for(String file : dataFileArray){
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
            System.out.println("MappedByteBuff read " + file + "use " +(end-start)+"ms!");

        }
    }

}
