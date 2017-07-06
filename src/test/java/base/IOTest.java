package base;

import org.junit.Test;

import java.io.*;

/**
 * Created by mercop on 2017/7/4.
 */
public class IOTest {

    /**
     * RandomAccessFile 直接继承Object 不属于IO Streams
     *
     * @throws FileNotFoundException
     */
    @Test
    public void randomAccessFileTest() throws FileNotFoundException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("File.txt", "rw+");
    }

    @Test
    public void BufferedReaderTest() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("F:\\Windows2003 Key.txt") {
                }));
        String line = bufferedReader.readLine();
        System.out.println(line);
    }
}
