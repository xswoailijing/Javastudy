package messgeserver;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import messgeclient.Client;
import messgeclient.Clientinfo;
public abstract class MessgeService {
	DatagramSocket serverSocket;
	DatagramPacket receivePacket;
	DatagramPacket sendPacket;
	byte[] container;
	byte[] data;
	String messge;
	int datasize;
	Client client;
	Clientinfo clientinfo;
	public abstract void startservice();
	public abstract void stopservice();
	public abstract void writeofdb() throws UnsupportedEncodingException;
	public abstract void readofdb();
	public abstract void send() throws IOException;
	public abstract void shutdownservice();
	public abstract void packdata(String string) throws UnsupportedEncodingException;
	public abstract void close();
}
class  LinuxMessgeService extends MessgeService{
	public LinuxMessgeService() throws SocketException {
		this.serverSocket=new DatagramSocket(10086);
		System.err.println("构建接服务器链接");
	}
	public void startservice(){	
		//启动服务器线程
		new Serverthread().start();		
	}
	class Serverthread extends Thread{
		public void run() {	
			while (true) {
				try {
					receive();
					writeofdb();
					packdata("0");
					send();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (SocketException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}	
			}	
		}
	}
	public void stopservice() {
		//暂停服务
	}
	public void writeofdb() throws UnsupportedEncodingException {
		//将接收的数据保存到db
		String res = null;
		res = new String(this.data,0,this.datasize,"gbk");
		System.err.printf("保存数据到db,数据%s,%s长度\n",res,this.datasize);	
	}
	public void readofdb() {
		//读取数据库数据
	}
	public void shutdownservice() {
		//关闭服务器服务
	}
	@Override
	public void send() throws IOException {
		//发送数据
			serverSocket.send(sendPacket);
			System.err.println("服务器发送数据");
	}
	@Override
	public void close() {
		//关闭服务连接
		serverSocket.close();
		System.err.println("服务连接已关闭");
	}
	public void receive() throws IOException {
		//接收解包数据放入容器//解包
	this.container=new byte[1000];
	this.receivePacket=new DatagramPacket(container, container.length);
	serverSocket.receive(receivePacket);
	this.data=receivePacket.getData();
	this.datasize=receivePacket.getLength();	
	}	
	public void packdata(String messge) throws UnsupportedEncodingException {
	//打包数据要发送的数据
	this.messge=(new String(this.data,0,datasize,"gbk"))+"用户id:"+messge;
	this.sendPacket=new DatagramPacket
	(this.messge.getBytes(),this.messge.getBytes().length,new
			InetSocketAddress(clientinfo.getClientaddress(),10000));
	}
	
}