package page;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import request.Requsetmap;
import respones.Inputouptinterface;

public class Admin implements Inputouptinterface{
	public Admin() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public long getoutlen() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public long getinlen() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public BufferedInputStream getBufferedInputStream() throws IOException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void setbufferedInputStream(Requsetmap requestmap) throws IOException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public BufferedOutputStream getbufferedOutputStream() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void setbufferedOutputStream(Requsetmap requestmap) {
		// TODO �Զ����ɵķ������
		
	}

}
