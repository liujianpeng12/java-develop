package com.vince;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {

	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		try {
			Socket socket=new Socket("127.0.0.1",9999);
			System.out.println("连接服务器成功");
			
			System.out.println("请输入登录名:");
			String srcName=in.next();
			Info info=new Info(srcName, "", "", 1);
			
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(info);
			
			//启动接收消息的线程
			new Thread(new ReceiverThread(socket)).start();
			
			while(true){
				System.out.println("请输入要发送信息的用户名:");
				String destName=in.next();
				System.out.println("请输入发送信息:");
				String msg=in.next();
				info=new Info(srcName, destName, msg, 2);
				oos.writeObject(info);
				oos.flush();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ReceiverThread implements Runnable{
	private Socket socket;
	private boolean flag;	

	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public ReceiverThread(Socket socket)
	{
		this.socket=socket;
		flag=true;
	}
	
	@Override
	public void run() {
		try {			
			while(flag){		
				ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
				Info info=(Info)ois.readObject();
				System.out.println(info.getSrcName()+" 对 "+info.getDestName()+" 说:"+info.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
