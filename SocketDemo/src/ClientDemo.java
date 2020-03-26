import java.io.*;
import java.io.IOException;
import java.net.*;

public class ClientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个客户端Socket
		try {
			Socket socket=new Socket("127.0.0.1",8888);
			System.out.println("连接已建立...");
			
			BufferedReader br=new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String info=br.readLine();
			System.out.println(info);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
