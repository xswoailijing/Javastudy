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
	//UDP�˿�
	DatagramSocket UDPserverSocket;
//	UDP���Ͱ�����
	DatagramPacket UDPreceivePacket;
//	UDP���հ�����
	DatagramPacket UDPsendPacket;
//	UDP�������
	byte[] container;
//	UDP��������
	byte[] data;
//	UDP������Ϣ����
	String messge;
//	UDP������Ϣ����
	int datasize;
//	TCP�˿�
	ServerSocket TCPserverSocket;
//	�ͻ���Ϣ
	Client client;
//	�ͻ�����Ϣ
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
	public void send() {
		//��������
		try {
			UDPserverSocket.send(UDPsendPacket);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			System.err.println("��������������");			
	}
	@Override
	public void close() {
		//�رշ�������
		UDPserverSocket.close();
		System.err.println("���������ѹر�");
	}
	public void receive() throws IOException {
		//���ս�����ݷ�������//���
	this.container=new byte[1000];
	this.UDPreceivePacket=new DatagramPacket(container, container.length);
	UDPserverSocket.receive(UDPreceivePacket);
	this.data=UDPreceivePacket.getData();
	this.datasize=UDPreceivePacket.getLength();	
	}	
	public void packdata(String messge) throws UnsupportedEncodingException {
	//�������Ҫ���͵�����
	this.messge=(new String(this.data,0,datasize,"gbk"))+"�û�id:"+messge;
	this.UDPsendPacket=new DatagramPacket
	(this.messge.getBytes(),this.messge.getBytes().length,new
			InetSocketAddress(clientinfo.getClientaddress(),10000));
	}
	@Override
	public void receive(Socket socket) throws IOException {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void send(String messge) throws IOException {
		// TODO �Զ����ɵķ������
		
	}
	
}

class TCPLinuxMessgeService extends MessgeService{
//	TCP�̳߳�
	List<Threadlist> threadlist=new ArrayList<Threadlist>();
//�߳���
	int t=0;
	@Override
	public void startservice() throws IOException {
		this.TCPserverSocket =new ServerSocket(10086);
		new Threadlist().start();	
	}
class Threadlist extends Thread{
		//�ܵ���
	private	Socket socket;
		public Threadlist() {
		}
		@Override
		public void run() {
				try {
//					�ȴ��ͻ�����������
					socket =TCPserverSocket.accept();
//					��ȡ���ͻ���������Ϊ������¿ͻ���ӹܵ��߳�
					new Threadlist().start();
//					�������̼߳����̳߳�
					threadlist.add(this);
//					ˢ����Ϣ
					while (true) {
					receive(socket);	
					}	
				} catch (IOException e) {
					//����ʧ��ɾ���߳�
					threadlist.remove(this);
					this.interrupt();
					System.err.println("�������ݵ��ͻ���ʧ�ܹرչܵ�");
					e.printStackTrace();	
				}
				threadlist.remove(this);
				this.interrupt();
		}	
	}
	@Override
	public void receive(Socket socket)  {
//		������Ϣ�������
			
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
//				���������̵߳Ĺܵ�������Ϣ���ͻ���

		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
public void send() {
		// TODO �Զ����ɵķ������
		
	}	
@Override
public void stopservice() {
	// TODO �Զ����ɵķ������
}

@Override
public void shutdownservice() {
	// TODO �Զ����ɵķ������
	
}

@Override
public void packdata(String string) throws UnsupportedEncodingException {
	// TODO �Զ����ɵķ������
	
}

@Override
public void close() {
	// TODO �Զ����ɵķ������
}
@Override
public void writeofdb() throws UnsupportedEncodingException {
	// TODO �Զ����ɵķ������
	
}

@Override
public void readofdb() {
	// TODO �Զ����ɵķ������
	
}

}