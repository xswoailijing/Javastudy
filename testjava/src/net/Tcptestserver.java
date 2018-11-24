package net;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Tcptestserver implements Runnable{
	ServerSocket serverSocket;
	//添加一个线程池
	ArrayList<Tcptestserver> th=new ArrayList<Tcptestserver>();
	public Tcptestserver() {
	
	}
	public void startserver() throws IOException {
		//服务端端口打开
		this.serverSocket=new ServerSocket(10086);
		System.err.println("服务端口打开");
	}
	public static void main(String[] args) throws IOException  {
		
	Tcptestserver tcptestserver=new Tcptestserver();
	tcptestserver.startserver();
	tcptestserver.run();
	
	}
	@Override
	public void run() {
		while (true) {
			//接收一条客户端通道,这个方法是阻塞式的，没有获取到就会阻塞程序。
			//创建一个自动生成的多线程管道.每接收一个客户创建一个管道线程
			try {
				Socket socket =serverSocket.accept();
				new Thread(this).start();//线程池还要改进..
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				DataInputStream	dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream.writeLong(new Date().getTime());
				dataOutputStream.writeUTF("服务器响应...\n");
				dataOutputStream.flush();
				System.err.printf("%s\n",dataInputStream.readUTF());
			} catch (IOException e) {
				System.err.println("发送数据到客户端失败");
				e.printStackTrace();	
			}
			//想办法设置一个超时flag
		}
	}

}
