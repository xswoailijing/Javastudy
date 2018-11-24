package client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.MessgeService;

public abstract class ClientLinkService {	
	DatagramSocket clientSocket;
	DatagramPacket sendPacket;
	DatagramPacket receicePacket;
	Client client;
	Clientinfo clientinfo;
	byte[] container;
	byte[] data;
	String messge;
	int datasize;
	//释放连接
	public abstract void closeclient() throws IOException;		
	//打包数据
	public abstract void packdata();
	//登录方法，不建议放在发送与接收类里面容易产生调用冲突
	public abstract boolean login(String string, String string2) throws IOException;
	//发送数据
	public abstract void sendmessge(String string) throws IOException ;
	public abstract void send() throws IOException ;
	//解包数据
	public abstract void receive() throws UnsupportedEncodingException, IOException;
	//初始化客户端
}
class MessgeClient extends ClientLinkService {
	public MessgeClient() throws SocketException {
		clientSocket=new DatagramSocket(this.clientinfo.getClientprot());
	}
	@Override
	public void sendmessge(String string) throws IOException{
			this.messge=string;
			packdata();
			clientSocket.send(this.sendPacket);
	}
	@Override
	public void closeclient() {
		clientSocket.close();
	}
	@Override
	public void packdata() {
		String string=(client.id+client.name+client.password+this.messge);
		this.data=string.getBytes();
		this.sendPacket=new DatagramPacket
		(data,data.length,new InetSocketAddress
		(clientinfo.getServeraddress(),clientinfo.getServerprot()));
	}
	@Override
	public void receive() throws IOException {
			//接收解包数据放入容器
		container =new byte[1000];
		receicePacket=new DatagramPacket(container, container.length);
		this.clientSocket.receive(this.receicePacket);
		this.data=this.receicePacket.getData();
		this.datasize=this.receicePacket.getLength();
		this.messge=new String(this.data,0,this.datasize,"utf8");
		System.err.println(messge);
	}
	@Override
	public boolean login(String string,String string2) throws IOException {
		
		client.name=string;
		client.password=string2;
		packdata();
		send();
		receive();
		client.id="";
			closeclient();
			new ClientGUIMessgeWindow(client, clientinfo).showwindow();
			return true;					
	}
	@Override
	public void send() throws IOException {
		clientSocket.send(sendPacket);
	}	
}
class TcpMessgeClient extends ClientLinkService {
	Socket clientSocket;
	public TcpMessgeClient(Client client) throws UnknownHostException, IOException {
	super();
	this.client=client;
	clientSocket=new Socket("192.168.2.100",10086);
	}
	public TcpMessgeClient() throws UnknownHostException, IOException {
	clientSocket=new Socket("192.168.2.100",10086);	
	}
	@Override
	public boolean login(String string, String string2) throws IOException {
		client =new Client();
		client.id=string;
		client.password=string2;
		client.name="id";
		this.messge="进入聊天室！";
		sendmessge(this.messge);
		new ClientGUIMessgeWindow(client, clientinfo).showwindow();
		return true;	
	}
	@Override
	public void sendmessge(String string) throws IOException {
			DataOutputStream dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());
			dataOutputStream.writeUTF(client.id);
			dataOutputStream.writeUTF(string);
	}
	@Override
	public void receive() throws UnsupportedEncodingException, IOException {
					DataInputStream dataInputStream;
					dataInputStream = new DataInputStream(clientSocket.getInputStream());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
					this.messge=sdf.format(new Date(dataInputStream.readLong()))+"\n"
					+dataInputStream.readUTF()+"\n";
	}
	public void send() throws IOException {
		
	}
	@Override
	public void closeclient() throws IOException {
		clientSocket.close();
		
	}
	@Override
	public void packdata() {
		// TODO 自动生成的方法存根	
	}
}

