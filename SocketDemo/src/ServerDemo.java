import java.io.*;
import java.io.IOException;
import java.net.*;

/**
 * TCP服务器端程序
 * 
 * @author Administrator
 * 
 */
public class ServerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个服务器端Socket
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("服务器已启动,正在等待连接...");
			Socket socket = server.accept();// 等待客户端连接,会阻塞
			String info="信件已发出,请注意查收...";
			//构造一个字符输出流
			BufferedWriter  bw= new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			bw.write(info);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
