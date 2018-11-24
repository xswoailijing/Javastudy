package server;
import java.awt.Frame;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {

			try {
				new TCPLinuxMessgeService().startservice();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.err.println("服务器已启动");
	}

}
