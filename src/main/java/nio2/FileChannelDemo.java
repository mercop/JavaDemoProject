package nio2;


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
            FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();
            byte[] buf = new byte[SIZE];
            int len = (int)fileChannel.size();
            ByteBuffer byteBuffer;
            long start = System.currentTimeMillis();
            int pos = 0;
            while(true){
                if(pos + SIZE < len){
                    byteBuffer = ByteBuffer.allocate(SIZE);
                    fileChannel.position(pos);
                    fileChannel.read(byteBuffer);
                    pos += SIZE;
                }else{
                    fileChannel.position(pos);
                    byteBuffer = ByteBuffer.allocate(len - pos -1);
                    fileChannel.read(byteBuffer);
                    break;
                }
                //System.out.println(pos);
            }
            long end = System.currentTimeMillis();
            System.out.println("filechannel read"+ file + " use " +(end-start)+"ms!");
        }


    }
}
