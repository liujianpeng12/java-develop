import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * https://www.cnblogs.com/tong-yuan/p/11886807.html
 * NIO 案例
 *
 * NIO，New IO，JDK1.4开始支持，内部是基于多路复用的IO模型。
 * 使用NIO则多条连接的数据准备阶段会阻塞在select上，数据从内核空间拷贝到用户空间依然是阻塞的
 * NIO最大的优点，就是一个线程就可以处理大量的连接，缺点是不适合处理阻塞性任务，因为阻塞性任务会把这个线程占有着，其它连接的请求将得不到及时处理。
 */
public class ExampleNIO {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        //将accept事件绑定到selector上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //阻塞在select上
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历selectKeys
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //如果是accept事件
                if(selectionKey.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = ssc.accept();
                    System.out.println("新的连接请求:" + socketChannel.getRemoteAddress());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if(selectionKey.isReadable()){
                    //如果是读取事件
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //将数据读入buffer中
                    int length = socketChannel.read(buffer);
                    if(length > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        //将数据读入byte数组中
                        buffer.get(bytes);

                        // 换行符会跟着消息一起传过来
                        String content = new String(bytes, "UTF-8").replace("\r\n", "");
                        if(content.equalsIgnoreCase("quit")) {
                            selectionKey.cancel();
                            socketChannel.close();
                        } else {
                            System.out.println("收到消息:" + content);
                        }
                    }
                }
                iterator.remove();
            }
        }
    }
}
