package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public abstract class MessgeService {
	//UDP端口
	DatagramSocket UDPserverSocket;
//	UDP发送包容器
	DatagramPacket UDPreceivePacket;
//	UDP接收包容器
	DatagramPacket UDPsendPacket;
//	UDP打包容器
	byte[] container;
//	UDP接收容器
	byte[] data;
//	UDP接收信息容器
	String messge;
//	UDP接收信息长度
	int datasize;
//	TCP端口
	ServerSocket TCPserverSocket;
//	客户信息
	Client client;
//	客户端信息
	Clientinfo clientinfo;
	public abstract void writeofdb() throws UnsupportedEncodingException;
	public abstract void send() throws IOException;
	public abstract void readofdb();
	public abstract void startservice() throws IOException;
	public abstract void stopservice();
	public abstract void send(String messge) throws IOException;
	public abstract void receive (Socket socket) throws IOException;
	public abstract void shutdownservice();
	public abstract void packdata(String string) throws UnsupportedEncodingException;
	public abstract void close();
}
class  UDPLinuxMessgeService extends MessgeService{
	public UDPLinuxMessgeService() throws SocketException {
		this.UDPserverSocket=new DatagramSocket(10086);
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
	public void send() {
		//发送数据
		try {
			UDPserverSocket.send(UDPsendPacket);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			System.err.println("服务器发送数据");			
	}
	@Override
	public void close() {
		//关闭服务连接
		UDPserverSocket.close();
		System.err.println("服务连接已关闭");
	}
	public void receive() throws IOException {
		//接收解包数据放入容器//解包
	this.container=new byte[1000];
	this.UDPreceivePacket=new DatagramPacket(container, container.length);
	UDPserverSocket.receive(UDPreceivePacket);
	this.data=UDPreceivePacket.getData();
	this.datasize=UDPreceivePacket.getLength();	
	}	
	public void packdata(String messge) throws UnsupportedEncodingException {
	//打包数据要发送的数据
	this.messge=(new String(this.data,0,datasize,"gbk"))+"用户id:"+messge;
	this.UDPsendPacket=new DatagramPacket
	(this.messge.getBytes(),this.messge.getBytes().length,new
			InetSocketAddress(clientinfo.getClientaddress(),10000));
	}
	@Override
	public void receive(Socket socket) throws IOException {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void send(String messge) throws IOException {
		// TODO 自动生成的方法存根
		
	}
	
}

class TCPLinuxMessgeService extends MessgeService{
//	TCP线程池
	List<Threadlist> threadlist=new ArrayList<Threadlist>();
//线程数
	int t=0;
	@Override
	public void startservice() throws IOException {
		this.TCPserverSocket =new ServerSocket(10086);
		new Threadlist().start();	
	}
class Threadlist extends Thread{
		//管道池
	private	Socket socket;
		public Threadlist() {
		}
		@Override
		public void run() {
				try {
//					等待客户端连接阻塞
					socket =TCPserverSocket.accept();
//					获取到客户端阻塞，为后面的新客户添加管道线程
					new Threadlist().start();
//					将连接线程加入线程池
					threadlist.add(this);
//					刷新消息
					while (true) {
					receive(socket);	
					}	
				} catch (IOException e) {
					//连接失败删除线程
					threadlist.remove(this);
					this.interrupt();
					System.err.println("发送数据到客户端失败关闭管道");
					e.printStackTrace();	
				}
				threadlist.remove(this);
				this.interrupt();
		}	
	}
	@Override
	public void receive(Socket socket)  {
//		接收消息到服务端
			
			try {
				DataInputStream	dataInputStream = new DataInputStream(socket.getInputStream());
				this.messge=dataInputStream.readUTF()+dataInputStream.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(messge);
			send(messge);
}
	@Override
	public void send(String messge)  {
		for (Threadlist thread : threadlist) {
				DataOutputStream dataOutputStream;
				try {
					dataOutputStream = new DataOutputStream(thread.socket.getOutputStream());
					dataOutputStream.writeLong(new Date().getTime());			
					dataOutputStream.writeUTF(messge);
					dataOutputStream.flush();	
				} catch (IOException e) {
					e.printStackTrace();
				}
//				遍历所有线程的管道发送消息到客户端

		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
public void send() {
		// TODO 自动生成的方法存根
		
	}	
@Override
public void stopservice() {
	// TODO 自动生成的方法存根
}

@Override
public void shutdownservice() {
	// TODO 自动生成的方法存根
	
}

@Override
public void packdata(String string) throws UnsupportedEncodingException {
	// TODO 自动生成的方法存根
	
}

@Override
public void close() {
	// TODO 自动生成的方法存根
}
@Override
public void writeofdb() throws UnsupportedEncodingException {
	// TODO 自动生成的方法存根
	
}

@Override
public void readofdb() {
	// TODO 自动生成的方法存根
	
}

}