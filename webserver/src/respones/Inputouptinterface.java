package respones;
/**
 * 
 * ����ӿ��������úͷ������и��ݿͻ����󷵻صķ����������ͳ��ȣ�
 * 
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import request.Requsetmap;
public interface Inputouptinterface {
	public abstract long getoutlen();
	public abstract long getinlen();
	public abstract BufferedInputStream getBufferedInputStream() throws IOException ;
	public abstract void setbufferedInputStream(Requsetmap requestmap) throws IOException ; 
	public abstract BufferedOutputStream getbufferedOutputStream() ;
	public abstract void setbufferedOutputStream(Requsetmap requestmap); 
}
