package request;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
public class MyRequest {
	public String request = "";
	public Requsetmap requsetmap;
	public Socket socket;
	int length = 0;
	byte[] b = new byte[20480];
	DataInputStream dataInputStream;
	public MyRequest(Socket socket) throws IOException {
		this.socket=socket;
		dataInputStream = new DataInputStream(socket.getInputStream());
		length = dataInputStream.read(b, 0, b.length);
		if (length != -1) {
			request = new String(b, 0, length, "utf8");
			this.requsetmap=new Requsetmap(request,socket);
		}		
	}
}
