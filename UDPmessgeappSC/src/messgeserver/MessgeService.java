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
		System.err.println("�����ӷ���������");
	}
	public void startservice(){	
		//�����������߳�
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}	
			}	
		}
	}
	public void stopservice() {
		//��ͣ����
	}
	public void writeofdb() throws UnsupportedEncodingException {
		//�����յ����ݱ��浽db
		String res = null;
		res = new String(this.data,0,this.datasize,"gbk");
		System.err.printf("�������ݵ�db,����%s,%s����\n",res,this.datasize);	
	}
	public void readofdb() {
		//��ȡ���ݿ�����
	}
	public void shutdownservice() {
		//�رշ���������
	}
	@Override
	public void send() throws IOException {
		//��������
			serverSocket.send(sendPacket);
			System.err.println("��������������");
	}
	@Override
	public void close() {
		//�رշ�������
		serverSocket.close();
		System.err.println("���������ѹر�");
	}
	public void receive() throws IOException {
		//���ս�����ݷ�������//���
	this.container=new byte[1000];
	this.receivePacket=new DatagramPacket(container, container.length);
	serverSocket.receive(receivePacket);
	this.data=receivePacket.getData();
	this.datasize=receivePacket.getLength();	
	}	
	public void packdata(String messge) throws UnsupportedEncodingException {
	//�������Ҫ���͵�����
	this.messge=(new String(this.data,0,datasize,"gbk"))+"�û�id:"+messge;
	this.sendPacket=new DatagramPacket
	(this.messge.getBytes(),this.messge.getBytes().length,new
			InetSocketAddress(clientinfo.getClientaddress(),10000));
	}
	
}