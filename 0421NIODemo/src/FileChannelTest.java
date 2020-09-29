import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liujp
 * @create 2020-09-29 11:49
 */
public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("\"D:\\\\Dev\\\\text.txt\"", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10);
        while (fileChannel.read(buffer) != -1) {
            // buffer切换为读模式
            buffer.flip();
        }
    }
}
