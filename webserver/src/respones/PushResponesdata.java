package respones;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 * 
 * ���ڷ����Ѿ�����õ�������
 * 
 * @author Administrator
 *
 */
public class PushResponesdata {
	public StringBuilder hand;
	public Socket socket;
	public String code;
	BufferedInputStream bufferedInputStream;
	BufferedOutputStream bufferedOutputStream;
	public PushResponesdata(Socket socket,MyRespones myRespones) throws IOException {
		this.hand=myRespones.hand;
		this.bufferedInputStream=myRespones.bufferedInputStream;	
		this.socket=socket;
		responseconstream();
	}	
	public void responseconstream() throws IOException {
		byte[] bt = new byte[409600];
		int btlen = 0;
		bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
		bufferedOutputStream.write(hand.toString().getBytes(), 0, hand.toString().getBytes().length);
		while (-1 != (btlen = bufferedInputStream.read(bt))) {
			bufferedOutputStream.write(bt, 0, btlen);
		}
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
	}
}
