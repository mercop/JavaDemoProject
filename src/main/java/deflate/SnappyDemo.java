package deflate;

import org.junit.Test;
import org.xerial.snappy.Snappy;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mercop on 2017/6/23.
 */
public class SnappyDemo {

    @Test
    public void deflateTest() throws Exception {
        String fileName = "D:/Result.rs";
        FileChannel fileChannel = new RandomAccessFile(fileName, "r").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());

        fileChannel.read(byteBuffer);
        byte[] bytes = new byte[byteBuffer.position()];
        byteBuffer.flip();
        byteBuffer.get(bytes);

        byte[] compressed = Snappy.compress(bytes);
        byte[] uncompressed = Snappy.uncompress(compressed);
    }
}
