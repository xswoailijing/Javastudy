package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.print.attribute.standard.RequestingUserName;

import org.omg.CORBA.Request;

public class URLtest {
	public URLtest() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public void name() {
		
		try {
			URL url=new URL("http://www.baidu.com:80");
			try {
				InputStream stream=url.openStream();
				//����url���ֽ�������utf8���� ���ַ���.
				BufferedReader bR=
			new BufferedReader(new InputStreamReader(stream,"utf8"));
				
				byte[] b=new byte[9999];
				String l=null;
				while ((l=bR.readLine())!=null) {
					
					System.err.println();
				}
				System.out.println(l);
				stream.close();
				
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
