package messgeclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

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
	//�ͷ�����
	public abstract void closeclient();		
	//�������
	public abstract void packdata();
	//��¼��������������ڷ�����������������ײ������ó�ͻ
	public abstract boolean login(String string, String string2) throws IOException;
	//��������
	public abstract void sendmessge(String string) throws IOException ;
	public abstract void send() throws IOException ;
	//�������
	public abstract void receive() throws UnsupportedEncodingException, IOException;
	//��ʼ���ͻ���
}
class MessgeClient extends ClientLinkService {
	public MessgeClient(Clientinfo clientinfo) throws SocketException {
		this.clientinfo=clientinfo;
		this.client=new Client();
		clientSocket=new DatagramSocket(this.clientinfo.getClientprot());
	}
	public MessgeClient(Clientinfo clientinfo, Client client) throws SocketException {
		this.clientinfo=clientinfo;
		this.client=client;
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
			//���ս�����ݷ�������
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
		client.id=this.messge;
			closeclient();
			new ClientGUIMessgeWindow(client, clientinfo).showwindow();
			return true;					
	}
	@Override
	public void send() throws IOException {
		clientSocket.send(sendPacket);
	}	
}