import java.io.*;
import java.net.*;

/**
 * echo 服务器端
 * 
 * @author Administrator
 * 
 */
public class ServerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建服务器端 socket
		try {
			ServerSocket ss = new ServerSocket(8000);
			System.out.println("服务器已启动");
			boolean flag = true;
			while (flag) {
				System.out.println("正在等待连接...");
				Socket s = ss.accept();
				//
				new Thread(new MultipleSocketThread(s)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MultipleSocketThread implements Runnable {

	private Socket s;

	public MultipleSocketThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			System.out.println(s.getInetAddress().getHostAddress() + " 已连接...");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			PrintStream ps = new PrintStream(new BufferedOutputStream(
					s.getOutputStream()));
			boolean bool = true;
			while (bool) {// 循环接收数据
				String info = br.readLine();
				if (info.equals("bye")) {
					bool = false;
				}
				System.out.println(info);
				ps.println("echo:" + info);
				ps.flush();
			}
			ps.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
