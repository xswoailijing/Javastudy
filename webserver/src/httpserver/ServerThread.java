package httpserver;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import request.MyRequest;
import respones.MyRespones;
/**
 * ����http�����̴߳�����������������
 * ���ݿͻ����󴴽��߳�
 * @author Administrator
 *
 */
public class ServerThread {
	ServerSocket serverSocket;
	// �ͻ������̳߳�
	List<ResponesThread> threadlist = new ArrayList<ResponesThread>();
	public ServerThread(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		new ResponesThread().start();
	}
	class ResponesThread extends Thread {
		public void run() {
			try {
				// �ȴ��ͻ�����������
				Socket socket = serverSocket.accept();
				System.out.println("Client call on...");
				// ��ȡ���ͻ���������Ϊ������¿ͻ���ӹܵ��߳�
				new ResponesThread().start();
				// �������̼߳����̳߳�
				threadlist.add(this);
				//ѭ�����շ�������.
				while (true) {
					MyRequest myRequest = new MyRequest(socket);
					if (myRequest.request==null||myRequest.request.equals("")) {
						break;
					}
					System.err.println(myRequest.request);
					new MyRespones(myRequest);
				}
			} catch (IOException e) {
				e.printStackTrace();
				threadlist.remove(this);
				this.interrupt();
			} catch (SAXException e) {
				e.printStackTrace();
				threadlist.remove(this);
				this.interrupt();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				threadlist.remove(this);
				this.interrupt();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				threadlist.remove(this);
				this.interrupt();
			} catch (InstantiationException e) {
				e.printStackTrace();
				threadlist.remove(this);
				this.interrupt();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				threadlist.remove(this);
				this.interrupt();
			}finally {
				threadlist.remove(this);
				this.interrupt();
			}
		}
	}
	public void stop() {

	}

}
