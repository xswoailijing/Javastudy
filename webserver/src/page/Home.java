package page;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import map.Mapinterfece;
import request.Requsetmap;
import respones.Inputouptinterface;

public class Home implements Inputouptinterface {
	BufferedInputStream bufferedInputStream;
	StringBuilder stringBuilder=new StringBuilder();
long len=0;
int l=0;
byte[] b=new byte[400000];
	@Override
	public long getoutlen() {
		// TODO �Զ����ɵķ������
		return 0;
	}
	@Override
	public long getinlen() {
		return len;
		
	}
	@Override
	public BufferedInputStream getBufferedInputStream() throws IOException {
		return bufferedInputStream;
	}
	@Override
	public void setbufferedInputStream(Requsetmap requestmap) throws IOException {
		File path=new File(Mapinterfece.resmap.get("path"));
		File[] pagelist=path.listFiles();
		for (File file : pagelist) {
			if (file.getName().equals("test.html")||
				file.getName().equals("index.html")||
				file.getName().equals("home.html")) {
				len=file.length();
				@SuppressWarnings("resource")
				BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
				String string =new String() ;
				while (null!=(string=bufferedReader.readLine())) {
					stringBuilder.append(string);
				}
				bufferedInputStream =new BufferedInputStream(
						new ByteArrayInputStream(stringBuilder.toString().getBytes()));
				this.len=stringBuilder.toString().getBytes().length;
				

			}
		}
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
