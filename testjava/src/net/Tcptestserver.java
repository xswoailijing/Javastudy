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
	//���һ���̳߳�
	ArrayList<Tcptestserver> th=new ArrayList<Tcptestserver>();
	public Tcptestserver() {
	
	}
	public void startserver() throws IOException {
		//����˶˿ڴ�
		this.serverSocket=new ServerSocket(10086);
		System.err.println("����˿ڴ�");
	}
	public static void main(String[] args) throws IOException  {
		
	Tcptestserver tcptestserver=new Tcptestserver();
	tcptestserver.startserver();
	tcptestserver.run();
	
	}
	@Override
	public void run() {
		while (true) {
			//����һ���ͻ���ͨ��,�������������ʽ�ģ�û�л�ȡ���ͻ���������
			//����һ���Զ����ɵĶ��̹߳ܵ�.ÿ����һ���ͻ�����һ���ܵ��߳�
			try {
				Socket socket =serverSocket.accept();
				new Thread(this).start();//�̳߳ػ�Ҫ�Ľ�..
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				DataInputStream	dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream.writeLong(new Date().getTime());
				dataOutputStream.writeUTF("��������Ӧ...\n");
				dataOutputStream.flush();
				System.err.printf("%s\n",dataInputStream.readUTF());
			} catch (IOException e) {
				System.err.println("�������ݵ��ͻ���ʧ��");
				e.printStackTrace();	
			}
			//��취����һ����ʱflag
		}
	}

}
