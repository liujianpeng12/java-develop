import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * echo 客户端
 * @author Administrator
 *
 */
public class ClientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8000);
			System.out.println("连接服务器成功...");
			boolean flag=true;
			Scanner input=new Scanner(System.in);
			//获取输入输出流
			PrintStream ps=new PrintStream(
					new BufferedOutputStream(s.getOutputStream()));
			BufferedReader br=new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			while(flag){
				System.out.println("请输入:");
				String info=input.next();
				if(info.equals("bye")){
					flag=false;
				}
				ps.println(info);
				ps.flush();
				String re = br.readLine();
				System.out.println(re);
			}
			br.close();
			ps.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
