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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			System.err.println("������������");
	}

}
