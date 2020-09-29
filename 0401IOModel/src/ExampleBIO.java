import jdk.net.Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * https://www.cnblogs.com/tong-yuan/p/11886807.html
 * BIO 案例
 * BIO的使用方式非常简单，服务端接收到一个连接就启动一个线程来处理这个连接的所有请求。
 * 所以，BIO最大的缺点就是浪费资源，只能处理少量的连接，线程数随着连接数线性增加，连接越多线程越多，直到抗不住。
 */
public class ExampleBIO {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            System.out.println("开始监听");
            Socket socket = serverSocket.accept();
            System.out.println("新的连接请求:" + socket.getRemoteSocketAddress());

            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String msg;
                        while((msg = bufferedReader.readLine()) != null) {
                            if("quit".equalsIgnoreCase(msg)) {
                                bufferedReader.close();
                                socket.close();
                                break;
                            } else {
                                System.out.println("收到消息:" + msg);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
