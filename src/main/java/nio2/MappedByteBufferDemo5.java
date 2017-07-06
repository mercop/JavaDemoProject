package nio2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mercop on 2017/6/28.
 */
public class MappedByteBufferDemo5 {

    private  static  int SIZE =4*1024 * 1024;
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
        RandomAccessFile fileOp = null;
        FileChannel channel = null;
        setFileNameArray();
        long start = System.currentTimeMillis();
        for(String file : dataFileArray){
            fileOp = new RandomAccessFile(file,"r");
            channel = fileOp.getChannel();
            for(int i = 0 ;i < channel.size() / SIZE ;i++){
                MappedByteBuffer buffOp = channel.map(FileChannel.MapMode.READ_ONLY, i * SIZE, SIZE);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Mapped count " + 8 * channel.size() / SIZE );
        System.out.println(" MappedByteBuff map need "+ (end-start)+" ms!");
    }

}
