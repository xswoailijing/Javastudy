package page;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import request.Requsetmap;
import respones.Inputouptinterface;

public class Admin implements Inputouptinterface{
	public Admin() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public long getoutlen() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public long getinlen() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public BufferedInputStream getBufferedInputStream() throws IOException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setbufferedInputStream(Requsetmap requestmap) throws IOException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public BufferedOutputStream getbufferedOutputStream() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setbufferedOutputStream(Requsetmap requestmap) {
		// TODO 自动生成的方法存根
		
	}

}
