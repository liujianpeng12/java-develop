import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * https://www.cnblogs.com/tong-yuan/p/11886807.html
 * AIO 案例
 *
 * AIO的使用方式不算太复杂，默认会启一组线程来处理用户的请求，而且如果在处理阻塞性任务，还会自动增加新的线程来处理其它连接的任务。
 * AIO最大的优点，就是少量的线程就可以处理大量的连接，而且可以处理阻塞性任务，但不能大量阻塞，否则线程数量会膨胀。
 */
public class ExampleAIO {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //监听accept事件
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                try {
                    System.out.println("新的连接请求:" + socketChannel.getRemoteAddress());
                    //再次监听accept事件
                    serverSocketChannel.accept(null, this);

                    //消息处理
                    while (true) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //将数据读入于是buffer
                        Future<Integer> future =  socketChannel.read(buffer);
                        if(future.get() > 0) {
                            buffer.flip();
                            byte[] bytes = new byte[buffer.remaining()];
                            ///将数据读入byte数组
                            buffer.get(bytes);

                            String content = new String(bytes, "UTF-8").replace("\r\n", "");
                            //换行符当成另一条消息传过来
                            if(content.equalsIgnoreCase("\r\n")) {
                                continue;
                            }
                            if("quit".equalsIgnoreCase(content)){
                                socketChannel.close();
                                break;
                            } else {
                                System.out.println("收到消息:" + content);
                            }
                        }
                    }
                } catch (IOException | InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed");
            }
        });

        //阻塞住主线程
        System.in.read();
    }
}
