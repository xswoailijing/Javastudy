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
 * 基础http服务线程创建，创建基础服务
 * 根据客户请求创建线程
 * @author Administrator
 *
 */
public class ServerThread {
	ServerSocket serverSocket;
	// 客户连接线程池
	List<ResponesThread> threadlist = new ArrayList<ResponesThread>();
	public ServerThread(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		new ResponesThread().start();
	}
	class ResponesThread extends Thread {
		public void run() {
			try {
				// 等待客户端连接阻塞
				Socket socket = serverSocket.accept();
				System.out.println("Client call on...");
				// 获取到客户端阻塞，为后面的新客户添加管道线程
				new ResponesThread().start();
				// 将连接线程加入线程池
				threadlist.add(this);
				//循环接收返回数据.
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
