package net;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;
public class Tcptestclient {
	public static void main(String[] args) throws IOException, InterruptedException {
		new Tcptestclient().name(args);
	}
public void name(String[] args) throws IOException, InterruptedException {
	//�ͻ���
	Socket clientSocket=new Socket("192.168.2.100",10086);
	Thread thread=new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				DataInputStream dataInputStream;
				dataInputStream = new DataInputStream(clientSocket.getInputStream());
				while (true) {
					System.err.println(new Date(dataInputStream.readLong()));
					System.err.println(dataInputStream.readUTF());
					Thread.sleep(1000);
				}	
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	});
	thread.start();
	while (true) {
		DataOutputStream dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());
		dataOutputStream.writeLong(1003);
		dataOutputStream.writeUTF(new BufferedReader(new InputStreamReader(System.in)).readLine());
	}
	
}
}
