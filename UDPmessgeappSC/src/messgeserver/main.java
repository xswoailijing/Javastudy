package messgeserver;
import java.awt.Frame;
import java.net.SocketException;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) throws SocketException {
		new LinuxMessgeService().startservice();
		System.err.println("服务器已启动");
	}

}
