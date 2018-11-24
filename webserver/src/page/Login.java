package page;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import request.Requsetmap;
import respones.Inputouptinterface;
public class Login implements Inputouptinterface {
	BufferedInputStream bufferedInputStream;
	Requsetmap requestmap;
	String data;
	long len;
	public Login() {
	}
	@Override
	public void setbufferedInputStream(Requsetmap requestmap) throws IOException {
		this.requestmap=requestmap;
		String name="uname";
		if (this.requestmap.requestmap.containsKey(name)) {
			if (this.requestmap.getrequestmapdata(name)==null||this.requestmap.getrequestmapdata(name).equals("")) {
				this.data="请输入密码";
				return;
			}else {
				if (this.requestmap.getrequestmapdata(name).equals(name)) {
					this.data="登录成功";
					return;
				}else {
					this.data="passwd error";
					return;
				}
			}
		}else {
			this.data="登录失败";
		}
	}
	@Override
	public BufferedInputStream getBufferedInputStream() throws IOException {
		
		return bufferedInputStream=new BufferedInputStream(
		new ByteArrayInputStream(data.getBytes(),0,data.getBytes().length)); 
	}
	@Override
	public long getoutlen() {
		return (long)data.getBytes().length;
	}
	@Override
	public long getinlen() {
		// TODO �Զ����ɵķ������
		return (long)data.getBytes().length;
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
